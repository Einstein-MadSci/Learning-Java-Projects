import java.util.*;

public class CeasarCipher
{
    String[] alphabet = {" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; //Array of all letters in the alphabet with an empty space at [0] because java counts from 0 and if you're counting for 
    String[] alphabet2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; //Array of all letters in the alphabet without space at [0] for decryption
    
    public String encrypt(String message, int shift) //method to encrypt message taking a string to encrypt and a key (shift) to use as parameters
    {
        String[] encryptedMsg = new String[message.length()]; //New array to contain encrypted message

        ArrayList<String> alphabetList = new ArrayList<String>(); //New array list to contain all alphabets so i can use .indexOf method

        for(int i = 0; i < alphabet.length; i++) //For loop to populate alphabetList array list
        {
            alphabetList.add(alphabet[i]);
        }

        String[] messageArr = message.split(""); //split message to encrypt into an array of individual characters
        // System.out.println(Arrays.toString(messageArr));
        
        // System.out.println(alphabet.length);
        
        for(int i = 0; i < messageArr.length; i++) //For loop to encrypt message
        {
            int location = alphabetList.indexOf(messageArr[i]) + shift; //Location variable to hold index of letter of message in alphabet array
            if(location > 26) //if location is greater than 26(max index of alphabet array)
            {
                location -= 26; //subtract 26 from location to restart counting from 0
                encryptedMsg[i] = alphabet[location]; //push alphabet character at location to encrypted message array
                
            }
            else if(alphabetList.contains(messageArr[i])) //if character in message is not in alphabet (i.e numbers and punctuation)
            {
                encryptedMsg[i] = alphabet[location]; //push character into encrypted message
                // int location = alphabetList.indexOf(messageArr[i]);
            }
            else
            {
                encryptedMsg[i] = messageArr[i];
            }
        }
        // System.out.println(Arrays.toString(encryptedMsg));
        String encConv = String.join("", encryptedMsg); //string to hold the encrypted message array joined to form a string
        
        return encConv; //return encrypted message
    }

    public String decrypt(String messageToDec, int shift) //method to decrypt message taking a string to decrypt and a key (shift) to use as parameters
    {

        String[] decryptedMsg = new String[messageToDec.length()]; //array to contain decrypted message

        ArrayList<String> alphabetList = new ArrayList<String>(); //array list to hold alphabet2 array (array of alphabets without a space at [0])
        for(int i = 0; i < alphabet2.length; i++) // loop to populate array list with alphabet2 elements
        {
            alphabetList.add(alphabet2[i]); // populate alphabet list with alphabet2 elements
        }
        String[] messageToDecArr = messageToDec.split(""); // array to hold message to decrypt
        // System.out.println(Arrays.toString(messageArr));
        
        // System.out.println(alphabet.length);
        
        for(int i = 0; i < messageToDecArr.length; i++) //loop to decrypt message 
        {
            if(alphabetList.contains(messageToDecArr[i])) // if alphabet list contains message to decrypt
            {
                int location = alphabetList.indexOf(messageToDecArr[i]) - shift; //variable to hold index of array of alphabet2
                if(location < 0) //if location is negative
                {
                    location = 26 - Math.abs(location); //subtract location from 26 (length of array list alphabetList)
                    decryptedMsg[i] = alphabet2[location]; //set array element at index [i] to alphabet2 at [location]
                    
                }
                else //if location is positive
                {
                    decryptedMsg[i] = alphabet2[location]; //set array element at index [i] to alphabet2 at [location]
                }
                // decryptedMsg[i] = alphabet2[location];
                // int location = alphabetList.indexOf(messageArr[i]);
            }
            
        }
        // System.out.println(Arrays.toString(encryptedMsg));
        String encConv = String.join("", decryptedMsg); //string to contain decrypted message array joined to form a string
        
        return encConv; //return decrypted message
    }

    public static void main(String args[])
    {
        CeasarCipher ciph = new CeasarCipher(); //new CeasarCipher object
        Scanner inputReaderInt = new Scanner(System.in); //Scanner to accept integer
        Scanner inputReaderStr = new Scanner(System.in); //Scanner to accept String
        System.out.print("Do you want to encrypt or decrypt (0 for encrypt) and (1 for decrypt): "); // prompt to choose mode (encrypt or decrypt)
        int encOrDec = inputReaderInt.nextInt(); //integer to determine mode (encrypt or decrypt)

        if(encOrDec == 0) //if user chooses encryption as mode
        {
            System.out.print("Enter message to encrypt: "); //prompt to enter message for encryption
            String toEnc = inputReaderStr.nextLine(); //accept message to encrypt as input
            System.out.print("Enter key of encryption: "); //prompt to enter encryption key (number of steps to the right to jump)
            int encKey = inputReaderInt.nextInt(); //accept encryption key as input
            String test = ciph.encrypt(toEnc, encKey); //store encrypted message by calling encrypt method of CeasarCipher object
            System.out.println(test); //print encrypted message
        }
        
        else
        {
            System.out.print("Enter message to decrypt: "); //prompt to enter message for decryption
            String toDec = inputReaderStr.nextLine(); //accept message to decrypt as input
            System.out.print("Enter key of decryption: "); //prompt to enter decryption key (number of steps to the left to jump)
            int decKey = inputReaderInt.nextInt(); //accept decryption key as input
            String tester = ciph.decrypt(toDec, decKey); //store decrypted message by calling encrypt method of CeasarCipher object
            System.out.println(tester); //print decrypted message
        }       
    }
}