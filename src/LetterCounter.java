/**
 * Created by nicholasroberson on 5/27/16.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LetterCounter<T> {

    public List<Pair<Character, Integer>>[] lettercounter;

    @SuppressWarnings("unchecked")
    public LetterCounter() {
        this.lettercounter = new LinkedList[10];
        for (int i = 0; i < lettercounter.length; i++) {
            lettercounter[i] = new LinkedList<Pair<Character, Integer>>();
        }
    }

    public int length() {
        return lettercounter.length;
    }

    public int length(int index) {
        return lettercounter[index].size();
    }
    public boolean hasKey(char ch) {
        for (int i = 0; i < lettercounter.length; i++) {
            for (int j = 0; j < lettercounter[i].size(); j++) {
                if (lettercounter[i].get(j).key == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(Pair<Character, Integer> p) {
        lettercounter[p.val].add(p);
    }

    public String toString(int index) {
        String ret = "Index " + index + " contains: [ ";
        for (int i = 0; i < lettercounter[index].size(); i++) {
            ret += ((char) lettercounter[index].get(i).getKey()) + " ";
        }
        return ret + "]";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(new File("src/dictionary"));
        String line = "";
        char ch = ' ';
        int index;
        LetterCounter<Pair<Character, Integer>> lc = new LetterCounter<Pair<Character, Integer>>();
        while (in.hasNextLine()) {
            line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                ch = line.charAt(i);
                if (!(lc.hasKey(ch))) {
                    index = ((int) ch) % lc.length();
                    lc.add(new Pair(ch, index));
                }
            }
        }

        for (int i = 0; i < lc.length(); i++) {
            System.out.println(lc.toString(i));
        }
        int size = 0;
        for (int i = 0; i < lc.length(); i++) {
            size += lc.length(i);
        }
        System.out.println("Total size is: " + size);

    }

}
