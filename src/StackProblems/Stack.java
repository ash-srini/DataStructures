/**
 * Created by Aishwarya on 8/29/2016.
 */
package StackProblems;

public interface Stack <Item>
{
    Item pop();
    void push(Item item);
    boolean isEmpty();
    int size();
}

