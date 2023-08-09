package Day28_6_2023.StaticKeyword;

public class StaticKeyword {
    static int a = 0;
    // Static Memory
    void f1 (){
        System.out.printf("a = %d\n", a);
        a ++;
    }
}

class  Main{
    public static void main(String[] args) {
        StaticKeyword s1 = new StaticKeyword();
        StaticKeyword s2 = new StaticKeyword();
        StaticKeyword s3 = new StaticKeyword();
        StaticKeyword s4 = new StaticKeyword();
        s1.f1();//0 b
        s2.f1();//1
        s3.f1();
        s4.f1();
        //results for static:
        //a = 0
        //a = 1
        //a = 2
        //a = 3
        //results for non static:
        //a = 0
        //a = 0
        //a = 0
        //a = 0
    }
}