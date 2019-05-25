package company.paypay.queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> q = ImmutableQueue.getInstance();
        try {
            q = q.enQueue(1);
            System.out.println(q.toString());
            System.out.println("------");
            q = q.enQueue(2);
            System.out.println(q.toString());
            System.out.println("------");
            q = q.enQueue(3);
            System.out.println(q.toString());
            System.out.println("------");
            q = q.deQueue();
            System.out.println(q.toString());
            System.out.println("------");
            q = q.deQueue();
            System.out.println(q.toString());
            System.out.println("------");
            q = q.enQueue(4);
            System.out.println(q.toString());
            System.out.println("------");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getStackTrace());
        }
    }
}
