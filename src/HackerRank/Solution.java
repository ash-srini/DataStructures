package HackerRank;

/**
 * Created by aishwaryasrinivasan on 21/09/16.
 */

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
public class Solution {

    Node root;

    public Solution()
    {
        root = null;
    }

    public void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public void swapNodes(Node node, int level, int currentLevel)
    {
        if(node == null)
            return;
        if(currentLevel%level == 0)
            {
                //swap nodes here
                Node temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
                //call swapNodes function with level-1 for each left and right subtrees
                swapNodes(node.left, level, currentLevel+1);
                swapNodes(node.right, level, currentLevel+1);

    }

    public void swapNodes(Node node, int level)
    {
         swapNodes(node, level, 1);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Integer numberOfNodes = Integer.parseInt(sc.nextLine());
        Solution tree = new Solution();
        tree.root = new Node(1);
        Node node = tree.root;
        Node[] nodeArray = new Node[numberOfNodes];
        nodeArray[0] = tree.root;

        int j=0;
        for(int i=0; i<numberOfNodes; i++)
        {
            //i is the ith node of the tree and the two nodes we get from scanner are the left and right nodes of the ith node
            String nodes = sc.nextLine();
            int leftNode = Integer.parseInt(nodes.split(" ")[0]);
            if(leftNode != -1)
            {
                nodeArray[i].left = new Node(leftNode);
                nodeArray[++j] = nodeArray[i].left;
            }
            int rightNode = Integer.parseInt(nodes.split(" ")[1]);
            if (rightNode != -1) {
                nodeArray[i].right = new Node(rightNode);
                nodeArray[++j] = nodeArray[i].right;
            }

        }

    int numerOfSwaps = Integer.parseInt(sc.nextLine());
        while(numerOfSwaps > 0 )
        {
            //level at which nodes need to be swapped
            int level = sc.nextInt();
            //call swapping function
            tree.swapNodes(tree.root, level);
            tree.printInorder(tree.root);
            System.out.println();
            numerOfSwaps--;
        }



    }
}
