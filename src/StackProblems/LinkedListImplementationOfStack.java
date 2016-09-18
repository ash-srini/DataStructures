package StackProblems;

/**
 * Created by Aishwarya on 8/23/2016.
 */
public class LinkedListImplementationOfStack <Item> implements Stack<Item>
{

    private Node head;
    private int size;

    private class Node
    {
        Node next;
        Item item;
    }

    public LinkedListImplementationOfStack()
    {
        head = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }
    public int size()
    {
        return size;
    }

    public Item pop()
    {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }
    public void push(Item item)
    {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;

    }

    public static void main(String[] args)
    {
        Stack<Integer> newStack = new LinkedListImplementationOfStack<Integer>();
        System.out.println(newStack.isEmpty());
        newStack.push(5);
        newStack.push(10);
        System.out.println(newStack.size());
        System.out.println(newStack.pop());
        System.out.println(newStack.isEmpty());
    }


}


