/**
sofia escoto
makes a word search grid that can be printed out and/or put into a txt file
gives whatever words given
*/


public class WordSearch {

    private char[][] grid;
    priate final int MINSIZE = 10;
    private LinkedList<String> words;
    private int maxWordSize = 0;
    private String title = "Word Search"; //can be changed later


    //constructor methods
    public WordSearch(int size) {
        grid = new char[size][size];
        words = new ArrayList<String>();

    }

    public WordSearch() {
        grid = new char[MINSIZE][MINSIZE];
        words = new ArrayList<String>();
    }

    public WordSearch(int size, String[] words) {
        grid = new char[size][size];
        words = new ArrayList<String>();
        setWordList(words);
    }

    public WordSearch(String[] words) {
        grid = new char[MINSIZE][MINSIZE];
        words = new ArrayList<String>();
        setWordList(words);
    }

    //enter an entire list of words
    public void setWordList(String[] words) {
        //set initial word list
        for (String w : words) {
            words.add(w);
            //if word is longer than all the ones before, change maxWordSize and make sure
            if (w.length() > maxWordSize) {
                maxWordSize = w.length();
            }
        }
        resize();

    }

    //add words one by one
    public void addToWordList(String newWord) {
        words.add(newWord);
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
        String mssg = "";
        int width = grid.length + 6;

        //print top line
        for (int i = 0; i < width; i++) {
            mssg += "-";
        }

        //print all lines
        for (int row = 0; row < grid.length; row++) {
            mssg += "|" + "\t";
            for (int col = 0; col < grid[row].length; col++) {
                mssg += grid[row][length] + "\t";
            }
            mssg += "|" + "\n";
        }

        //print bottom line
        for (int i)
    }



}
