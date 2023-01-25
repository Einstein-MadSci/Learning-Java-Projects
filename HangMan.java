import java.util.*;

public class HangMan
{
    public static void main(String args[])
    {
        Scanner inputReaderInt = new Scanner(System.in);
        Scanner inputReaderStr = new Scanner(System.in);
        String[] wordList = {"man", "woman", "aadvark", "baboon", "camel"};
        String chosenWord = wordList[(int)(Math.random() * 3)];
        String[] chosenWordArr = chosenWord.split("");
        System.out.println(Arrays.toString(chosenWordArr));
        String[] arrOfXs = new String[chosenWord.length()];
        for(int i = 0; i < arrOfXs.length; i++)
        {
            arrOfXs[i] = "x";
        }
        // System.out.println(Arrays.toString(arrOfXs));
        String[] arrOfHashes = new String[chosenWord.length()];
        for(int i = 0; i < arrOfHashes.length; i++)
        {
            arrOfHashes[i] = "#";
        }
        // System.out.println(Arrays.toString(arrOfHashes));
        System.out.print("Choose difficulty (0 for Easy) and (1 for Hard): ");
        int levelSelector = inputReaderInt.nextInt();

        // System.out.println(levelSelector);

        int tries = 0;

        // while(levelSelector < 0 || levelSelector > 1)
        // {
            if(levelSelector == 0)
            {
                tries = 20;

                int passOrFail = 0;
            
                String guessedLetter = "";
                String chosenWordConv = "";
                String arrOfHashesStr = "";
                // System.out.println(guessedLetter);

                while(tries > 0)
                {
                    System.out.print("Guess a letter: ");
                    guessedLetter = inputReaderStr.nextLine();                
                    for(int i = 0; i < chosenWordArr.length; i++)
                    {
                        if(chosenWordArr[i].contains(guessedLetter))
                        {
                            arrOfXs[i] = guessedLetter;
                            chosenWordArr[i] = "#";
                            break;
                        }
                    }
                    chosenWordConv = String.join("", chosenWordArr);
                    System.out.println(chosenWordConv);
                    arrOfHashesStr = String.join("", arrOfHashes);
                    if(chosenWordConv.equals(arrOfHashesStr))
                    {
                        passOrFail = 1;
                        break;
                    }
                    // System.out.println(Arrays.toString(chosenWordArr));
                    // System.out.println(Arrays.toString(arrOfXs));    
                    tries--;
                
                }

                if(passOrFail == 1)
                {
                    System.out.println("Congratulations! You won!");
                }
                else
                {
                    System.out.println("Game Over! You Lost!");
                }           
            }
            else
            {
                tries = 10;

                int passOrFail = 0;
            
                String guessedLetter = "";
                String chosenWordConv = "";
                String arrOfHashesStr = "";
                // System.out.println(guessedLetter);

                while(tries > 0)
                {
                    System.out.print("Guess a letter: ");
                    guessedLetter = inputReaderStr.nextLine();                
                    for(int i = 0; i < chosenWordArr.length; i++)
                    {
                        if(chosenWordArr[i].contains(guessedLetter))
                        {
                            arrOfXs[i] = guessedLetter;
                            chosenWordArr[i] = "#";
                            break;
                        }
                    }
                    chosenWordConv = String.join("", chosenWordArr);
                    System.out.println(chosenWordConv);
                    arrOfHashesStr = String.join("", arrOfHashes);
                    if(chosenWordConv.equals(arrOfHashesStr))
                    {
                        passOrFail = 1;
                        break;
                    }
                    // System.out.println(Arrays.toString(chosenWordArr));
                    // System.out.println(Arrays.toString(arrOfXs));    
                    tries--;
                
                }

                if(passOrFail == 1)
                {
                    System.out.println("Congratulations! You won!");
                }
                else
                {
                    System.out.println("Game Over! You Lost!");
                }
            }
        // }
    }
}