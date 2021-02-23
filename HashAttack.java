import java.util.ArrayList;
import java.util.List;

public class HashAttack extends HashFunction {
    
    public HashAttack(){
        super();
    }

    public void attackHashFunction(HashFunction hashFunction){
        List<String> list = new ArrayList<String>();
        list.add(hashFunction.getOutput());
        
    }
}
