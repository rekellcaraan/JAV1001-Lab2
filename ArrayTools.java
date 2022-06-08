// Student Name: Rekell Caraan
// Student Number: A00133304
// Program Description: The following program "ArrayTools.java" provides useful tools for developers:
// Caesar Cipher encryption
// Calculates average of array of integers
// Searches a number on an array of integers
// Reverses the order of elements on an array of integers

import java.util.Scanner;

public class ArrayTools {

    // Main Method
    public static void main(String[] args)
    {
        Scanner keyboardinput = new Scanner(System.in);

        System.out.println("Enter a string to encrypt:");

        String stringtoEncrypt = keyboardinput.nextLine();

        System.out.println("Enter a value to encrypt with:");

        int encryptionValue = keyboardinput.nextInt();

        optionCaesarCipher(stringtoEncrypt, encryptionValue);

        int[] arrayNumbers = { 44, 78, 45, 77, 44, 98, 67, 68, 91, 54 };

        System.out.println("Testing methods with [ " + displayArray(arrayNumbers, false));

        System.out.println("The average is " + getArrayAverage(arrayNumbers));
        
        System.out.println("Enter a value to search for. ");

        int searchNumber = keyboardinput.nextInt();

        if(doesArrayContains(arrayNumbers, searchNumber)){
            System.out.println("The array contains " + searchNumber);
        }
        else{
            System.out.println("The array does not contain " + searchNumber);
        }

        System.out.println("The array reversed is [ " + displayArray(arrayNumbers, true));

        keyboardinput.close();
    }

    // Encrypts and Decrypts a string input using Caesar Cipher
    private static void optionCaesarCipher(String stringtoEncrypt,int encryptionValue){

        var encryptedString = generateCaesarCipher(stringtoEncrypt, encryptionValue);
        
        System.out.println("The encrypted string is " + encryptedString);

        var decryptionValue = encryptionValue * -1;
        var decryptedString =  generateCaesarCipher(encryptedString, decryptionValue);

        System.out.println("Decrypting " + encryptedString + " with " + decryptionValue + "...");
        System.out.println(decryptedString);
    }

    // Handles the Caesar Cipher logic based from the input string and the shift integer input
    private static String generateCaesarCipher(String inputString, int shiftCount){

        if(inputString != ""){
            
            char[] characterArray = new char[inputString.length()];
            
            for(int characterindex = 0; characterindex < inputString.length(); characterindex++){
                char character = inputString.charAt(characterindex);
                char shiftedChar = shiftCharacter(character, shiftCount);
                characterArray[characterindex] = shiftedChar;
            }

            return new String(characterArray);
        }

        return inputString;
    }

    // Shifts the character based on the shift integer input and referencing the ASCII Table
    private static char shiftCharacter(char character, int characterShiftCount){

        if(characterShiftCount != 0){

            int characterInASCII = (int) character;

            int range = characterInASCII + characterShiftCount;

            if(range > 126){
                int equivalentCharacter = (range - 126) + 32;    

                return (char) (equivalentCharacter);
            }
            else if(range < 32){
                int equivalentCharacter = 126 - (32 - range);

                return (char) (equivalentCharacter);
            }
            else{
                return (char) (characterInASCII + characterShiftCount);
            }
        }
        return character;
    }

    // Gets the average of the array of integers
    private static float getArrayAverage(int[] arrayNumbers){
        
        var totalOfNumbers = 0f;

        for(int index = 0; index < arrayNumbers.length; index++){
            totalOfNumbers += arrayNumbers[index];
        }

        return totalOfNumbers / arrayNumbers.length;
    }

    // Displays the given array in normal order or reverse order
    private static String displayArray(int[] arrayNumbers, boolean inReverseOrder){
        var arrayNumbersString = "";
        
        if(!inReverseOrder){
            for(int index = 0; index < arrayNumbers.length; index++){
                arrayNumbersString += arrayNumbers[index] + ", ";
            }
        }
        else{
            for(int index = arrayNumbers.length - 1; index >= 0; index--){
                arrayNumbersString += arrayNumbers[index] + ", ";
            }
        }

        int lastindexOfComma = arrayNumbersString.lastIndexOf(',');
        var suffixClosedBracket = " ]";
        var arrayToDisplay = arrayNumbersString.substring(0, lastindexOfComma) + suffixClosedBracket;

        return arrayToDisplay;
    }

    // Checks if the array of integers contains a number
    private static boolean doesArrayContains(int[] arrayNumbers, int searchNumber){
        
        for(int index = 0; index < arrayNumbers.length; index++){
            if(arrayNumbers[index] == searchNumber){
                return true;
            }
        }

        return false;
    }
}