/**
 * Created by nicholasroberson on 5/27/16.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public int[][] adjArr;

    /*
    CONSTRUCTOR FOR THE PARSER
     */
    @SuppressWarnings("unchecked")
    public Parser() {
        adjArr = new int[26][26];
    }

    /*
    GRABS EACH 2-SET OF THE WORD AND ADDS IT TO THE LIST AT THE PROPER INDEX BY CALLING addIndex();
     */
    public void parse(Scanner in) {
        String str = "";
        char ch1 = ' ';
        char ch2 = ' ';
        while (in.hasNextLine()) {
            str = in.nextLine().toLowerCase();
            for (int i = 0; i < str.length() - 1; i++) {
                ch1 = str.charAt(i);
                ch2 = str.charAt(i + 1);
                addIndex(ch1,ch2);
            }
        }
    }
    /*
    TAKES IN TWO CHARS AND INCREMENTS THE PROPER INDEX IN THE 2D ARRAY
     */
    public void addIndex(char ch1, char ch2) {
        int keyIndex = ((int) ch1) - 97;
        int folIndex = ((int) ch2) - 97;
        System.out.println(keyIndex + " : " + folIndex);
        if(folIndex <= 97 && keyIndex <= 97 && folIndex >= 0 && keyIndex >= 0) {
            adjArr[folIndex][keyIndex]++;
        }
    }

    /*
    RETURNS THE LENGTH OF THE LIST
     */
    public int length() { return adjArr.length; }

    /*
    PRINTS THE  PAIRS FOR EACH LETTER IN THE LIST
     */
    public void toString(int i) {
        char ch = (char) (i + 97);
        char folChar = ' ';
        System.out.println("The Letter " + ch + " has the following letters with frequencies: ");
        for(int j = 0; j < adjArr.length; j++) {
            folChar = (char) (j + 97);
            System.out.print(folChar + " : " + adjArr[j][i] + "\n");
        }
    }

    /*
    DRIVER FUNCTION THAT RUNS THE PARSER AND PRINTS THE PAIRS FOR EACH LETTER
     */
    public static void main(String[] args) throws FileNotFoundException {
        File infile = new File("src/dictionary");
        Scanner in = new Scanner(infile);

        Parser p1 = new Parser();
        p1.parse(in);
        for (int i = 0; i < p1.length(); i++) {
            p1.toString(i);
        }

        GetAdjKeys.getAdjKeys(p1.adjArr);
    }
}










