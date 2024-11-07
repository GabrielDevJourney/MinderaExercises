import java.util.Arrays;

public class ricardTasks {
    public static void main(String[] args) {
        System.out.println("\nResto5:");
        resto();
        System.out.println("\nReverse:");
        reverse();
        System.out.println("\nSort");
        //sortNumbers();
        int[] array = {2, 5, 6, 12, 98, 1};
        sortNumbers2(array);
    }

    //1. Informar todos os números de 1000 a 1999 que quando divididos por 11 obtemos resto = 5.
    public static void resto() {
        for (int i = 1000; i <= 1999; i++) {
            if (i % 11 == 5) {
                System.out.println(i);
            }

        }
    }

    //2. Criar um array de 5 elementos e imprimir esse array em ordem reversa
    public static void reverse() {
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }

    //3. Dado um array de inteiros com 5 elementos, organiza-los de forma crescente
    /* public static void sortNumbers()*/ {
        int[] numbers = {1, 4, 3, 6, 5};
        Arrays.sort(numbers);
        for (int i : numbers) {
            System.out.println(i);
        }
    }

    public static void sortNumbers2(int[] numbersArray) {
        int size = numbersArray.length - 1;
        //int[] array = {2, 5, 6, 12, 98, 1};
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size - 1; j++) {
                //check current index number with next number
                if (numbersArray[j] > numbersArray[j + 1]) {
                    //number in j needs to be stored into a temporary place to later store it in the next index because it was the biggest of the two
                    int numTemp = numbersArray[j];
                    //change the j + 1 were is the smaller number to the j where is the bigger number
                    numbersArray[j] = numbersArray[j + 1];
                    //here index do the opposite index j + 1 put the bigger number in next index j + 1 becomes temp
                    numbersArray[j + 1] = numTemp;
                }

            }
        }
        System.out.print(Arrays.toString(numbersArray));
    }
}
