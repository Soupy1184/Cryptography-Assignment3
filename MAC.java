public class MAC extends HashFunction {
    String temp;
    String hmac;

    public MAC() {
        super();
    }

    void macMessage(String plaintext, String key){
        super.hashMessage(key + plaintext);
        temp = super.getOutput();
        
        super.hashMessage(key + temp);
        hmac = super.getOutput();
    }

    public String getOutput(){
        return hmac;
    }

}