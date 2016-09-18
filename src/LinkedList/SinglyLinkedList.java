package LinkedList;

/**
 * Created by Aishwarya on 9/5/2016.
 */
public class SinglyLinkedList {

    Node head;
    int size;

    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }

    public class Node
    {
        int data;
        Node next;

    }

    public void insertInFront(int data){
        if (size == 0)
        {
            //insert first element
            head = new Node();
            head.data = data;
            size++;
        }
        else
        {
            Node oldNode = head;
            head = new Node();
            head.data = data;
            head.next = oldNode;
            size++;
        }
    }

    public void insertInBack(int data)
    {
        if(size == 0)
        {
            head = new Node();
            head.data = data;
            size++;
        }
        else
        {
            Node oldNode = head;
            //get last node in list
            while(oldNode.next != null)
            {
                oldNode = oldNode.next;
            }
            Node newNode = new Node();
            newNode.data = data;
            size++;
            oldNode.next = newNode;
        }
    }

    public void insertAtIndex(int index, int data)
    {
        if(index == 1)
        {
            this.insertInFront(data);
        }else if(index == 0 || index > size)
        {
            System.out.println("Invalid index");
        }
        else
        {
            Node node = head;
            int i=1;
            Node nodeBeforeIndex = null;
            while (i < index) {
                if (node != null)
                {
                    //node before index
                    nodeBeforeIndex = node;
                    node = node.next;
                    i++;
                }
            }
            //node is element at current index
            Node newNode = new Node();
            nodeBeforeIndex.next = newNode;
            newNode.data = data;
            size++;
            newNode.next = node;
        }
    }



    public void printLinkedlist() {
        Node node = head;
        if (size == 0) {
            System.out.println("Empty list");
        } else if (size == 1) {
            System.out.println(node.data);
        } else {
            while (node != null) {
                System.out.print(" " + node.data);
                node = node.next;
            }
        }
    }
    //same with delete

    public void deleteFromFront()
    {
        head = head.next;
    }

    public void deleteFromBack()
    {
        Node node = head;
        while(node.next.next != null)
        {
            node = node.next;
        }
        node.next = null;
        size--;

    }

    public void deleteFromMiddle(int index)
    {
        if(index == 1)
        {
            this.deleteFromFront();
        }
        else if (index == size)
        {
            this.deleteFromBack();
        }
        else if(index == 0 || index > size)
        {
            System.out.println("Invalid index");
        }
        else
        {
            Node node = head;
            int i=1;
            Node nodeBeforeIndex = null;
            while (i < index) {
                if (node != null)
                {
                    //node before index
                    nodeBeforeIndex = node;
                    node = node.next;
                    i++;
                }
            }

            nodeBeforeIndex.next = nodeBeforeIndex.next.next;
            size--;
        }

    }

    //Swap nodes in linked list without swapping data

    public void swapNodes(int x, int y){
        //search x and y in list
        Node xSwapPrev = null;
        Node ySwapPrev =  null;

        if(head.data == x){
            xSwapPrev = head;
        }else if(head.data == y)
        {
            ySwapPrev = head;
        }
        if(xSwapPrev == null || ySwapPrev == null)
        {
            Node node = head;
            while(node.next != null)
            {
                if(node.next.data == x)
                {
                    xSwapPrev = node;
                }
                if(node.next.data == y)
                {
                    ySwapPrev = node;
                }
                node = node.next;
            }

            if(xSwapPrev == null || ySwapPrev == null)
            {
                System.out.println("Data not present in list");
            }
            else
            {

                Node xtemp = xSwapPrev;
                Node ytemp = ySwapPrev;

                xSwapPrev.next = ySwapPrev.next;
                ySwapPrev.next = xSwapPrev.next;

                xSwapPrev.next.next = xtemp.next.next;
                ySwapPrev.next.next = ytemp.next.next;

            }
        }



    }

    public static void main(String[] args)
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertInFront(5);
        list.insertInFront(4);
        list.insertInBack(6);
        list.insertAtIndex(2,7);
        list.insertInFront(3);
        list.printLinkedlist();
//        list.deleteFromBack();
//        list.deleteFromFront();
//        list.deleteFromMiddle(1);
//        list.printLinkedlist();
        list.swapNodes(4,5);
        list.printLinkedlist();
    }
}
