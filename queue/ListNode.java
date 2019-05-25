package company.paypay.queue;

public final class ListNode<T> {

    private T head;
    private ListNode<T> tail;
    private int size;


    private ListNode(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private ListNode(T head, ListNode<T> tail){
        this.head = head;
        this.tail = tail;
        this.size = tail.size + 1;
    }

    public static ListNode emptyListNode(){
        return new ListNode();
    }

    public ListNode<T> push(T obj){
        return new ListNode(obj,this);
    }

    public ListNode<T> pop() {
        return tail;
    }

    public T head() { return head; }

    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
