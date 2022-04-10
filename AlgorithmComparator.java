import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

// main method for test running
class Main{
    public static void main(String[] args) {
        AlgorithmComparator.test();
    }
}

public class AlgorithmComparator {

    public static void test() {
        
        PatternSearch id1 = new BruteSearch("id1");
        PatternSearch id2 = new KMPSearch("id2");

        // implement Java scanner for user input, to close Scanner: input.close();
        Scanner myScan = new Scanner(System.in);     
        while (true) {
            // describe what this program's for
            System.out.println("***This program is used for pattern searching and testing benefits of using different algorithms***");
            // simple directions for the user
            System.out.println("***To select, use terminal and input number + ENTER***");

            System.out.println("1. Submit variables to be tested");
            System.out.println("2. To compare available algorithms");
            System.out.println("9. to exit and close Scanner");

            String pick = myScan.nextLine();
            // track user selections, to provide more functional and responsive UI (if needed/not implemented yet)
            if (pick.equals("1")) {

                System.out.println("Please set the pattern to be searched:");
                id1.setPattern(myScan.nextLine());
                id2.setPattern(id1.getPattern());
                System.out.println("Pattern is set: " + id1.getPattern());

                System.out.println("Next, please provide text to process:");
                id1.setText(myScan.nextLine());
                id2.setText(id1.getText()); 
                System.out.println("Thank you! Setting new parameters..");
       
            }
            if (pick.equals("2") && id1.getPattern() != null && id1.getText() != null) {
                System.out.println("Performance for classic brute force algorithm with given parameters is:");
                id1.getTime();
                System.out.println("Performance for the more advanced KMP algorithm with given parameters is:");
                id2.getTime();
                System.out.println("---Please note that performance may vary, and difference may become more noticeable when trying out with different string complexities and lengths!---");
            }
            if (pick.equals("9")) {
                break;
            } else {
                System.out.println("---Please make your selection from currently available choices and/or choose '1' to set method parameters if they are not set---");
            }
        }

        System.out.println("Thank you, closing Scanner...");
        myScan.close();
        System.out.println("Scanner is now closed");
    }

}

// Abstact 

abstract class PatternSearch {
    
    // every search has an object to look for
    // search needs material to go through
    private String searchID;
    private String pattern;
    private String text;

    // Class Constructor
    PatternSearch(String searchID) {
        this(searchID,"","");
    }

    PatternSearch(String searchID, String pattern, String text) {
        this.searchID = searchID;
        this.pattern = pattern;
        this.text = text;
    }

    // other constructors and methods
    String getSearchID() {
        return this.searchID;
    }

    String getPattern() {
        return this.pattern;
    }

    String getText() {
        return this.text;
    }

    void setSearchID(String newSearchID) {
        this.searchID = newSearchID;
    }

    void setPattern(String newPattern) {
        this.pattern = newPattern;
    }

    void setText(String newText) {
        this.text = newText;
    }

    public abstract void getHits();
    public abstract void getTime();
    
}

// simple Brute Force algorithm 

class BruteSearch extends PatternSearch {
    private String searchID;
    private String pattern;
    private String text;

    BruteSearch(String searchID) {
        super(searchID,"","");
    }

    BruteSearch(String searchID, String pattern, String text) {
        super(searchID, pattern, text);
    }

    String getSearchID() {
        return this.searchID;
    }

    String getPattern() {
        return this.pattern;
    }

    String getText() {
        return this.text;
    }

    void setSearchID(String newSearchID) {
        this.searchID = newSearchID;
    }

    void setPattern(String newPattern) {
        this.pattern = newPattern;
    }

    void setText(String newText) {
        this.text = newText;
    }
    
    //for (string pattern, String text)
    public void getHits() {
        ArrayList <Integer> patFoundAt = new ArrayList();
        String pattern = getPattern();
        String text = getText();
        int M = pattern.length();
        int N = text.length();
        int j = 0; // index for pat[]
        int i = 0; // index for txt[]

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                patFoundAt.add(i - j);
                j = 0;
            }

            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) { 
                    j = 0;
                } else {
                    i = i + 1;
                }

            }
        }
        // algorithm has finished & patFoundAt countains indexes of hits
        if (patFoundAt.isEmpty()) {
            System.out.println("Your query found no matches.");
        }
        else {
            System.out.println("Number of matches: " + patFoundAt.size());
            System.out.println("Matches found at indexes: ");
            patFoundAt.forEach(System.out::println);
        }

        
    }
    //for (string pattern, String text)
    public void getTime() {

        long startTime = System.nanoTime();
        // run the code to be measured
        getHits();
        // end timer
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }

}

// Knuth-Morris-Pratt algorithm java application

class KMPSearch extends PatternSearch {
    private String searchID;
    private String pattern;
    private String text;

    KMPSearch(String searchID) {
        super(searchID,"","");
    }

    KMPSearch(String searchID, String pattern, String text) {
        super(searchID, pattern, text);
    }

    String getSearchID() {
        return this.searchID;
    }

    String getPattern() {
        return this.pattern;
    }

    String getText() {
        return this.text;
    }

    void setSearchID(String newSearchID) {
        this.searchID = newSearchID;
    }

    void setPattern(String newPattern) {
        this.pattern = newPattern;
    }

    void setText(String newText) {
        this.text = newText;
    }
    
    //for (string pattern, String text)
    public void getHits() {
        ArrayList <Integer> patFoundAt = new ArrayList();
        String pattern = getPattern();
        String text = getText();
        int M = pattern.length();
        int N = text.length();
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        computeLPSArray(pattern, M, lps);

        int i = 0; // index for txt[]

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                patFoundAt.add(i - j);
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) { 
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }

            }
        }
        // algorithm has finished & patFoundAt countains indexes of hits
        if (patFoundAt.isEmpty()) {
            System.out.println("Your query found no matches.");
        }
        else {
            System.out.println("Number of matches: " + patFoundAt.size());
            System.out.println("Matches found at indexes: ");
            patFoundAt.forEach(System.out::println);
        }
    }

    void computeLPSArray(String pat, int M, int lps[]) { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
  
        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } else { 
                if (len != 0) { 
                    len = lps[len - 1]; 
                } else { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    }

    //for (string pattern, String text)
    public void getTime() {

        long startTime = System.nanoTime();
        // run the code to be measured
        getHits();
        // end timer
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }

}
