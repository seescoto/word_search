//sofia escoto
//makes a word search grid that can be printed out and adds whatever words given

public class WordSearch {

    private char[][] grid;
    priate final int MINSIZE = 10;
    private LinkedList<String> words;
    private int maxWordSize;


    public WordSearch(int size) {
        grid = new char[size][size];
        words = new ArrayList<String>();

    }

    public WordSearch() {
        grid = new char[MINSIZE][MINSIZE];
        words = new ArrayList<String>();
    }

    public setWordList(String[] words) {
        //set initial word list
        maxWordSize = 0;
        for (String w : words) {
            words.add(w);
            //if word is longer than all the ones before, change maxWordSize and make sure
            if (w.length() > maxWordSize) {
                maxWordSize = w.length();
            }
        }

        //make sure grid is big enough for all the words
        if (grid.length < (maxWordSize + 10)) {
            grid = new char[maxWordSize + 10][maxWordSize + 10];
        }

    }



}
