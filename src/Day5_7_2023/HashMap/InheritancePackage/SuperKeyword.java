package Day5_7_2023.HashMap.InheritancePackage;

public class SuperKeyword {

    static class DemoSuper {
        public static void main(String[] args) {
            Novel novel1 = new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic Fiction");
            Novel novel2 = new Novel();
            Novel novelClone = new Novel(novel1);
            System.out.println(novel1);
//            System.out.println(novel2);
//            System.out.println(novelClone);

            Textbook textbook1 = new Textbook("Chemistry", "John Smith", 1643, "Chemistry 101");
            System.out.println(textbook1);
        }
    }

    //Using super to Call Superclass Constructors
    static class Book {

        public String title;
        public String author;
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

    // Create subclass inherit from superclass
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


    // Create subclass inherit from superclass
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
            System.out.println("i in superclass: " + super.title);
            System.out.println("i in subclass: " + title);
        }
    }
}
