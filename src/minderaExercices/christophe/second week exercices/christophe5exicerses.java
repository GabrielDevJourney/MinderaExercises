import java.util.Arrays;

public class christophe5exicerses {

    public static void main(String[] args) {

        System.out.println(checkPalindrome("A man a plan a canal Panama"));

        System.out.println("factorial is " + factorial(3));

        //gcd1();
        gcd2();

        System.out.println("nums in reverse");
        reverseInt();


        int[] arr1 = {1, 2, 5, 7, 8};
        int[] arr2 = {3,3, 6, 9};
        int[] merged = sortedArrays(arr1, arr2);
        //usint tostring helps to be able to read the real content
        //inside instead of the array instance in memory
        //this doesnt convert array to string
        //just creates new string object representing array content
        System.out.println(Arrays.toString(merged));

    }

    //- Write an algorithm to check if a given string is a palindrome (reads the same backward and forward)
    public static String checkPalindrome(String str) {
        //i will go from tight to left and left to right and if the index content match then is true
        String wordToUse = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int left = 0;
        int right = wordToUse.length() - 1;
        while (left < right) {
            if (wordToUse.charAt(left) != wordToUse.charAt(right)) {
                return wordToUse + " não é um palíndromo.";
            }
            left++;
            right--;
        }
        return wordToUse + " é um palíndromo.";
    }

    //Write an algorithm that calculates the factorial of a given number N.
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n = n * factorial(n - 1);

        }
    }

    //- Write an algorithm to find the greatest common divisor (GCD) of two numbers.
    public static void gcd1() {
        int num1 = 42;
        int num2 = 24;
        //to hold all possible numbers inside num1
        int[] num1Arr = new int[num1];
        int[] num2Arr = new int[num2];

        //dois contadores um para cada num
        int count1 = 0;
        int count2 = 0;
        //via o maior divisor de um e de outro e depois comparava ate encontrar o maior numero
        //vejo qual e o numero mais pequeno e vejo se o o numero maior e divisel por esse se nao for
        //caso nao teria de ver o proximo como???
        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0) {
                //para cada index do array de cada divisor que e tracked by count
                //pass the divisor i
                num1Arr[count1] = i;
                count1++;
            }
            for (int j = 1; j <= num2; j++) {
                if (num2 % j == 0) {
                    //para cada index do array de cada divisor que e tracked by count
                    //pass the divisor j
                    num2Arr[count2] = j;
                    count2++;
                }
            }
        }
        //inicializar o valor incial e a cada iteracao se achar um numero maior que o anterior
        //atualizo para esse mesmo numero
        int gcd = 1;
        for (int i = 0; i < count1; i++) {
            for (int j = 0; j < count2; j++) {
                if (num1Arr[i] == num2Arr[j] && num1Arr[i] > gcd) {
                    gcd = num1Arr[i];
                    break;
                }
            }
        }
        System.out.print("greatest common divisor is " + gcd);
    }

    public static void gcd2() {
        int num1 = 42, num2 = 24, gcd = 1;
        //i nao pode ser maior que nenhum dos valores inseridos
        //dizer que nao existe mais nenhuma possibilidade
        for (int i = 1; i <= num1 && i <= num2; i++) {
            //vou a cada numero, o primeiro numero que aparecer e der resto 1  para
            //neste caso ambos tem de chegar ao maior numero possivel onde o resto e 0
            if (num1 % i == 0 && num2 % i == 0)
                gcd = i;
        }
        //%d vai tomar os valor por ordem que eu meto depois
        System.out.printf("GCD of %d and %d is: %d", num1, num2, gcd);
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

        //USE CASE
            // int[] arr1 = {1, 2, 5, 7, 8};
            // int[] arr2 = {3, 3, 6, 9};

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

        //lidar com o caso de quando o i para devido a um dos arrays ser tiver maior tamanho devido ao primeiro WHILE que o outro
        while (i < arrayNums1.length) {
            mergedArray[k++] = arrayNums1[i++];
        }

        // Copy remaining elements from arrayNums2, if any
        while (j < arrayNums2.length) {
            mergedArray[k++] = arrayNums2[j++];
        }
        
        int[] temp = new int[mergedArray.length];
        for(int l = 0; l <= mergedArray.length - 1; l++){
            if(l+1 < mergedArray.length - 1){
                if(mergedArray[l] != mergedArray[l + 1]) {
                    temp[l] = mergedArray[l];
                }
            }
        }
        return temp;
    }
}
