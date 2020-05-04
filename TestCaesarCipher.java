import edu.duke.*;
public class TestCaesarCipher {
    
    public int[] countLetters(String encrypted){
        String alph =   "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        char crr;
        int idex;
        for(int k=0; k<encrypted.length(); k++){
            crr = Character.toLowerCase(encrypted.charAt(k));
            idex = alph.indexOf(crr);
            if(idex != -1){
                counts[idex] += 1;
            }
            
        }
  
        return counts;
    }
    
        
    public int maxIndex(int[] values){
        int maxDex=0;
  
        for(int k = 0; k < values.length; k++){
            if(values[k]>values[maxDex]){
                maxDex = k;
            }
        }
        
        return maxDex;
    }
    
    public void simpleTests(){
        FileResource resource = new FileResource();
        String rs = resource.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(rs);
        System.out.println(encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
        
        System.out.println("breakCaesarCipher/t" + breakCaesarCipher(encrypted));
    
    }
    
    public String breakCaesarCipher(String input){
        
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26-dkey);
        return cc.encrypt(input);
    }
}







