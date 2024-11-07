public class Main {
    public static void main(String[] args) {
        System.out.println("Test 1:");
        test1();

        System.out.println("\nTest 2:");
        test2();

        System.out.println("\nTest 3:");
        test3();

        System.out.println("\nTest 4:");
        test4();

        System.out.println("\nTest 5:");
        test5();
    }

    public static void test1() {
        String name = "Jim Morrison";
        String artist = "Jim Morrison";

        System.out.println(name == artist);
        // true
        //como sao literals ambos vao parar a string pool comparando o conteudo de ambos que apontam para o mesmo
    }

    public static void test2() {
        String name = "Jim Morrison";
        String artist = new String("Jim Morrison");

        System.out.println(name == artist);
        //false
        //estao a apontar para coisas diferentes
    }

    public static void test3() {
        String name = new String("Jim Morrison");
        String artist = new String("Jim Morrison");

        System.out.println(name == artist);
        //false
        //apontam para objetos diferentes mesmo estando ambos na heap logo da falso
    }

    public static void test4() {
        String name = "Jim Morrison";
        String artist = "David Bowie";

        System.out.println(name == artist);
        //false
        //apontam para a string pool mas para coisas conteudos diferentes
    }

    public static void test5() {
        int[] numbers = new int[4];        // [0,0,0,0]
        String[] names = new String[2];    // [null, null]

        names[2] = "Mark";
        System.out.print(names);

    }
}