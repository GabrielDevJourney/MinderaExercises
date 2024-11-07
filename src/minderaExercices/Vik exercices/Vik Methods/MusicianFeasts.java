public class MusicianFeasts {
    public static void main(String[] args) {
        System.out.println(testDish("Bob Dylan", "beef wellington")); // should print true
        System.out.println(testDish("Mick Jagger", "mushroom soup")); // should print false
        System.out.println(generatePassword("Gabriel pereIra ola iii"));
        System.out.println(findStolenNumber(new int[]{1, 2, 3, 5, 6, 4, 8, 9, 10}));    // print "4"
        System.out.println(findStolenNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}));    // print "9"
        System.out.println(findStolenNumber(new int[]{1, 2,3,3,4,5, 7, 8, 9, 10}));

        String[] musicians = {"Steven Tyler", "Erykah Badu", "Mick Jagger",
                "Paul McCartney", "Brandon Flowers", "Alex Turner"};
        String musician = pickMusician(musicians);
        System.out.println(musician);
    }


    public static boolean testDish(String musicianName, String dish) {

        char firstLetterOfName = musicianName.toLowerCase().charAt(0);
        System.out.println(firstLetterOfName);
        //last musicianName letter
        char lastLetterOfName = musicianName.toLowerCase().charAt(musicianName.length() - 1);
        System.out.println(lastLetterOfName);
        //fisrt dish letter
        char firstLetterOfDish = dish.toLowerCase().charAt(0);
        System.out.println(firstLetterOfDish);
        //last dish letter
        char lastLetterOfDish = dish.toLowerCase().charAt(dish.length() - 1);
        System.out.println(lastLetterOfDish);


        //check if first letter from each match and last letter from each match
        return firstLetterOfName == firstLetterOfDish && lastLetterOfName == lastLetterOfDish;


    }

    public static String generatePassword(String musicianName) {
        //take a string of "gabriel pereira" split into 2 and use the pereira
        String[] lastName = musicianName.split(" ");

        //put the name in lowercase so it handles both caps and no caps letters
        //a letters becomes @ and i letters becomes !
        String password = lastName[lastName.length - 1]
                .replaceAll("A", "@")
                .replaceAll("I","!")
                .replaceAll("a", "@")
                .replaceAll("i", "!");
        return password;

    }


    //maybe use a counter and go trough the whole numbers array and see if there is a match
    public static String findStolenNumber(int[] numbers) {
        //go trough every element of the possible array[1..10]
        //i just need to simply return the result in string this means i dont need any type of variables to store values
        //for each number in i checking if in numbers  there is an equal number to i
        for (int i = 1; i <= 10; i++) {

                boolean numberFound = false;

            for(int j = 0; j <= numbers.length - 1; j++){

                if (i == numbers[j]) {
                    numberFound = true;
                    break;
                }
            }
            // numberFound = false means number missing, !false = true  return missing number
            // numberFound = true means number exists ,!true = false  don't return nothing because no missing number
            if(!numberFound){
                return String.valueOf(i);
            }
        }
        return "No stolen number";
    }

    public static String pickMusician(String[] musicians) {
        // generator random number 10 to 15 by randomize index and then take that index number
        int[] possibleNumbers = {10, 11, 12, 13, 14, 15};
        //this (int) is needed so the number form the math random doesn't become a double or floating number
        //if name has more letter count then numbers, then they help
        //String[] musicians = {"Steven Tyler", "Erykah Badu", "Mick Jagger",
        //"Paul McCartney", "Brandon Flowers", "Alex Turner"};
        String selectedNames = "";
        //need a counter to be able to iterate for each all names index and store a name from musicias[i]
        int counter = 0;
        //iterate each word and see its length and based on the comparison with the random number pass it to all names array
        for (int i = 0; i <= musicians.length - 1; i++) {
            int wordSize = musicians[i].replace("\\s", "").length();
            int randomIndex = (int) (Math.random() * possibleNumbers.length);
            int randomNumber = possibleNumbers[randomIndex];
            if (wordSize > randomNumber) {
                selectedNames = musicians[i] + " stays and the others are free to go";
                counter++;
                return selectedNames;
            }
        }
        return "No one needs to stay";
    }

}