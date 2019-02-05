public class HashMap<E> {

    private final static int TABLE_SIZE = 128;

    HashEntry<E>[] table;

    public HashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public E get(int key) {
        int hash = (key % TABLE_SIZE);

        if (table[hash] == null)
            return null;
        else
            return table[hash].getValue();
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);
        table[hash] = new HashEntry(key, value);
    }
}