package StackProblems;

/**
 * Created by Lakshmy on 8/23/2016.
 */
public class ArrayImplementationOfStack {

    //class to create a stack
    static class Stack {
        int top;
        int[] stackArray;
        int maxsize;

        public Stack(int capacity){
            top = 0;
            maxsize = capacity;
            stackArray = new int[maxsize];
        }

        //push operation
        public void push(int num) {
            stackArray[top++] = num;
        }

        //peek operation
        public int peak(){
            //int i;
            return stackArray[top-1];
        }

        //pop operation
        public int pop(){
            return stackArray[--top];
        }

        public boolean isEmpty(){
            return top == 0;
        }
        public boolean isFull(){
            return top == maxsize - 1;
        }
    }

    //main method to create and perform stack operations
    public static void main (String[] args) {
        Stack stack = new Stack(10);
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}

