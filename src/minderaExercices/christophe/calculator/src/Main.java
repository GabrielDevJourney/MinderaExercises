package minderaExercices.christophe.calculator.src;

public class Main{
    public static void main(String[] args){

        Calculator calculator = new Calculator();

        int sum = calculator.sum(1,2);
        int subtract = calculator.subtract(4,3);
        int multiply = calculator.multiply(2,3);
        int divide = calculator.divide(6,3);

        System.out.println(sum); //should print 3
        System.out.println(subtract);//should print 1
        System.out.println(multiply); //should print 6
        System.out.println(divide); //should print 2

}
}
