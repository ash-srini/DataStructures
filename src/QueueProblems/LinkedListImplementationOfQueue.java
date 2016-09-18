package QueueProblems;

/**
 * Created by Lakshmy on 8/30/2016.
 */
public class LinkedListImplementationOfQueue<Item> implements Queue<Item>
{

    Node head;
    Node tail;
    int size;

    public class Node
    {
        Node next;
        Node prev;
        Item item;
    }

    LinkedListImplementationOfQueue()
    {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public int size()
    {
        return size;
    }

    public Item delete()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
        }
        else {
            if(size == 1)
                tail = head;
            Node nodeToBeDeleted = tail;
            tail = tail.prev;
            size--;
            return nodeToBeDeleted.item;
        }
        return null;
    }

    public void insert(Item item)
    {
        if (size == 0)
        {
            Node newNode = new Node();
            head = tail = newNode;
            head.item = item;
            size++;
        }
        else if (size == 1)
        {
            Node prevHead = head;
            head = new Node();
            head.next = prevHead;
            head.item = item;
            head.next = tail;
            tail.prev = head;
            size++;
        }
        else
        {
            //Node newNode = new Node();
            Node prevNode = head;
            head = new Node();
            head.item = item;
            head.next = prevNode;
            size++;
        }
    }

    public static void main(String[] args)
    {
        LinkedListImplementationOfQueue<String> queue = new LinkedListImplementationOfQueue<String>();
        System.out.println("Size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());
        queue.insert("First");
        queue.insert("Second");
        System.out.println("Size: "+ queue.size());
        queue.insert("third");
        System.out.println("Size: "+ queue.size());
        System.out.println("Deleting last element: " + queue.delete());
        System.out.println("Size: "+ queue.size());
        System.out.println("Deleting last element: " + queue.delete());
        System.out.println("Size: "+ queue.size());
        System.out.println("Deleting last element: " + queue.delete());
        System.out.println("Size: "+ queue.size());
    }

}
