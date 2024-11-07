public class giTasks {
    public static void main(String[] args) {
        System.out.println("\nConcat:");
        concatString();
        System.out.println("\nSecond Position:");
        secondPosition();
        System.out.println("\nString length:");
        lengthOfString();
        System.out.println("\nString length:");
        printArrayStrings();


    }

    //1. Concat oe string to the final of another
    public static void concatString() {
        String firstWord = "honey";
        String secondWord = "Bee";
        String result = firstWord.concat(secondWord);
        System.out.print(result);
    }

    //2. Print the char in the 2 position of a string
    public static void secondPosition() {
        String word = "matchupithcu";
        char secondChar = word.charAt(1);
        System.out.print(secondChar);
    }

    //3. Print size of a given string
    public static void lengthOfString() {
        String word = "matchupithcu";
        int sizeOfString = word.length();
        System.out.print(sizeOfString);
    }

    //4. Store array with 3 words and go trough it and print each
    public static void printArrayStrings() {
        int bullets = 20;

// For LOOP
        for (int i = 1; i <= bullets; i++) {
            System.out.println("Pew pew pew..");
            bullets--;
        }

    }
}
