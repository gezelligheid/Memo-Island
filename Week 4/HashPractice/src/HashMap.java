import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<E> {

    private final static int TABLE_SIZE = 128;

    LinkedList<HashEntry<E>>[] table;

    public HashMap() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public E get(int key) {
        int hash = (key % TABLE_SIZE);

        if (table[hash] == null)
            return null;
        else {
            Iterator<HashEntry<E>> iterator = table[hash].iterator();
            while (iterator.hasNext()) {
                HashEntry<E> theValue = iterator.next();
                if (theValue.getKey() == key) {
                    return theValue.getValue();
                }
            }
        }
        return null;
    }

    public void put(int key, E value) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null){
            table[hash] = new LinkedList<>();
        }
        table[hash].push(new HashEntry<>(key, value));
    }
}