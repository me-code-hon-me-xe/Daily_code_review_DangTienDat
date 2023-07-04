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
     
