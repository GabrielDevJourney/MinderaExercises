import java.util.Arrays;

public class christopherTasks {
    public static void main(String[] args) {

        System.out.println(checkPalindrome("civic"));

        System.out.println("nums in reverse");
        reverseInt();

        System.out.println("factorial is " + factorial(3));

        int[] arr1 = {1, 2, 2, 2, 3};
        int[] arr2 = {4, 3, 9};
        int[] merged = sortedArrays(arr1, arr2);
        //usint tostring helps to be able to read the real content
        //inside instead of the array instance in memory
        //this doesnt convert array to string
        //just creates new string object representing array content
        System.out.println(Arrays.toString(merged));

        System.out.println("Gcd is " + gcd(42, 24));
    }

    //- Write an algorithm to check if a given string is a palindrome (reads the same backward and forward)
    public static String checkPalindrome(String str) {
        //i will go from tight to left and left to right and if the index content match then is true
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return str + " não é um palíndromo.";
            }
            left++;
            right--;
        }
        return str + " é um palíndromo.";
    }

    //Write an algorithm that calculates the factorial of a given number N.
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
            return n = n * factorial(n - 1);

    }

    //- Write an algorithm to find the greatest common divisor (GCD) of two numbers.

    public static int gcd(int num1, int num2) {
        int gcd = 1;
        //i nao pode ser maior que nenhum dos valores inseridos
        //dizer que nao existe mais nenhuma possibilidade
        for (int i = 1; i <= num1 && i <= num2; i++) {
            //vou a cada numero o primeiro numero que aparecer der resto 1 entao para
            //neste caso ambos tem de chegar ao maior numero possivel onde o resto e 0
            if (num1 % i == 0 && num2 % i == 0)
                gcd = i;
        }
        //%d vai tomar os valor por ordem que eu meto depois
            return gcd;
    }


    // - Write an algorithm that accepts a list of integers and returns the list in reverse order without using built-in functions.
    public static void reverseInt() {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }

    //Write an algorithm to merge two sorted arrays into a single sorted array.
    public static int[] sortedArrays(int[] arrayNums1, int[] arrayNums2) {
        //        int[] arr1 = {1, 2, 2, 2, 2};
        //        int[] arr2 = {3, 6, 9};
        //must know the size of this new merged array otherwise will trough an error of wrong size or whatever
        int[] mergedArray = new int[arrayNums1.length + arrayNums2.length];
        int i = 0, j = 0, k = 0;
        //just put all items from both inse array and then sort the final
        while (i < arrayNums1.length && j < arrayNums2.length) {
            if (arrayNums1[i] <= arrayNums2[j]) {
                mergedArray[k++] = arrayNums1[i++];
            } else {
                mergedArray[k++] = arrayNums2[j++];
            }
        }

        //lidar com o caso de quando o i para devido a um dos arrays ser maior que o outro
        while (i < arrayNums1.length) {
            mergedArray[k++] = arrayNums1[i++];
        }

        // Copy remaining elements from arrayNums2, if any
        while (j < arrayNums2.length) {
            mergedArray[k++] = arrayNums2[j++];


        }
        return mergedArray;
    }
}
