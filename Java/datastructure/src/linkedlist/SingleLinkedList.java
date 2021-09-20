package linkedlist;

public class SingleLinkedList<T> {

    public Node<T> head = null;

    public static class Node<T> {

        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        //리스트의 헤드(노드)가 없으면 새로운 헤드노드 생성(물론 데이터, 넥스트가 존재)
        if (head == null) {
            head = new Node<T>(data);
        } else { //헤드가 존재한다면(노드가 최소 한개 이상)
            Node<T> node = this.head; //노드(마지막노드) = 헤드노드로 설정
            while (node.next != null) { //노드(마지막노드)의 다음노드가 있다면(최소 두개이상) 노드(마지막노드)를 노드.next로 이동
                node = node.next;
            }
            node.next = new Node<T>(data); //위 분기처리에서 node.next는 null이기 때문에 새롭게 들어온 노드는 노드(마지막노드)의 next에 추가된다.
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = search(isData);
        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<>(data);
            searchedNode.next.next = nextNode;
        }
    }


}
