import edu.duke.*;
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2){
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
    }
    
    public String encrypt(String input){
   
     CaesarCipher cc = new CaesarCipher(mainKey1);
      CaesarCipher cc2 = new CaesarCipher(mainKey2);
    String encrypted="";
    for(int i=0;i<input.length();i++){
        if(i%2==0){
            encrypted += cc.encrypt(input.substring(i,i+1));
        }else if(i%2 == 1){
            encrypted += cc2.encrypt(input.substring(i,i+1));
        }
    
    }

    return encrypted.toString();
    
 
    }
    
    public String decrypt(String input){
        StringBuilder sb = new StringBuilder("");
        String h1 = halfOfString(input,0);
        String h2 = halfOfString(input,1);
        CaesarCipher cc1 = new CaesarCipher(26-mainKey1);
        CaesarCipher cc2 = new CaesarCipher(26-mainKey2);
        String d1 = cc1.encrypt(h1);
        String d2 = cc2.encrypt(h2);
        
        int k1=0, k2=0;
        for(int i = 0; i < input.length(); i++){
            if(i%2 == 0){
                sb.append(d1.charAt(k1));
                k1++;
            }else if(i%2 == 1){
            
                sb.append(d2.charAt(k2));
                k2++;
           
            }

        }
    
        return sb.toString();
    }
        
    public String halfOfString(String message, int start){
        String newMessage="";
        for(int k = start; k < message.length(); k += 2){
            newMessage += message.charAt(k);
        }
  
        return newMessage;
    }
    
    public void simpleTests(){
        FileResource resource = new FileResource();
        String rs = resource.asString();
        CaesarCipherTwo csTwo = new CaesarCipherTwo(17,3);
        String encrypted = csTwo.encrypt(rs);
        System.out.println(encrypted);
    
    
    
    }
    

}
