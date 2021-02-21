import java.util.ArrayList;
import java.util.List;

public class HashFunction {
    int[] OUT = new int[5];
    int[][] block = new int[5][5];

    public HashFunction(String plaintext) {
        int[][] round1 = new int[5][5];
        int[][] round2 = new int[5][5];
        int[][] round3 = new int[5][5];

        // check plaintext length
        if (plaintext.length() % 25 != 0) {
            int add = 25 - (plaintext.length() % 25);
            for (int i = 0; i < add; i++) {
                plaintext += 'x';
            }
        }

        List<String> plaintextList = stringToParts(plaintext, 25);
        for (int p = 0; p < plaintextList.size(); p++) {
            List<String> currentBlock = stringToParts(plaintextList.get(p), 5);
            for (int j = 0; j < 5; j++) {
                block[j] = alphabetToIntArray(currentBlock.get(j));
            }

            round1 = block;

            // ROUNDS!
            // ROUND 1
            for (int i = 0; i < 5; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += round1[j][i];
                }
                OUT[i] = (OUT[i] + sum) % 27;
            }

            // ROUND 2
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    round2[i][(j + 4 - i) % 5] = block[i][j];
                }
            }

            for (int i = 0; i < 5; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += round2[j][i];
                }
                OUT[i] = (OUT[i] + sum) % 27;
            }

            // ROUND 3
            int[][] temp = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp[j][(i + 4 - j) % 5] = block[i][j];

                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    round3[i][(j + 1) % 5] = temp[i][j];
                }
            }
            for (int i = 0; i < 5; i++) {
                int start = 0;
                int end = 5 - 1;
                while (start < end) {
                    int hold = round3[i][start];
                    round3[i][start] = round3[i][end];
                    round3[i][end] = hold;

                    start++;
                    end--;
                }
            }

            for (int i = 0; i < 5; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += round3[i][j];
                }
                OUT[i] = (OUT[i] + sum) % 27;
            }
        }
        
        intArrayToAlphabet(OUT);
    }

    private static int[] alphabetToIntArray(String string) {
        string = string.toLowerCase();
        char[] stringArray = string.toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        char[] aplhaArray = alphabet.toCharArray();
        int[] zSpace = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < aplhaArray.length; j++) {
                if (stringArray[i] == aplhaArray[j]) {
                    zSpace[i] = j;
                }
            }
        }

        return zSpace;
    }

    private static List<String> stringToParts(String string, int n){
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i=0; i<len; i+=n){
            parts.add(string.substring(i, Math.min(len, i + n)));
        }
        return parts;
    }

    private static String intArrayToAlphabet(int[] array){
        String string = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";

        for (int i = 0; i < array.length; i++){
            string += alphabet.charAt(array[i]);
        }

        return string.toUpperCase();
    }

    public String getOutput(){
        return intArrayToAlphabet(OUT);
    }
}

// for (int i = 0; i < 5; i++){
//     for(int j = 0; j < 5; j++){
//         System.out.print(String.valueOf(block[i][j] + ", "));
//     }
//     System.out.println("");
// }