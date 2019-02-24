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
            Iterator iterator = table[hash].iterator();
            while (iterator.hasNext()){
                HashEntry<E> theValue = (HashEntry<E>) iterator.next();
                if (theValue.getKey() == key){
                    return theValue.getValue();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);
        table[hash].push(new HashEntry(key, value));
    }
}