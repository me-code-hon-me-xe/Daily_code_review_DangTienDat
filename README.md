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
      
