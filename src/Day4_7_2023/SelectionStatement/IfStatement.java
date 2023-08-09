package Day4_7_2023.SelectionStatement;

public class IfStatement {
    static int i = 10;
    static int j = 30;
    static int k = 50;


    public static void main(String[] args) {

        if (j < 20) {
            System.out.println("j condition have checked");
        } else if (k > 100) {
            System.out.println("k condition have checked");
        } else {
            System.out.println("No condition is checked");
        }

    }
}
