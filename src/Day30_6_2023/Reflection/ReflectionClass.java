package Day30_6_2023.Reflection;

public class ReflectionClass {
    public static void main(String[] args) {
        Dog dog1 = new Dog("BlueSky");
        dog1.display();
        Dog dog2 = new Dog("GreenMountain");
        dog2.display();
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
