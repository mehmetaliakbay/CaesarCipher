import edu.duke.*;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(){}
    
    public CaesarCipher(int key){
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        String lowCaseAlphabet = alphabet.toLowerCase();
        
        
        for(int i=0; i<encrypted.length() ; i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            int idx2 = lowCaseAlphabet.indexOf(currChar);
            char newChar;
            if(idx != -1){
                 newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
                
            }else if(idx2 != -1){
                newChar = shiftedAlphabet.charAt(idx2);
                encrypted.setCharAt(i,newChar);
            }
         }
         return encrypted.toString();
}

public String decrypt(String input){
    CaesarCipher cc = new CaesarCipher(26-mainKey);
    return cc.encrypt(input);
}


public void testCaesar(){
        
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message);
        System.out.println(encrypted);
       // String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
        
}

 public String encryptTwoKeys(String input, int key1, int key2){
    String encrypted="";
    CaesarCipher cc1 = new CaesarCipher(key1);
    CaesarCipher cc2 = new CaesarCipher(key2);
    for(int i=0;i<input.length();i++){
        if(i%2==0){
            encrypted += cc1.encrypt(input.substring(i,i+1));
        }else if(i%2 == 1){
            encrypted += cc2.encrypt(input.substring(i,i+1));
        }
    
    }

    return encrypted.toString();
}
/*



public void testEncryptedTwoKeyse(){
        int key1 = 8;
        int key2 = 21;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys(message,key1,key2);
        System.out.println(encrypted);

}
*/

}
