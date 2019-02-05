public class HashEntry<E> {

    private int key;
    private E value;

    HashEntry(int key, E value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

}