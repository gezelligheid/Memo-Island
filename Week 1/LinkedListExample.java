public class LinkedListExample {
    /* Test program to test above functions. Ideally
       this function should be in a separate user class.
       It is kept here to keep code compact */
    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList<Integer> llist = new LinkedList<>();
        llist.add(1);
        llist.add(3);
        llist.add(1);
        llist.add(2);
        llist.add(1);

        llist.delete(2);

        System.out.println("Count of nodes is " +
                llist.getCount());

        System.out.println("Value of node at index 3 is " +
                llist.get(3));

    }
}