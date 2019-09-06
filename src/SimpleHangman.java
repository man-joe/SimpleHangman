
/*
You are going to write a word guessing game app in Java. This game is a simpler version of Hangman.

Requirements:

Initialize your array list with the following words:
tree
rain
bear
encourage
promise
soup
chess
insurance
pancakes
stream

When you run the application, randomly choose a word from that list for the user to guess.
For each letter the user guesses wrong, let them know along with how many wrong guesses they have left.
The user is allowed up to 5 wrong guesses. On the 6th wrong guess, they lose the game.
If the user guesses correctly, output the word with the letters they have guessed correctly so far and blanks for
letters they have not guessed yet.
The user can input either a letter or a word for their guess.
If the user guesses the word correctly, output "You've won!" and end the game.
 */

import java.util.Random;
import java.util.Scanner;

public class SimpleHangman {

    public static void main(String[] args){
        String[] hangWords = new String[]{"tree","rain","bear","encourage","promise","soup","chess","insurance",
                "pancakes","stream"};
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String inputGuess = "";
        String[] currentGuess;

        int randNum = rand.nextInt(10);
        String rightWord = hangWords[randNum];
        currentGuess = new String[rightWord.length()];

        System.out.println("Welcome! Let's play hangman!");
        System.out.print("Here is the word I'm thinking of: ");

        for(int i = 0; i < rightWord.length(); i++) {
            currentGuess[i] = "_";
            System.out.print(currentGuess[i] + " ");
        }

        System.out.println("\n" + rightWord);
        int numOfGuesses = 0;
        boolean checkWin = false;

        while(numOfGuesses < 6) {
            // Check if you've won
            for(int i = 0; i < rightWord.length(); i++){
                if(!currentGuess[i].equals(String.valueOf(rightWord.charAt(i)))){
                    checkWin = false;
                    break;
                } else
                    checkWin = true;
            }

            if(inputGuess.equals(rightWord) || checkWin) {
                System.out.println("\nYou've won! The word was " + rightWord + ".");
                break;
            } else {
                System.out.print("\nEnter your guess: ");
                inputGuess = sc.next();
            }

            if(rightWord.contains(inputGuess) && !inputGuess.equals(rightWord)) {
                String temp = "";
                for(int i = 0; i < rightWord.length(); i++){
                    temp = String.valueOf(rightWord.charAt(i));
                    if(temp.equals(inputGuess))
                        currentGuess[i] = temp;
                }

            }else if(!rightWord.contains(inputGuess)){
                numOfGuesses++;
                System.out.println("You have guessed incorrectly " + numOfGuesses + "/6 times.");
                if(numOfGuesses == 6)
                    System.out.println("Sorry. You have no more guesses left. The word was " + rightWord + ".");
            }

            if(!inputGuess.equals(rightWord)){
                System.out.print("Your guess so far: ");
                for(int i = 0; i < rightWord.length(); i++)
                    System.out.print(currentGuess[i] + " ");
            }
        }
        System.out.println("Thank you for playing!");
        sc.close();
    }

}

