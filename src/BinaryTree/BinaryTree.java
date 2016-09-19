package BinaryTree;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aishwaryasrinivasan on 18/09/16.
 */

class Node
{
    int key;
    Node left, right;

    public Node(int data)
    {
        key = data;
        left=right=null;
    }
}

public class BinaryTree
{
    static Node root;

    public BinaryTree()
    {
        root=null;
    }

    //inorder traversal - left -> root -> right
    public static void printInorder(Node node)
    {
        if(node == null)
            return;

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    //preorder traversal - root -> left -> right
    public static void printPreorder(Node node)
    {
        if (node == null)
            return;

        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    //post order traversal - left -> right -> root
    public static void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPreorder(node.left);
        printPreorder(node.right);
        System.out.print(node.key + " ");
    }

    //size of tree
    public static int size(Node node)
    {
        if (node == null)
            return 0;

        return (size(node.left)+ size(node.right)+1);
    }

    //height of tree
    public static int height(Node node)
    {
        if(node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight,rheight)+1;

    }
    /* level order traversal using recursion and printing given level first
    * worst case complexity is O(n^2) */
    public static void printLevelOrder()
    {
        for(int i=1; i<height(root); i++)
        {
            printGivenLevel(root, i);

        }
    }

    //print given level
    public static void printGivenLevel(Node node, int level)
    {
        if(node == null)
            return;
        if(level == 1)
            System.out.print(node.key + " ");
        else if(level >1)
        {
            printGivenLevel(node.left, level--);
            printGivenLevel(node.right, level--);
        }
    }

    /* level order traversal using queues
    * complexity is O(n)*/
    public static void bradthFirstTraversal()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }

    }

    /* check if two trees are identical */

    /* check if binary tree is balanced*/

    /* conrtruct tree when inprder and post order is given*/

    /* check if tree is a subtree of another binary tree */

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);

        printInorder(tree.root);
        System.out.println();
        printPreorder(tree.root);
        System.out.println();
        printPostorder(tree.root);
        System.out.println();
        System.out.println(size(tree.root));
        System.out.println(height(tree.root));


    }
}
