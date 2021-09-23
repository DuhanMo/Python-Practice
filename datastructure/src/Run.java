import linkedlist.SingleLinkedList;

public class Run {

    public static void main(String[] args) {
        System.out.println("=========Queue=========");
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.dequeue());
        }

        System.out.println("=======Stack========");
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }

        System.out.println("=====SingleLinkedList=====");
        SingleLinkedList<Integer> mySingleLinkedList = new SingleLinkedList<>();
        mySingleLinkedList.addNode(1);
        mySingleLinkedList.addNode(2);
        mySingleLinkedList.addNode(3);
        mySingleLinkedList.addNode(4);
        mySingleLinkedList.delNode(20);
        mySingleLinkedList.printAll();
    }
}
