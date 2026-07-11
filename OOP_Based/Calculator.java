public class Calculator {
    public static int add(int a, int b) {
        return a+b;
    }
    public static double add(double a, double b) {
        return a+b;
    }
    public static int add(int a, int b, int c) {
        return a+b+c;
    }
    public static void main(String[] args) {
        int r1 = add(2,3);
        double r2 = add(3.5,6.5);
        int r3 = add(2,3,4);
        System.out.println(r1+"\n"+r2+"\n"+r3);
    }
} 
