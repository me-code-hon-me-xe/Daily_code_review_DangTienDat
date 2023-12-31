# Daily_code_review_DangTienDat
## What I have learned on 4_7_2023
## 1. Java's Selction Statement
- There are two selection statement: **if** and **switch**
  ## if
     - **The if-else-if**
       - The if statement are executed from top -> down
       - Once one statement is executed, the rest are bypassed
       - If no statement are satisfied -> the final else statement will be executed
       ```java
       public class ifElseIf {
         static int i = 10;
         static int j = 10;
         static int k = 300;
         static int a, b, c, d;
     
         public static void main(String[] args) {
             if(j < 20) System.out.println("j condition have checked");
             else if(k > 100) System.out.println("k condition have checked");
             else if(i > 10) System.out.println("i condition have checked");
             else System.out.println("No condition is passed");
         }
       }
         // output: j condition have checked
       ```
  ## switch
     - Expression must be: byte, short, int, char
     - Case values must be unique
  ```java
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Book management website");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Update book information");
        System.out.println("4. Search for a book");
        System.out.println("5. Exit");

        System.out.println("Please Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Book is added");
                break;
            case 2:
                System.out.println("Book is removed");
                break;
            case 3:
                System.out.println("Book is updated");
                break;
            case 4:
                System.out.println("Searching for a book");
                break;
            case 5:
                System.out.println("Exiting!");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();
    }
  ```
    - **Nested switch**
## 2. Java's Iteration Statement        
- Java’s iteration statements are **for, while,** and **do-while**
- Before diving to While loop, let's check out the difference **++i, i++, --i, i--**
  - ++i will increase i by 1 and this operator will immidiately return the latest updated i
  - i++ will increase i by 1, however it only return the original i before it is incremented
  - -> Similar to --i and i--  
  ## while
  - For the while loop, we are going to check the output if we set the condition ++i and ++i.
    ```java
    // ++i
    public static void main(String[] args) {
      int x = 1, i = 2;
      while(++i <= 5)  // i = 3, 4, 5, 6 -> Out loop
        { 
          x *= i; // x = 3, 12, 60
        }
      System.out.println(x);
    }
    // output: 60
    ```

    ```java
    // i++
    public static void main(String[] args) {
      int x = 1, i = 2;
      while(i++ <= 5)  // new: i = 2, 3, 4, 5, 6 -> Out loop  old: i = 3, 4, 5, 6 
        { 
          x *= i; // new: x = 3, 12, 60, 360   old: x = 3, 12, 60
        }
      System.out.println(x);
    }
    // output: 360
    ```
  ## do-while
  - For the do-while loop, we are going to check the output if we set the condition ++i and ++i.
    ```java
    // ++i
    public static void main(String[] args) {
      int x = 1, i = 2;
      do
      {
        x *= i  // x = 2, 6, 24, 120
      }while(++i <= 5)  // i = 3, 4, 5, 6 -> Out loop
      System.out.println(x);
    }
    // output: 120
    ```

    ```java
    // i++
    public static void main(String[] args) {
      int x = 1, i = 2;
      do
      {
        x *= i  // new: x = 2, 6, 24, 120, 720  old: x = 2, 6, 24, 120
      }while(i++ <= 5)  // new: i = 2, 3, 4, 5, 6 -> Out loop  old: i = 3, 4, 5, 6 
      System.out.println(x);
    }
    // output: 360
    ```
    
## What I have learned on 5_7_2023
## Inheritence
## 1. Using Super
  - Super Keyword generally has two types of form -> **super()** and **super.methor[or variable]**
    ## Using super to Call Superclass Constructors
      - Before calling **super()** constructor, I am going to create a practical example with the supper **Book** class.
        ```java
        static class Book {
          private final String title;
          private final String author;
          private final int publicationYear;
  
          // construct clone of a Book object
          public Book(Book obj) {
              title = obj.title;
              author = obj.author;
              publicationYear = obj.publicationYear;
          }
  
          // constructor used when all field is filled
          public Book(String tl, String aut, int pby) {
              title = tl;
              author = aut;
              publicationYear = pby;
          }
  
          // Constructor used when all field is blank
          public Book() {
              title = "No defined title";
              author = "No defined author";
              publicationYear = 0;
          }
  
          @Override
          public String toString() {
              return "Book: " +
                      "title= " + title +
                      ", author= " + author +
                      ", publicationYear= " + publicationYear;
          }
        }
        ```
      - Next I am going to create a specific **Novel** subclass.
        ```java
        static class Novel extends Book {
          // we have different genre of Novel such as mystery, romance, science fiction, etc.
          private String genre;
  
          // construct clone of an object
          Novel(Novel obj) {
              super(obj);
          }
  
          // Constructor when all parameters are specified
          Novel(String tl, String aut, int pby, String genre) {
              super(tl, aut, pby); // call superclass constructor
              this.genre = genre;
          }
  
          // default constructor
          Novel() {
              super();
              genre = "mystery";
          }
  
          @Override
          public String toString() {
              return super.toString() + ", genre= " + genre;
          }
        }
        ```
      - Finally we are going to create objects with different types of **supper()** constructor.
        ```java
        static class DemoSuper {
          public static void main(String[] args) {
              Novel novel1 = new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic Fiction");
              Novel novel2 = new Novel();
              Novel novelClone = new Novel(novel1);
              System.out.println(novel1);
              System.out.println(novel2);
              System.out.println(novelClone);
          }
        }
        // This is the output:
        // Book: title= The Great Gatsby, author= F. Scott Fitzgerald, publicationYear= 1925,   genre= Classic Fiction
        // Book: title= No defined title, author= No defined author, publicationYear= 0, genre= mystery
        // Book: title= The Great Gatsby, author= F. Scott Fitzgerald, publicationYear= 1925, genre= null
        // The genre of the 3rd object output is null, because in the super() clone constructor, genre variable is not assigned -> return "null"
        ```
    ## Using super to Call Superclass Method or Variable
      - **Superclass super.method()**
        - Calling **supper.method()** could be helpful when you want to add more behavior of the superclass's method rather than completely replace it.
        - As you might notice, I have override method **toString()** in the supper **Book** class. Then in the **Novel** subclass, i want to add 1 more attribute **genre** to the override method **toString()** in subclass -> Instead of recalling default **toString()** method in the super class **Book**, I just need to call **super.toString()** and add my favorite attibutes.
          ```java
          // This is method in super class
          @Override
          public String toString() {
            return "Book: " +
                    "title= " + title +
                    ", author= " + author +
                    ", publicationYear= " + publicationYear;
          }

          // This is method in subclass
          @Override
          public String toString() {
              return super.toString() + ", genre= " + genre;
          }

          // Output: Book: title= The Great Gatsby, author= F. Scott Fitzgerald, publicationYear= 1925, genre= Classic Fiction
          ```
      - **Superclass super.variable**
        - When a subclass has a variable with the same name as a variable in the superclass, using **super.varable** would allow you to distinct the superclass's variable with the one in subclass.
        ```java
          static class Textbook extends Book {
              // A textbook have different kind of subject such as  mathematics, history, biology, etc.
              private final String subject;
              // Try to create a variable have the same name in Superclass
              private final String title;
              // Create a constructor when it is fulfilled
              Textbook(String tl, String aut, int pby, String subject) {
                  super.title = tl;
                  title = "SubclassTitle";
                  this.subject = subject;
              }
              void show() {
                  System.out.println("title in superclass: " + super.title);
                  System.out.println("title in subclass: " + title);
              }
          }
              // Create instance:
              // Textbook textbook1 = new Textbook("Chemistry", "John Smith", 1643, "Chemistry 101");
              // textbool1.show()
              // This is the output:
              // title in superclass: Chemistry
              // title in superclass: SubclassTitle
        ```
## What I have learned on 6_7_2023
## Enumerations, Authoboxing, and Annotations
## 1. Enumerations
  - ## **Enumeration Fundamentals**
    - **Enum** is a special data type along with other primitive data types such as (int, String, boolean) that allows its variable could be a set of predefined constants.
    - Because **Enum** contains all constant variables -> The name must be UPPERCASE.
    - An **enumeration value** can also be used to control a **switch** statement
    - Let's take a look through the example of different genres of Novel
    - First I am going to create **enum** class
      ```java
      // An enumeration of genre varieties
      enum NovelGenre {
        FICTION("fiction"),
        NON_FICTION("non_fiction"),
        SCIENCE_FICTION("science_fiction"),
        MYSTERY("mystery");
        private final String genre;
        NovelGenre(String genre) {
            this.genre = genre;
        }
        public String getGenre(){
            return genre;
        }
      }
      ```
    - Then I am going to create **Novel** class
      ```java
      // Class Novel
      static class Novel {
          private String title;
          private NovelGenre genre;
          // Constructor Novel
          Novel(String title, NovelGenre genre) {
              this.title = title;
              this.genre = genre;
          }
          // Get title of the novel
          String getTitle() {
              return title;
          }
          // Get genre of the novel
          NovelGenre getGenre() {
              return genre;
          }
          // Override the toString() method
          @Override
          public String toString() {
              return "Novel{" +
                      "title='" + title + '\'' +
                      ", genre=" + genre.getGenre() +
                      '}';
          }
          // use switch case to check 
          public static void printNovelType(Novel novel) {
              switch (novel.genre) {
                  case FICTION:
                      System.out.println(novel.getTitle() + " is a fiction novel.");
                      break;
                  case NON_FICTION:
                      System.out.println(novel.getTitle() + " is a non-fiction novel.");
                      break;
                  case SCIENCE_FICTION:
                      System.out.println(novel.getTitle() + " is a science-fiction novel.");
                      break;
                  case MYSTERY:
                      System.out.println(novel.getTitle() + " is a mystery novel.");
                      break;
              }
          }
          public static void main(String[] args) {
              Novel novel1 = new Novel("Pride and Prejudice", NovelGenre.FICTION);
              Novel novel2 = new Novel("Harry Potter", NovelGenre.SCIENCE_FICTION);
              System.out.println(novel1.toString());
              System.out.println(novel2.toString());
              printNovelType(novel1);
              printNovelType(novel2);
              // This is the output:
              //Novel{title='Pride and Prejudice', genre=fiction}
              //Novel{title='Harry Potter', genre=science_fiction}
              //Pride and Prejudice is a fiction novel.
              //Harry Potter is a science-fiction novel.
          }
      }
      ```
  - ## **The values( ) and valueOf( ) Methods**
    - The **values()** method returns an array that contains a list of the enumeration constants.
    - The **valueOf(String str)** return the value of enumeration constant of that string parameter.
      ```java
        public static void main(String[] args) {
          // use values()
          NovelGenre allGenre [] = NovelGenre.values();
          for (NovelGenre g : allGenre) {
              System.out.println(g);
          }
          // use valueOf()
          NovelGenre genre = NovelGenre.valueOf("FICTION");
          System.out.println("genre contains " + genre.getGenre());
        }
        // This is the output:
        // FICTION
        // NON_FICTION
        // SCIENCE_FICTION
        // MYSTERY
        // genre contains fiction
      ```
  - ## **Treating Java Enumerations as Class Types**
    - Each enumeration constant is an **object** of its **enumeration type**
    - When we define a constructor for an enum, the constructor is called when each constants is invoked
      ```java
      // An enumeration of genre varieties
      enum NovelGenre {
        FICTION("fiction"),
        NON_FICTION("non_fiction"),
        SCIENCE_FICTION("science_fiction"),
        MYSTERY("mystery");
        private final String genre;
        NovelGenre(String genre) {
            this.genre = genre;
        }
        public String getGenre(){
            return genre;
        }
        }
        class Novel{
          NovelFenre genre;
          // Display value of Fiction
          System.out.println("This is a " + getGenre + " Novel");
        }
        // this is the output:
        // This is a fiction Novel
      ```
## What I have learned on 7_7_2023
## Stream in java 8 (New updated Technology of java 8)
  - In order to understand Stream, we firstly need to have basic knowledge of (lambda expressions, Optional, method refernces and Stream API))
  - ## 1. Stream API
    - In **java 8**, the **Stream API** was introduced to perform some complex operations to deal with collection of data (Deal with big data of collection or array)
    - The **java.util.stream** library contain **classes** for processing sequences of **elements**.
    - **Stream** is neither **data structure** or **data storage** -> it **can not modify** the **data source**
    - Stream also offer some operation such as filtering , mapping, reducing and sorting to solve complex data.
    - Stream will contain **collection** or **array**.
    - **Stream Creation**
       - **Empty Stream**
         ```java
         // This is an empty Stream
         Stream<String> emptyStream = Stream.enpty();
         // we should use **Stream.empty()** method before creation
         // to avoid returning null when no element is added
         public Stream<String> streamOf(List<String> list){
            // This is normal way of if condtition
            if(list == null || list.isEmpty()){
                return Stream.empty();
            }
            return list.stream();
            // Or you can use lambda expression to tidy your code
            // return list == null || list.isEmpty() ? Stream.empty() : list.stream();
         }
         ```
      - **Stream of Collection**
        - We can also create a stream of any type of ***Collection***(Collection, List, Set)
          ```java
          // Create an empty String to avoid returning null for streams with no element
          Stream<String> emptyString = Stream.empty();
          // We can also create a stream of any type of Collection (Collection, List, Set):
          String[] arrayFruit = {"apple", "banana","oragange"}; // initialize an array
          Collection<String> collection = Arrays.asList(arrayFruit); 
          Stream<String> streamOfColletion = collection.stream();
          ```
      - **Stream of Array**
        ```java
        String[] arrayFruit = {"apple", "banana","oragange"}; // initialize an array
        //Stream of exiting Array
        Stream<String> streamOfArrayFull = Arrays.stream(arrayFruit); // take the full array
        Stream<String> streamOfArrayPart = Arrays.stream(arrayFruit, 1, 3); // take the part of Array
        // Create a Stream directly from the exited or new sequence of elements 
        Stream<String> streamDirectly = Stream.of("apple", "banana", "orange");
        
        streamOfArrayPart.forEach(System.out :: println);
        // Output:
        // banana
        // orange
        ```
      - **Stream builder**
        - It allows to build and create a stream incrementally by adding elements dynamically.
          ```java
          // Initialize Stream Builder
          Stream.Builder<String> streamBuilder = Stream.builder();
          // Add to Stream Builder
          streamBuilder.add("apple")
                  .add("banana")
                  .add("orange");
          // Build Stream 
          Stream<String> stream = streamBuilder.build();
          stream.forEach(System.out :: println);
          // Output:
          //apple
          // banana
          // orange
          ```
    - **Stream intermediate operation**
      -  Here is the part where **bulk operations** (_complex tasks_) are performed.
          - **filter(Predicate &lt;? super T&gt; predicate)**
              ```java
              public interface Stream<T> extends BaseStream<T, Stream<T>> {
                Stream<T> filter(Predicate<? super T> predicate);
              }
              ```     
              - This is **Java Streams** that allows you to filter elements of a stream based on the **filter(Predicate &lt;? super T&gt; predicate)**.
              - Let's define what is **Predicate** in the parameter of **filter(Predicate&lt;T&gt; predicate)** method.
                 ```java
                  @FunctionalInterface
                  public interface Predicate<T> {
                    boolean test(T t); //abstract method
                  }
                 ``` 
              - **Predicate** is a **functional interface** (_i.e the interface that contains abstract method which does not have body_) and it will override the abstract method called **test()**, which take input of type T, for every time a **Predicate** interface is initialized.
              - Let's take a simple example without using lambda **(->)** because lambda it will automatically run the override **test()** method.
                ```java
                public class StreamDemo{
                  public static void main (String[] args){
                    // initialize an Integer array
                    Integer[] numbers = {1,2,3,4,5,6};
                    // Put into the stream
                    Stream<Integer> streamNumbers = Arrays.stream(numbers);
                    // Operate the filter operation of stream
                    List<Integer> evenNumbers = streamNumbers.filter(new Predicate<Integer>() {
                      // override method test in the interface Predicate
                      @Override
                      public boolean test(Integer integer){
                        return integer % 2 == 0;
                      }
                    }).collect(Collectors.toList()); // Collect the filtered elements into a new list
                    evenNumbers.forEach(System.out::println);
                  }
                  // Output:
                  // 2
                  // 4
                  // 6
                }
                ```
              - Okay then, after you understand how the code is performed internally, now you could move to the lambda expression version.
              - Down below is the respective code like above. However I will use lambda expression **(->)**
                ```java
                public class StreamDemo{
                  public static void main (String[] args){
                    // initialize an Integer array
                    Integer[] numbers = {1,2,3,4,5,6};
                    // Put into the stream
                    Stream<Integer> streamNumbers = Arrays.stream(numbers);
                    // Operate the filter operation of stream
                    List<Integer> evenNumbers = streamNumbers.filter(integer -> integer % 2 == 0)
                                                             .collect(Collectors.toList()); // Collect the filtered elements into a new list
                    evenNumbers.forEach(System.out::println);
                  }
                  // Output:
                  // 2
                  // 4
                  // 6
                }
                ```
## What I have learned on 10_7_2023
## Stream in java 8 (New updated Technology of java 8)
- ## 1. Stream API (Continued)
  - **Stream intermediate operation**
    -  Here is the part where **bulk operations** (_complex tasks_) are performed.
	-  **map(Function&lt;? super T, ? extends R&gt; mapper)**
       ```java
       public interface Stream<T> extends BaseStream<T, Stream<T>> {
         <R> Stream<R> map(Function<? super T, ? extends R> mapper);
       }
       ```
       - In this **map()** funtion, we can see that it has two parameter **`<? super T & ? extends R>`**. So what is **`( ?, super T, extends R )`**
       - The **`?`** symbol is used as a wildcard character to represent an unknown type.
       - The **`super T`** type constraint in **`<? super T>`** indicates that the mapper function can accept a type that is either **`T`** or a **super** type of **T**.
       - The **`extends R`** type constraint in **`<? extends R>`** indicates that the mapper function can return a type that is either **R** or **subtype (i.e a class that extends or implements R)** type of **R**. 
       - This is **Java Streams** that allows you to transforms each element of a given stream using a provided function and produces a new stream with the transformed elements based on the filter **apply()**.
       - Let's define what is **Function** in the parameter of **`map(Function<? super T, ? extends R> mapper)`** method.
         ```java
         @FunctionalInterface
         public interface Function<T, R> {
           R apply(T t);
         }
         ```
       - **Function** is a **functional interface** (_i.e the interface that contains abstract method which does not have body_) and it will override the abstract method called **apply()**, which take input of type T and return the output of type R, for every time a **Function** interface is initialized.
       - Let's take a simple example without using lambda **(->)** because lambda it will automatically run the override **apply()** method.
         ```java
         public class StreamAPI {
          public static void main(String[] args) {
          // Create an array of String object
          String[] fruit = {"apple", "banana", "orange"};
          // Stream directly from the array using Stream.of();
          Stream<String> streamDirectly = Stream.of(fruit[0], fruit[1], fruit[2]);
          List<String> newMap = streamDirectly.map(new Function<String, String>() {
              @Override
              public String apply(String s) {
                  return "Here is " + s;
              }
          }).collect(Collectors.toList());
          newMap.forEach(System.out::println);
          }
         }
         // Output:
         // Here is apple
         // Here is banana
         // Here is orange
           ```
       - Down below is the respective code like above. However I will use lambda expression **(->)**
         ```java
         public class StreamAPI {
          public static void main(String[] args) {
          // Create an array of String object
          String[] fruit = {"apple", "banana", "orange"};
          // Stream directly from the array using Stream.of();
          Stream<String> streamDirectly = Stream.of(fruit[0], fruit[1], fruit[2]);
          List<String> newMap = streamDirectly.map(fruits -> "Here is " + fruits).collect(Collectors.toList());
          newMap.forEach(System.out::println);
          }
         }
         // Output:
         // Here is apple
         // Here is banana
         // Here is orange
         ```			
- ## 2. Thread in java				
  - **Java Memory Model**
    - **The Internal Java Memory Model**
    - The Java memory model used internally in the JVM in which thread stacks and the heaps are seperated.
## What I have learned on 10_7_2023
## LRU Cache
  - **The Least Recently Used(LRU) cache**
  - Check my **project book management**, in there I made a comparison of time consumption when a search function is implemented in the cache and in the database, which one then will be faster.

## What I have learned on 10_7_2023
  - **The Bloom filter**</br>
    - Bloom filter has three components: Bloom filter, Bit Array, Hash Function.
    - BitArray has a fixed-size array of bits(0s and 1s)
      
## What I have learned on 27_7_2023
## Today, I learn about JDBC (Java Database Connectivity)
  - **Direction:** we will build core JDBC such as (CREATE, READ, UPDATE, DELETE) in order to query data from the database in java runtime environment, so that we can use it permanantly like some basic query such as (SELECT, INSERT, UPDATE, DELETE) in SQL.
  - **Preparation:** Load driver MySQL to the dependencies 
## What I have learned on 8_7_2023
## Tight-coupling and how to loosely coupled 
  - **Definition:** Let's consider these examples
  - **Loosely Coupled Car Parts:** Imagine your car toy is made of defferent parts: wheels, doors, roof, and engine. Now if you want to change the wheels, you just need to remove and replace them with other wheels wihout affecting other parts.<br>
```java
    
interface CarFixing {
    void fix();
}

class CarDoor implements CarFixing {
    @Override
    public void fix() {
        System.out.println("Đã sửa xong cửa");
    }
}
class CarWheel implements CarFixing {
    @Override
    public void fix() {
        System.out.println("Đã sửa xong bánh xe");
    }
}

public class Factory {
    CarFixing carFixing;
    Factory(CarFixing carFixing){
        this.carFixing = carFixing;
    }
    void fixingService(){
        carFixing.fix();
    }
    public static void main(String[] args) {
        CarFixing carDoor = new CarDoor();
        CarFixing carWheel = new CarWheel();
        Factory factory = new Factory(carWheel);
        factory.fixingService();
        Factory factory1 = new Factory(carDoor);
        factory1.fixingService();
    }
}
// Đã sửa xong bánh xe
// Đã sửa xong cửa
  ```
=> So the class Factory only work with one interface "CarFixing" and do not worry about which part of the car will be fixed. Obviously, when initializing the main class, we need to define instances of those class implemantations, however, we can add or remove them seperately wihout changing the entire class "Factory"
## **Inversion of control (IOC)**:
-  Unlike traditional style of code where code are called from library. However, with IoC, IoC containers would inject those dependencies when Bean is created
## Dependency Injection (DI):
- when we have two object (class B & class C) and we use class A to create instances of both class => this is called class B & C depend on class A, because without class A => B & C can not created. Therefore, people think about a present general class D (i.e: interface or abstract class) to represent for class B & C so that class A can only work with class representer D. => So even we change the behavior of B & C => A is not affected.
- We have 3 types of Injection: 
  - **Constructor Injection**
  -  In constructor injection, a class's dependencies put in the parameter of the constructor would be created when the class is initialized.<br>
  ```java
  /*
   dependency class
  */
  public class Factory {
    CarFixing carFixing;
    Factory(CarFixing carFixing){ => "CarFixing" dependency will be created when "Factory" is initialized
        this.carFixing = carFixing;
    }
    void fixingService(){
        carFixing.fix();
    }
  /*
    main class
  */
  ```
 **Setter Injection**
  -  In setter injection, a dependency Object would be set in the setter method of .<br>
  ```java
  /*
    dependency classes
  */
  public class Factory {
    CarFixing carFixing;
    CarDecoration carDecoration;
    setCarDecoration(CarDecoration carDecoration){ => "CarDecoration" dependency will be created whenever "setFactory" is called
        this.carDecoration = carDecoration;
    }
    setCarFixing(CarFixing carFixing){ => "CarFixing" dependency will be created whenever "setFactory" is called
        this.carFixing = carFixing;
    }
    void fixingService(){
        carFixing.fix();
    }
    void decoratingService(){
        carDecorating.decorate();
    }
  /*
    main class
  */
  ```
 
  **Spring IoC**
  - Spring will server for the purpose of creating container and dependency for us automatically. 
  - **Application Context**: is the container in spring, it will manage all the class with @Component annotation as its bean.
    ```java
	public static void main(String[] args) {

		// Like normal, in this part we will initialize Instance of classes
		// For example:
		// CarFixing carFixing1 = new CarDoor();
		// Factory factory = new Factory(carFixing1);
		// However when we put annotation @Component, the system will identify those classes as its bean, and
		// automatically generate their instances
		ApplicationContext context = SpringApplication.run(ProjectApplication.class, args);
	
	
		// test after instance is initialized
		Factory factory = context.getBean(Factory.class);
		System.out.println(factory);
		CarDoor carDoor = context.getBean(CarDoor.class);
		System.out.println(carDoor);
	
		// result:
		//com.springboot.project.Factory@4c361f63
		//com.springboot.project.CarDoor@6ed922e1
	}
    ```

  - **Autowired**: This part i forgot to commit, then I lost it, i will add it later
  
  - **Qualifier**: When we use @Qualifier, we are not allowed to use @Autowired
	  ```java
	  public interface CarFixing {
    		void fix();
	  }
   
	@Component("CarDoor")
	public class CarDoor implements CarFixing{
	    @Override
	    public void fix() {
	        System.out.println("Đã sửa xong cánh cửa của xe");
	    }
	}
  
	@Component("CarWheel")
	public class CarWheel implements CarFixing{
	    @Override
	    public void fix() {
	        System.out.println("Đã sửa xong banh của xe");
	    }
	}

	 @Component
	public class Factory {
  	    CarFixing carFixing;
	    CarFixing carFixing1;
	
	    public Factory(@Qualifier("CarDoor") CarFixing carFixing, @Qualifier("CarWheel") CarFixing carFixing1) {
	        this.carFixing = carFixing;
	        this.carFixing1 = carFixing1;
	    }
	
	    public void carService() {
	        carFixing.fix();
	        carFixing1.fix();
	    }
  	}
	 
	@SpringBootApplication
	public class ProjectApplication {
	    public static void main(String[] args) {
	        ApplicationContext context = SpringApplication.run(ProjectApplication.class, args);
	
	        Factory factory = context.getBean(Factory.class);
	        System.out.println(factory);
	        factory.carService();
	    }
	}
 	// results:
	// com.springboot.project.Factory@1455154c
	// Đã sửa xong cánh cửa của xe
	// Đã sửa xong banh của xe
	  ```
  - **PostConstruct && PreDestroy**
  	```java
  	@Component
	public class Car {
	    @PostConstruct
	    public void postConstruct() {
	        System.out.println("Ham duoc goi sau khi in Car");
	    }
	
	    @PreDestroy
	    public void preDestroy() {
	        System.out.println("Ham duoc goi truoc khi Bean Car bi xoa");
	    }
	}
 
	@SpringBootApplication
	public class App {
	    public static void main(String[] args) {
	        ApplicationContext context = SpringApplication.run(App.class, args);
	
	        // Lay Bean Car tu Application
	        Car car = context.getBean(Car.class);
	        System.out.println("Truoc khi ham bi Bean factory xoa");
	        ((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(car);
	        System.out.println("Sau khi ham bi Bean factory xoa");
	    }
	}
  	```
   - **Component && Service && Repository**
   ```java
	@Component
	public class Car {
	    private int id;
	    private String make;
	    private String model;
	
	    public Car() {
	    }
	
	    public Car(int id, String make, String model) {
	        this.id = id;
	        this.make = make;
	        this.model = model;
	    }
	
	    public int getId() {
	        return id;
	    }
	
	    public void setId(int id) {
	        this.id = id;
	    }
	
	    public String getmake() {
	        return make;
	    }
	
	    public void setmake(String make) {
	        this.make = make;
	    }
	
	    public String getModel() {
	        return model;
	    }
	
	    public void setModel(String model) {
	        this.model = model;
	    }
	
	    @Override
	    public String toString() {
	        return "Car{" +
	                "id=" + id +
	                ", make='" + make + '\'' +
	                ", model='" + model + '\'' +
	                '}';
	    }
	}

	@Repository
	public class CarRepository {
	    public Car findCarById(int id) {
	        // truy suat vao co so du lieu
	
	        return new Car(id,"Toyota", "A129");
	    }
	}
 
	@Service
	public class CarService {
	    @Autowired
	    CarRepository carRepository;
	
	    public Car getCarByIdUppercaseModel(int id) {
	        Car car = carRepository.findCarById(id);
	        car.setmake(car.getmake().toUpperCase());
	        return car;
	    }
	}

	@SpringBootApplication
	public class App {
	    public static void main(String[] args) {
	        ApplicationContext context = SpringApplication.run(App.class, args);
	        CarService carService = context.getBean(CarService.class);
	        int id = 1;
	        Car car = carService.getCarByIdUppercaseModel(id);
	        System.out.println(car.toString());
	    }
	}

   ```
