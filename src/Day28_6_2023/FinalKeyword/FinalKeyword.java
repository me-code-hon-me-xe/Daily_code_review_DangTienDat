package Day28_6_2023.FinalKeyword;

import java.time.LocalDate;
import java.util.Date;

public class FinalKeyword {
    public static final int VALUE = 45;

    public static void main(String[] args) {
        //value = 70; // error: Cannot assign a value to final variable 'value'
    }
}

class Toyota{
    public static  String CAR_MADE = "Toyota";
    public Toyota(String CAR_MADE){
        this.CAR_MADE = CAR_MADE; // error: Cannot assign a value to final variable 'CAR_MADE'
    }
}

class ToyotaCar extends Toyota{

    public ToyotaCar(String CAR_MADE) {
        super(CAR_MADE);
    }
    void test(){

    }
    public static void main(String[] args) {
        Toyota car1 = new Toyota("");
        System.out.println("Car made: " + CAR_MADE);
        CAR_MADE = "Toyota Altis"; // error: Cannot assign a value to final variable 'CAR_MADE'
        System.out.println("Car made: " + CAR_MADE);
        CAR_MADE = "Toyota Fortuner"; // error: Cannot assign a value to final variable 'CAR_MADE'
        System.out.println("Car made: " + CAR_MADE);
        CAR_MADE = "Toyota Camry"; // error: Cannot assign a value to final variable 'CAR_MADE'
    }
}
