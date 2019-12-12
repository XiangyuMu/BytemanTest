package source;
public class Demo {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Demo demo = new Demo();
        test1.printTest1();
        test2.printTest1();
        System.out.println(demo.outTeat1());
    }
    public String outTeat1(){
        return (new Test1().output1());
    }
}
