/**
sofia escoto
makes a number search grid
just for one search, not going to be used often
*/

import java.util.*;

public class NumberSearch extends WordSearch {
    //instance variables not inherited and/or needing to be changed
    private final int MINSIZE = 5;
    private final int MAXSIZE = 10;
    private String charsToFill = "0123456789";
    private char[] ctf = charsToFill.toCharArray();


    public static void main(String args[]) {

        NumberSearch ns = new NumberSearch();
        String[] years = {"1938", "1941", "1961", "1962", "1965", "1970", "2000", "2003",
                            "2006", "2010"};
        ns.setWordList(years);
        ns.setTitle("Important Years");
        ns.setSearchGrid();

        System.out.println(ns);

    }

}
