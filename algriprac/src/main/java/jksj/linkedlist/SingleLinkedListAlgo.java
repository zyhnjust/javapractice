package jksj.linkedlist;

public class SingleLinkedListAlgo {


    public static SNode reverse(SNode list){
        SNode curr = list, pre= null;
        while(curr!=null){
            SNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

    public static void printAll(SNode head) {
        SNode node = head;
        while(node != null){
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.print("...");
    }

    public static class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode() {
            this.next = null;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }


    public static boolean checkCircle(SNode list){
        if (list == null) return false;
        SNode fast = list.next.next;
        SNode slow = list.next;

//         如果fast 为空， slow 不是空， false；  如果fast 不为空， fastnext 为空， false
        // 这里面必然有个算法道理在这里。 如果有环， 那就意味着两个都在换上。 那么一个快一个慢， 一定有机会相遇。 如果永远不想与呢。 一
        // 空间复杂是1， 如果空间复杂度可以多， 那么就直接存即可。 check 是否相同。

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }

    // 有序链表合并  from Homer
    public static SNode mergeSortedLists(SNode la, SNode lb) {

        if(la == null) return lb;
        if(lb == null) return la;

        SNode head;
        if((Integer)la.element > (Integer)lb.element){
            head = la;
            la = la.next;
        }else{
            head = lb;
            lb =lb.next;
        }

        SNode s = head;
        while(la != null && lb != null){
            if((Integer)la.element > (Integer)lb.element){
                s.setNext(la);
                s= la;
                la = la.next;
            }else {
                s.setNext(lb);
                s= lb;
                lb = lb.next;
            }
        }
        if(la == null){
            s.setNext(lb);
        }else{
            s.setNext(la);
        }
        return head;
    }

    // 有序链表合并
    // 有两点不同， 一个是先用p q 替代了la lb， 第二个呢 r=r.next 这个放在后面了而没有放在里面， 里面有重复。
    // 基本讨论一样的， 首先判断空， 然后选头， 然后选中间。 最后哪个还有就放后面。
//    public static Node mergeSortedLists(Node la, Node lb) {
//        if (la == null) return lb;
//        if (lb == null) return la;
//
//        Node p = la;
//        Node q = lb;
//        Node head;
//        if (p.data < q.data) {
//            head = p;
//            p = p.next;
//        } else {
//            head = q;
//            q = q.next;
//        }
//        Node r = head;
//
//        while (p != null && q != null) {
//            if (p.data < q.data) {
//                r.next = p;
//                p = p.next;
//            } else {
//                r.next = q;
//                q = q.next;
//            }
//            r = r.next;
//        }
//
//        if (p != null) {
//            r.next = p;
//        } else {
//            r.next = q;
//        }
//
//        return head;
//    }

    public static SNode h1_deleteLastKth(SNode list, int k) {

        if (list == null)
            return list;
        SNode s1 = list;
        SNode s2 = list;

        for(int i=0; i< k; i++){
            if (s1 == null){
                return list;
            }
            s1=s1.next;
        }
        while(s1.next !=null){
            s1=s1.next;
            s2=s2.next;
        }

//        SNode next = s2.next;
//        s2.next= next.next;
//        delete(s2);

        return list;
    }

    public static SNode h2_deleteLastKth(SNode list, int k) {

        SNode fast = list;
        int i=1;
        while(fast !=null && i< k){
            fast = fast.next;
            i++;
        }
        if (fast == null) return list;
        SNode slow = list;
        SNode prev = null;
        while(fast.next != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null){
            list = list.next;
        }else{
            prev.next = prev.next.next;
        }
        return list;

    }

    public static SNode getMiddleNode(SNode list){
        if(list == null) return null;

        SNode fast = list;
        SNode slow = list;
        while(fast.next!= null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

        public static void main(String[] args){
//        SNode s1= new SNode(1);
//        SNode s2= new SNode(2, s1);
//        SNode s3= new SNode(3, s2);
//        printAll(s3);
//        s3 = reverse(s3);
//        printAll(s3);
//
//        System.out.println(checkCircle(s3));
//
//        SNode s4= new SNode(3, s3);
//        s1.setNext(s4);
//        System.out.println(checkCircle(s3));

            //merge
//            SNode a1= new SNode(1);
//            SNode a2= new SNode(3, a1);
//            SNode a3= new SNode(5, a2);
//            SNode b1= new SNode(2);
//            SNode b2= new SNode(4, b1);
//            SNode b3= new SNode(6, b2);
//            printAll(a3);
//            printAll(b3);
//            printAll(mergeSortedLists(a3, b3));


            SNode a1= new SNode(1);
            SNode a2= new SNode(3, a1);
            SNode a3= new SNode(5, a2);
            SNode a4= new SNode(7, a3);
            SNode a5= new SNode(9, a4);
            SNode a6= new SNode(11, a5);
            printAll(a6);

            System.out.println(getMiddleNode(a6).getElement());
            a6 = h2_deleteLastKth(a6, 6);
            printAll(a6);

        }
}
