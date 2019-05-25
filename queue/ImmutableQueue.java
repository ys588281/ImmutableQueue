package company.paypay.queue;

public class ImmutableQueue<T> implements Queue<T> {

    private ListNode<T> forward;
    private ListNode<T> backward;

    private ImmutableQueue(ListNode<T> forward,ListNode<T> backward){
        this.forward = forward;
        this.backward = backward;
    }

    public static Queue getInstance() {
        return getEmptyQueue();
    }

    private static Queue getEmptyQueue(){
        return EmptyQueue.getInstance();
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(this.forward, this.backward.push(t));
    }

    @Override
    public Queue<T> deQueue() {
        ListNode f = this.forward.pop();
        if (!f.isEmpty()) {
            return new ImmutableQueue<T>(f, backward);
        } else if (backward.isEmpty()) {
            return getEmptyQueue();
        } else {
            return new ImmutableQueue<T>(reverseListNode(backward), ListNode.emptyListNode());
        }
    }

    @Override
    public boolean isEmpty(){
        return false;
    }

    @Override
    public T head() {
        return forward.head();
    }

    private ListNode reverseListNode(ListNode listNode) {
        ListNode r = ListNode.emptyListNode();
        while(!listNode.isEmpty()){
            r = r.push(listNode.head());
            listNode = listNode.pop();
        }

        return r;
    }



    private static final class EmptyQueue<T> implements Queue<T> {

        private EmptyQueue() {

        }

        public final static EmptyQueue getInstance(){
            return new EmptyQueue();
        }

        @Override
        public Queue<T> enQueue(T t) {
            return new ImmutableQueue<T>(ListNode.emptyListNode().push(t), ListNode.emptyListNode());
        }

        @Override
        public Queue<T> deQueue() {
            return null;
        }

        @Override
        public T head() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
