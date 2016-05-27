/**
 * Created by nicholasroberson on 5/27/16.
 */
public class Pair<T, V> {

    public T key;
    public V val;

    public Pair(T key, V val) {
        this.key = key;
        this.val = val;
    }

    public T getKey() {
        return key;
    }

    public V getVal() {
        return val;
    }

}
