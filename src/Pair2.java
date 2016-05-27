/**
 * Created by nicholasroberson on 5/27/16.
 */
public class Pair2 {
    public char key;
    public int val;

    public Pair2(char ch, int val){
        this.key = ch;
        this.val = val;
    }

    public void increment () {
        this.val++;
    }

    public char getKey() {
        return this.key;
    }

    public int getFreq () {
        return this.val;
    }

    public String toString() {
        return "[ " + this.key + " , " + this.val + " ]";
    }
}
