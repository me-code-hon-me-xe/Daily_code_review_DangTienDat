package Day28_6_2023.JavaGenerics;

public class genericClass {
    public static void main(String[] args) {
        // initialize the class with Integer data
        DemoGeneriClass demo = new DemoGeneriClass();

        // generics method working with String
        demo.<String>genericClass("Java Programming");

        // generics method working with integer
        demo.<Integer>genericClass(25);

    }
}
class DemoGeneriClass<T>{
    // create a generics method
    public <T> void genericClass(T data){
        System.out.println("Genectics Method");
        System.out.println("Data based: " + data);
    };
}

    // Another example of Generic Class
class Printer<T>{
    T thingToPrint;
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    public void print(){
        System.out.println(thingToPrint);
    }
}

class IntegerPrintExample{
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(23);
        printer.print();
    }
}

class DoublePrintExample{
    public static void main(String[] args) {
        Printer<Double> printer = new Printer<>(33.5);
        printer.print();
    }
}