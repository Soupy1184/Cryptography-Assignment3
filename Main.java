public class Main {
    public static void main(String[] args){
        String testtext = "abcdefghi jklmnopqrstuvwx";
        String problem1 = "the birthday attack can be performed for any hash functions including sha three";
        
        //Problem 1
        HashFunction test = new HashFunction();
        test.hashMessage(testtext);
        System.out.println(test.getOutput());

        HashFunction hash1 = new HashFunction();
        hash1.hashMessage(problem1);
        System.out.println(hash1.getOutput());

        //Problem 2
        String key = generateRandomKey();
        MAC mac = new MAC();
        mac.macMessage(problem1, key);
        System.out.println(mac.getOutput());

        //Problem 3
        HashAttack attack = new HashAttack();
        attack.attackHashFunction(hash1);

        //Uncomment this section to see two strings found with the same hash value

        // HashFunction test1 = new HashFunction();
        // HashFunction test2 = new HashFunction();
        // test1.hashMessage("dssoxxxggoiuqlab  jqwqobt");
        // System.out.println(test1.getOutput());
        // test2.hashMessage("ehpqwrygsheayjnrhcjsmjskl");
        // System.out.println(test2.getOutput());

    }

    //generates random key of 5 letters for HMAC key in problem 2
    private static String generateRandomKey() {
        String string = "";
        int[] tempArray = new int[5];

        for (int i = 0; i < 5; i++) {
            tempArray[i] = getRandomNumberInRange(0, 26);
            string = intArrayToString(tempArray);
        }

        return string;
    }

    //changes and int array to a string
    private static String intArrayToString(int[] array){
        String string = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";

        for (int i = 0; i < array.length; i++){
            string += alphabet.charAt(array[i]);
        }

        return string;
    }

    //gets a random number in a range
    private static int getRandomNumberInRange(int min, int max) {
        int result = (int) ((Math.random() * ((max - min) + 1)) + min);
        return result;
    }
    
}