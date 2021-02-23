import java.util.ArrayList;
import java.util.List;

public class HashAttack extends HashFunction {
    boolean collision = false;
    String plaintext1 = null;
    String plaintext2;
    
    public HashAttack(){
        super();
    }

    public void attackHashFunction(HashFunction hashFunction){
        List<String> messageSpace = generateMessages();

        List<String> hashSpace = new ArrayList<String>();
        for (int i = 0; i < messageSpace.size(); i++){
            hashFunction.hashMessage(messageSpace.get(i));
            
            if (hashSpace.contains(hashFunction.getOutput())){
                collision = true;
                for (int j = 0; j < i; j++){
                    if(hashSpace.get(j).equals(hashFunction.getOutput())){
                        plaintext1 = messageSpace.get(j);
                        break;
                    }
                }
                plaintext2 = messageSpace.get(i);
                System.out.println("Collision found at: " + i);
                System.out.println("Collision String: " + hashFunction.getOutput());
                System.out.println("Message 1: " + plaintext1);
                System.out.println("Message 2: " + plaintext2);
                
                break;
            }

            hashSpace.add(hashFunction.getOutput());
        }
    }

    private List<String> generateMessages(){
        int n = 11585;
        List<String> list = new ArrayList<String>();
        String string;
        int[] tempArray = new int[25];
 
        for (int i = 0; i < n; i++){
            string = "";
            for (int j = 0; j < 25; j++){
                tempArray[j] = getRandomNumberInRange(0, 26);
                string = intArrayToAlphabet(tempArray);
            }
            list.add(string);
        }

        return list;
    }

    private static String intArrayToAlphabet(int[] array){
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
