package StackProblems;
import java.util.LinkedList;

/**
 * WIP
 */

/**
 * Created by Lakshmy on 8/31/2016.
 */
public class SetOfStacks<Item> implements Stack<Item>
{
    int capacity;
    int size;
    private LinkedList<SetOfStacks<Integer>> stacks = new LinkedList<SetOfStacks<Integer>>();
    Integer[] stackArray;

    public SetOfStacks(int cap){
        this.capacity = cap;
        size = 0;
        stackArray = new Integer[cap];
    }

    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }

    @Override
    public int size()
    {
        return size;
    }

//    public int sizeOfSetOfStack()
//    {
//
//    }

    @Override
    public Item pop()
    {
        if(this.isEmpty())
        {
           SetOfStacks currentStack = stacks.peekFirst();
           //currentStack;

        }
        else{

        }
        return null;
    }

    @Override
    public void push(Item item) {
        if(this.isEmpty() || this.size() == capacity)
        {
            SetOfStacks<Integer> myStack = new SetOfStacks<Integer>(3);
            stackArray[size] = (Integer)item;
            stacks.add(myStack);
            size++;
        }
        else
        {
            stackArray[size] = (Integer)item;
            size++;
            if(size == capacity)
            {
                size = 0;
            }

        }
    }


    public static void main(String[] args)
    {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        System.out.println(setOfStacks.size());
    }
}
