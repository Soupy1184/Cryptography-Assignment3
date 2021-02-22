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
        
    }

    private static String generateRandomKey() {
        String string = "aaaaa";

        return string;
    }
    
}