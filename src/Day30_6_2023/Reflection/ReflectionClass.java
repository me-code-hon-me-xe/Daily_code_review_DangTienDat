package Day30_6_2023.Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionClass {
    public static void main(String[] args) {
        Dog dog1 = new Dog("BlueSky");
        // create an object of Class
        // using getClass()
        Class obj = dog1.getClass();


        //Reflection of Java Classes
        //obj.getName() - returns the name of the class
        //obj.getModifiers() - returns the access modifier of the class
        //obj.getSuperclass() - returns the super class of the class
        // get name of the class
        String name = obj.getName();
        System.out.println("Name: " + name);

        // get the access modifier of the class
        int modifier = obj.getModifiers();

        // convert the access modifier to string
        String mod = Modifier.toString(modifier);
        System.out.println("Modifier: " + mod);

        // get the superclass of Dog
        Class superClass = obj.getSuperclass();
        System.out.println("Superclass: " + superClass.getName());


        //Reflecting Fields, Methods, and Constructors
        //1. Reflection of Java Methods
        // using object of Class to
        // get all the declared methods of Dog
         Method[] methods = obj.getDeclaredMethods();
         for (Method e : methods){
             // get names of methods
             System.out.println("Method Name: " + e.getName());

             // get the access modifier of methods
             int modifiers = e.getModifiers();
             System.out.println("Modifier: " + Modifier.toString(modifier));
         }

    }
}

abstract class Animal{
    static int numsLeg = 4;
    static int numsTail = 1;
    static int numsEyes = 2;
    static int numsEar = 2;
    static int numsMouth = 1;
}

class Dog extends Animal{

    static String name;
    public Dog(String name){
        this.name = name;
    }
    public void display(){
        System.out.println("My Dog is " + name + ". He has " + numsLeg + " legs");
        name = name + "1";
        System.out.println("Now, my Dog is " + name + ". He has " + numsLeg + " legs");
    }
}
