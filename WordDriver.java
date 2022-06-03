/**
sofia escoto

word driver - prompts the user to create a word search and save it to a file
(not doing that rn, just testing)
*/

import java.util.*; //scanner, etc
import java.io.*; //file write

public class WordDriver {
    public static void main(String args[]) {


        //while loop
        //asks user what file to write to, optional size of word search, words, optional title
        //shows preview and then asks if you want to save it to the file
        //then asks if you want to do another one
        boolean keepGoing = true;
        Scanner keyboard = new Scanner(System.in);

        while (keepGoing) {
            WordSearch ws = new WordSearch();

            //get file to write to
            System.out.println("What file would you like to save your word search to?");
            String file = keyboard.nextLine();

            //get words
            System.out.println("What are the words you would like to put in your word search?");
            System.out.println("Separate phrases by a comma and a space.");
            String words = keyboard.nextLine();
            String[] wordList = words.split(", |,");

            //title
            System.out.println("What would you like the title of your word search to be?");
            String title = keyboard.nextLine();

            //set word search up
            ws.setWordList(wordList);
            ws.setTitle(title);
            ws.setSearchGrid();

            //preview and ask if want to save
            System.out.println("This is a preview of your wordsearch.");
            System.out.println(ws);
            System.out.println("Would you like to save this to the file " + file + "? (Y/N)");

            if (getYesNo()) {
                try {
                    FileWriter myFile = new FileWriter(file);
                    myFile.write(ws.toString());
                    myFile.close();
                    System.out.println("Word search saved to " + file + ".");
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            //ask if want to do another one (keepGoing)
            System.out.println("Would you like to create another word search? (Y/N)");
            keepGoing = getYesNo();

        }

        /**

        String[] w = {"hello", "goodbye", "testing", "again",
        "trying", "sofia", "bestie", "dude", "abcdefghij",
        "more", "words", "idk", "sofia"};
        WordSearch ws = new WordSearch(20);

        ws.setWordList(w);
        ws.setSearchGrid();

        System.out.println(ws);

        */
    }

    public static boolean getYesNo() {
        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.next();
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
            return true;
        }
        else {
            return false;
        }

    }
}
