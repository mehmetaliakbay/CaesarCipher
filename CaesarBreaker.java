import edu.duke.*;
public class CaesarBreaker {
        
    public String decrypt(String encrypted){
        
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
    CaesarCipher cc = new CaesarCipher( 26-dkey);
        return cc.encrypt(encrypted);
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
    
    public String halfOfString(String message, int start){
        String newMessage="";
        for(int k = start; k < message.length(); k += 2){
            newMessage += message.charAt(k);
        }
  
        return newMessage;
    }
    
    public char getKey(String s){
        int [] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        String alph =   "abcdefghijklmnopqrstuvwxyz";
        
        return alph.charAt(maxDex);
    }
    
    public void testGetKey(){
        FileResource rs = new FileResource();
        String s = rs.asString();
        System.out.println(getKey(s));
    
    
    }
    
    public void testCountLetters(){
        FileResource resource = new FileResource("data/smallHamlet.txt");
        String message = resource.asString();
        int[] count = countLetters(message);
        
        for(int k=0; k<count.length; k++){
            if(count[k] != 0){
                System.out.println(k + ". index = " + count[k]);
            
            }
        }
    
    }
    
    public void testDecrypt(){
    FileResource resource = new FileResource();
    String encrypted = resource.asString();
    String decrypted = decrypt(encrypted); 
    System.out.print(decrypted);
    }
    
    public String decryptedTwoKeys(String encrypted){
        String decrypted = "";
        CaesarCipher cc = new CaesarCipher();
        
        String alph =   "abcdefghijklmnopqrstuvwxyz";
        String firstCharacters = halfOfString(encrypted,0);
        String secondCharacters = halfOfString(encrypted,1);
        char firstKey = Character.toLowerCase(getKey(firstCharacters));
        char secondKey = Character.toLowerCase(getKey(secondCharacters));
        int key1 = alph.indexOf(firstKey);
        int key2 = alph.indexOf(secondKey);
        
        int d1key = key1 - 4;
        if(key1 < 4){
            d1key = 26 - (4-key1);
        }
        int d2key = key2 - 4;
        if(key2 < 4){
            d2key = 26 - (4-key2);
        }
    
       // return cc.encrypt(encrypted, 26-d1key);
        
        decrypted = cc.encryptTwoKeys(encrypted,26-d1key,26-d2key);
    
        return decrypted;
    }
    public void findDecryptedTwoKeys(){
        FileResource rs = new FileResource();
        String encrypted = rs.asString();
        String decrypted = "";
        
        String alph =   "abcdefghijklmnopqrstuvwxyz";
        String firstCharacters = halfOfString(encrypted,0);
        String secondCharacters = halfOfString(encrypted,1);
        char firstKey = Character.toLowerCase(getKey(firstCharacters));
        char secondKey = Character.toLowerCase(getKey(secondCharacters));
        int key1 = alph.indexOf(firstKey);
        int key2 = alph.indexOf(secondKey);
        
        int d1key = key1 - 4;
        if(key1 < 4){
            d1key = 26 - (4-key1);
        }
        int d2key = key2 - 4;
        if(key2 < 4){
            d2key = 26 - (4-key2);
        }
    
        System.out.println("First key = " + d1key + "Second key = " + d2key);
    
    }
    
    public void testDecryptedTwoKeys(){
    FileResource resource = new FileResource();
    String encrypted = resource.asString();
    
    System.out.println(decryptedTwoKeys(encrypted));
    
    
    }
}













