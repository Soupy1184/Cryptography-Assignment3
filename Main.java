public class Main {
    public static void main(String[] args){
        String plaintext = "abcdefghi jklmnopqrstuvwx";
        String problem1 = "the birthday attack can be performed for any hash functions including sha three";
        
        HashFunction hash = new HashFunction(plaintext);
        System.out.println(hash.getOutput());


        HashFunction hash1 = new HashFunction(problem1);
        System.out.println(hash1.getOutput());
    }

    
}