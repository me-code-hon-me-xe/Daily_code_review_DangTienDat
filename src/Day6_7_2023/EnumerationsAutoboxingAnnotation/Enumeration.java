package Day6_7_2023.EnumerationsAutoboxingAnnotation;

import java.awt.print.Book;

public class Enumeration {
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

    static class Novel {
        private String title;
        private NovelGenre genre;

        Novel(String title, NovelGenre genre) {
            this.title = title;
            this.genre = genre;
        }

        String getTitle() {
            return title;
        }

        NovelGenre getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return "Novel{" +
                    "title='" + title + '\'' +
                    ", genre=" + genre.getGenre() +
                    '}';
        }

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
            // Output:
            //Novel{title='Pride and Prejudice', genre=fiction}
            //Novel{title='Harry Potter', genre=science_fiction}
            //Pride and Prejudice is a fiction novel.
            //Harry Potter is a science-fiction novel.
            NovelGenre allGenre [] = NovelGenre.values();
            for (NovelGenre g : allGenre
                 ) {
                System.out.println(g + ", ");
            }
            NovelGenre genre = NovelGenre.valueOf("FICTION");
            System.out.println(genre.getGenre());
        }

    }
}
