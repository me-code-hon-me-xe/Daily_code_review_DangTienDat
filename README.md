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
