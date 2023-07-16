public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int capacity;
    private int index;
    private int nextFirst = 0;
    private int nextLast = 0;
    private int RESIZE_FACTOR = 2;

    public ArrayDeque(){
        this(capacity:8);
    }
    public ArrayDeque(int capacity){
        items = (T[])new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    @Override
    public void addFirst(T item){
        if (isFull()){
            expandArray(RESIZE_FACTOR);
        }
        items[nextFirst] = item;
        size +=1;
        nextFirst =indexAdd(nextFirst,-1);
    }

    @Override
    public void addLast(T item){
        items[nextLast-1]=item;
        nextLast =indexAdd(nextLast,1);
        size +=1;
    }

    @Override
    public boolean isEmpty(){
        return(size == 0);
    }

    private void resize(int capacity){
        T[] a = (T[])new Object[capacity];
        System.arraycopy(items,0,a,0,size)
        items = a;
    }



    @Override
    public T removeFirst(){
        T[] a = (T[])new Object[capacity];
    }

    @Override
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T last = items[nextLast];

    }

    @Override
    public T get(int index){
        if (index >=size){
            return null;
        }else{
            return items[indexAdd(nextFirst,1+index)];
        }
    }

    private boolean isFull() {
        return (size ==capacity);
    }

    private void expandArray(int factor){
        reshapeItems(capacity*factor);
        capacity *= factor;
    }

    private void shrinkArray(){
        reshapeItems(capacity/2);
        capacity /=2;
    }


    private void reshapeItems(int newCapacity){
        T[] newItems = (T[])new Object[newCapacity];
        for (int i = 0;i<size;i++){
            newItems[i] = items[indexAdd(nextFirst, 1 +i)];
        }
        items = newItems;
        nextFirst = 0;
        nextLast = size;
    }

    private int indexAdd(int index, int num){
        index += num;
        if(index<0){
            index+=capacity;
        }
        if{index>=capacity){
            index-=capacity;
        }
        return index;
    }



}
