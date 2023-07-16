public class LinkedListDeque<T> {
    private int size;
    private DequeNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new DequeNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    @Override
    public void addFirst(T item) {
        sentinel.next.prev = new DequeNode(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev.next = new DequeNode(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0 );
    }

    public int size() {
        return size;
    }

    @Override
    public void printDeque(){
        DequeNode first = sentinel.next;
        while(first != sentinel){
            System.out.println(first + " ");
            first = first.next;
        }
    }

    @Override
    public T removeFirst(){
        if (isEmpty()) {
            return null;
        }
        DequeNode first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return first.item;
    }

    //public T removeLast(){
    //    if (isEmpty()) {
    //        return null;
    //    }
    //    DequeNode first = sentinel.next;
    //    while(first !==sentinel){
    //        first=sentinel.next.next;
    //    }
    //    first.prev.next=sentinel;
    //    size -=1;
    //    return first.item;
    //}

    @Override
    public T removeLast(){
        if (isEmpty()) {
            return null;
        }
        DequeNode last = sentinel.prev;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.prev.next=sentinel;
        size -=1;
        return last.item;
    }

    @Override
    public T get(int index){
        if(index>=size){
            return null;
        }
        DequeNode node = sentinel.next;
        while(index>0){
            node = node.next;
            index-=1;
        }
        return node.item;
    }

    public LinkedListDeque(){
        sentinel =  new DequeNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public T getRecursive(int index){
        if (index > size){
            return null;
        }
        return getRecursive(index-1,sentinel.next)
    }

    private class DequeNode{
        private T item;
        private DequeNode prev;
        private DequeNode next;

        private DequeNode(T i, DequeNode p, DequeNode n) {
            item = i;
            prev = p;
            next = n;
        }

    }

}

