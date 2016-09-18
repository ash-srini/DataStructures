package StackProblems;

/**
 * Created by Lakshmy on 8/29/2016.
 */
public class MultipleFixedSizeStackUsingArray
{

    static class Stack
    {
        int[] stackArray;
        int stackSize;
        int numberOfStacks;
        int[] stackPointer = {0,0,0};

        public Stack(int stackSize, int numberOfStacks)
        {
            stackArray = new int[stackSize*numberOfStacks];
            this.stackSize = stackSize;


        }

        public void push(int stacknum, int num)
        {
            int position = (((stacknum-1)*stackSize)+stackPointer[stacknum]);
            int cap = ((stacknum-1)*stackSize)+stackSize;
            if(position >= cap)
            {
                System.out.println("Stack is full");
            }
            else
            {
                stackArray[position] = num;
                stackPointer[stacknum]+=1;
                System.out.println("Inserted "+num+" in stack");
            }

        }

        public int pop(int stacknum)
        {
            /**
             * pop top from given stacknum
             * top is basically the stackPointer[stacknum]
             **/

            return 0;
        }

    }

    public static void main(String[] args)
    {
        Stack stack = new Stack(3,5);
        stack.push(2,1);
        stack.push(2,2);
        stack.push(2,3);
        stack.push(2,4);

    }

}
