package Day29_6_2023.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetType {


    public static void main(String[] args) {
        // HashSet with 8 capacity and 0.75 load factor
        Set<Integer> evenNumbers = new HashSet<>(8, 0.75f);
        // Using add() method
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        evenNumbers.add(7);
        evenNumbers.add(100);
        evenNumbers.add(9);
        evenNumbers.add(1000);
        System.out.println("HashSet: " + evenNumbers);

    }
}
