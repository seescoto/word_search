/**
sofia escoto

word driver - prompts the user to create a word search and save it to a file
(not doing that rn, just testing)
*/

public class WordDriver {
    public static void main(String args[]) {

        String[] w = {"hello", "goodbye", "testing", "again",
        "trying", "sofia", "bestie", "dude", "abcdefghij",
        "more", "words", "idk", "sofia"};
        WordSearch ws = new WordSearch(20);

        ws.setWordList(w);
        ws.setSearchGrid();

        System.out.println(ws);
    }
}
