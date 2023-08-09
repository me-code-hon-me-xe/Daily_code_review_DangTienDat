package Day29_6_2023.Vector;

import java.util.Vector;

public class VectorClass {
    public static void main(String[] args){
        Vector<String> mammals = new Vector<>();
        mammals.add("Dog");
        mammals.add("Horse");
        mammals.add(2, "Cat");
        System.out.println("Vector: " + mammals);


    }
}
