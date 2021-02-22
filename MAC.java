public class MAC extends HashFunction {
    String ciphertext;

    public MAC() {
        super();
    }

    void macMessage(String plaintext, String key){
        super.hashMessage(key + plaintext);
        ciphertext = super.getOutput();
        
        super.hashMessage(key + ciphertext);
        ciphertext = super.getOutput();
    }

    public String getOutput(){
        return ciphertext;
    }

}