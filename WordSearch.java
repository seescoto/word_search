/**
sofia escoto
makes a word search grid that can be printed out and/or put into a txt file
gives whatever words given
*/

import java.util.*; //array list, iterator, etc

public class WordSearch {

    private char[][] grid;
    private ArrayList<String> wordList;
    private int maxWordSize = 0;
    private String title = "Word Search"; //can be changed later

    private final int MINSIZE = 10;
    private final char DELIM = '+'; //marks empty space in the grid

    //constructor methods
    WordSearch(int size) {
        grid = newGrid(size);
        wordList = new ArrayList<String>();

    }

    WordSearch() {
        grid = newGrid(MINSIZE);
        wordList = new ArrayList<String>();
    }

    WordSearch(int size, String[] words) {
        grid = newGrid(size);
        wordList = new ArrayList<String>();
        setWordList(words);
    }

    WordSearch(String[] words) {
        grid = newGrid(MINSIZE);
        wordList = new ArrayList<String>();
        setWordList(words);
    }

    //enter an entire list of words
    public void setWordList(String[] words) {
        //set initial word list
        for (String w : words) {
            wordList.add(w);
            //if word is longer than all the ones before, change maxWordSize
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

    /**
    choose a random spot for word, choose direction, check if word fits there. if it does, place it and
    remove from the wordList, if not try again (up to 25 times)
    if 25 times have passed, write a little warning to the user that the word wasnt put into the crossword
    and tell them to expand the grid or put fewer words in next time
    place word gives a boolean - true if placed, false if not placed
    */
    public boolean placeWord(String word) {

    }

    private String getDirection() {
        //returns a random direction for the word to go in the crossword
        //left, right, up, down, left up, left down, right up, right down (8 options)
        Random rand = new Random();
        int num = rand.nextInt(8);
        String[] directions = {"l", "r", "u", "d", "lu", "ld", "ru", "rd"};
        return directions[num];

    }

    public boolean wordFits(String word, int row, int col, String direction) {
        //returns if the word fits in the space
        //recursive method
        boolean fits;

        //base case -> length = 0, obv fits
        if (word.length() == 0) {
            fits = true;
        }
        else {
            //get word without the first letter and check at the next spot
            newWord = word.subString(1);
            newRow = getNextRow(row, direction);
            newCol = getNextCol(col, direction)
            fits = charFits(word.charAt(0), row, col) & wordFits(newWord, newRow, newCol, direction);
        }

        return fits;
    }

    private boolean charFits(char letter, int row, int col) {
        
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


    //helper methods

    //makes the word search bigger if it's less than h x h where h = maxWordSize + 10
    private void resize() {
        if (grid.length < (maxWordSize + 10)) {
            grid = newGrid(maxWordSize + 10)
        }
    }

    //creates the size x size word grid and fills with given delimeter to mark as empty
    private char[][] newGrid(int size) {

        char[][] g = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g[i][j] = DELIM;
            }
        }
        return g;

    }

    //makes the word search bigger if it's less than h x h where h = maxWordSize + 10
    private void resize() {
        if (grid.length < (maxWordSize + 10)) {
            grid = newGrid(maxWordSize + 10)
        }
    }

    //returns the next row to go to given a direction
    //no need for error messages, will check for this in wordFits() method
    private int getNextRow(int currRow, String direction) {
        int newRow;

        if (direction.equals("l") | direction.equals("lu") | direction.equals("ld")) {
            //if left
            newRow = currRow - 1;
        }
        else if (direction.equals("u") | direction.equals("d")) {
            //if up or down
            newRow = currRow;
        }
        else {
            //to right
            newRow = currRow + 1;
        }

        return newRow;
    }

    //returns next col to go to given a direction
    //no need for error messages, will check in wordFits()
    private int getNextCol(int currCol, String direction) {
        int newCol;

        if (direction.equals("u") | direction.equals("lu") | direction.equals("ru")) {
            //if up
            newCol = currCol - 1;
        }
        else if (direction.equals("l") | direction.equals("r")) {
            //if left or right
            newCol = currCol;
        }
        else {
            //down
            newCol = currCol + 1;
        }

        return newRow;
    }



}
