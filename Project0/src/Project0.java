/**
 * Project0
 * @author <a href="mailto:richard.hu11@qmail.cuny.edu">Richard Zhang Hu</a>
 * Instructor: Prof. Kenneth Lord
 * Class: CSCI212 Section 12, SPR2020 MW 11:10-11:55
 * Lab: Section F with Michael Magoulis
 * Due date: 2020 February 19
 * 
 * Solicit the user to give a letter to find and the target sentence that the letter will be counted in.
 * Display the count of the lower case and upper case versions of the letter within the sentence.  
 */

import javax.swing.JOptionPane;

public class Project0 {
    public static void main(String[] args) {
        String terminationString = "stop";

        char letter = inputCharToFind();
        String sentence = inputSentence();

        //while statement to allow users to continue to input sentences until they enter the terminationString
        while (!sentence.equalsIgnoreCase(terminationString)) {
            int lowerCaseCount = countChar(sentence, Character.toLowerCase(letter));
            int upperCaseCount = countChar(sentence, Character.toUpperCase(letter));
            displayLetterCounts(Character.toLowerCase(letter), lowerCaseCount, upperCaseCount);
            letter = inputCharToFind();
            sentence = inputSentence();
        }
    }

    /**
     * Display a dialog to solicit the user to enter a single letter to search for within a string
     * @return the inputed char
     */
    public static char inputCharToFind() {
        char letter = Character.MIN_VALUE;

        while (letter == Character.MIN_VALUE) {
            String letterBuffer = JOptionPane.showInputDialog(null, "Please enter a letter to find.");

            //showInputDialog null value handling on clicking the cancel button
            if (letterBuffer == null) {
                System.exit(0);
            }

            //logic block is here to ask the user to input a singular character to search for if they previously entered more than one character
            if (letterBuffer.length() != 1) {
                JOptionPane.showMessageDialog(null,  "Please enter only one letter.");
            }
            else {
                letter = letterBuffer.charAt(0);
            }
        }
        return letter;
    }
    
    /**
     * Display a dialog to solicit the user to enter a sentence
     * @return the inputed sentence string
     */
    public static String inputSentence() {
        String sentence = JOptionPane.showInputDialog(null, "Please enter a sentence.");

        //showInputDialog null value handling on clicking the cancel button
        if (sentence == null) {
            System.exit(0);
        }
        return sentence;
    }

    /**
     * Goes through the sentence string and returns the count of instances of the letter char
     * @param sentence: the target string that countChar will iterate over
     * @param letter: the target char that countChar will iterate over the sentence to count
     * @return the count of the character as an int
     */
    public static int countChar(String sentence, char letter) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    static void displayLetterCounts(char letter, int lowerCaseCount, int upperCaseCount) {
        /**
         * Displays a dialog with the count of both the lower case and upper case versions of the letter
         * @param letter: the letter that countChar counted instances for
         * @param lowerCaseCount: the number of times the lower case version of letter was found in the sentence string
         * @param upperCaseCount: the number of times the upper case version of letter was found in the sentence string
         */
        String displayLowerCaseString = "Number of lower case " + Character.toLowerCase(letter) + "'s: " + lowerCaseCount;
        String displayUpperCaseString = "Number of upper case " + Character.toUpperCase(letter) + "'s: " + upperCaseCount;
        JOptionPane.showMessageDialog(null, displayLowerCaseString + '\n' + displayUpperCaseString);
    }
}
