package Day10_7_2023.Thread;

public class ThreadDemo {
    public static void main(String[] args) {

        NumberThread number1, number2, number3, number4, number5;
        number1 = new NumberThread(1); number1.start();
        number2 = new NumberThread(2); number2.start();
        number3 = new NumberThread(3); number3.start();
        number4 = new NumberThread(4); number4.start();
        number5 = new NumberThread(5); number5.start();

    }
}

class NumberThread extends Thread {
    int num;

    public NumberThread(int n) {
        num = n;
    }

    public void run() {
        for (int k = 0; k < 10; k++) {
            System.out.print(num);
        }
    }
}



