/**
sofia escoto
makes a word search grid that can be printed out and/or put into a txt file
gives whatever words given
*/

import java.util.*; //array list, iterator, etc

public class WordSearch {

    private char[][] grid;
    private final int MINSIZE = 10;
    private ArrayList<String> wordList;
    private int maxWordSize = 0;
    private String title = "Word Search"; //can be changed later


    //constructor methods
    WordSearch(int size) {
        grid = new char[size][size];
        wordList = new ArrayList<String>();

    }

    WordSearch() {
        grid = new char[MINSIZE][MINSIZE];
        wordList = new ArrayList<String>();
    }

    WordSearch(int size, String[] words) {
        grid = new char[size][size];
        wordList = new ArrayList<String>();
        setWordList(words);
    }

    WordSearch(String[] words) {
        grid = new char[MINSIZE][MINSIZE];
        wordList = new ArrayList<String>();
        setWordList(words);
    }

    //enter an entire list of words
    public void setWordList(String[] words) {
        //set initial word list
        for (String w : words) {
            wordList.add(w);
            //if word is longer than all the ones before, change maxWordSize and make sure
            if (w.length() > maxWordSize) {
                maxWordSize = w.length();
            }
        }
        resize();

    }

    //add words one by one
    public void addToWordList(String newWord) {
        wordList.add(newWord);
        //check if need to change maxWordSize, if so resize
        if (newWord.length() > maxWordSize) {
            maxWordSize = newWord.length();
            resize();
        }

    }

    //makes the word search bigger if it isn't h x h where h = maxWordSize + 10
    public void resize() {
        if (grid.length < (maxWordSize + 10)) {
            grid = new char[maxWordSize + 10][maxWordSize + 10];
        }

    }


    //returns string of char grid (formatted)
    @Override
    public String toString() {
        String mssg = "|";
        int width = grid.length * 4; //edit later when working with real words


        //print top line
        for (int i = 0; i < width; i++) {
            mssg += "-";
        }

        //print all lines
        for (int row = 0; row < grid.length; row++) {
            mssg += "|" + "\t";
            for (int col = 0; col < grid[row].length; col++) {
                mssg += grid[row][col] + "\t";
            }
            mssg += "|" + "\n";
        }

        mssg += "|";
        //print bottom line
        for (int i = 0; i < width; i++) {
            mssg += "-";
        }

        mssg += "|" + "\n";

        //print word list
        Iterator<String> iter = wordList.iterator();
        while (iter.hasNext()) {
            mssg += iter.next() + "\t\t";
        }

        return mssg;
    }



}
