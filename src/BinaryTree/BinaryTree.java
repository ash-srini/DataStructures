package BinaryTree;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

public class BinaryTree  {
     Node root;

    public BinaryTree()
    {
        root=null;
    }

    //inorder traversal - left -> root -> right
    public void printInorder(Node node)
    {
        if(node == null)
            return;

        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    public void nonRecursiveInorder(Node node)
    {
        Stack<Node> stack = new Stack<Node>();
        Node current = node;
        while(current != null)
        {
            stack.push(node);
            current = current.left;
        }

        while(!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.key + " ");
            if (node.right != null)
            {
                node = node.right;
                while (node != null)
                {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

    }

    //preorder traversal - root -> left -> right
    public void printPreorder(Node node)
    {
        if (node == null)
            return;

        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    //post order traversal - left -> right -> root
    public void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
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
    public int height(Node node)
    {
        if(node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight,rheight)+1;

    }
    /* level order traversal using recursion and printing given level first
    * worst case complexity is O(n^2) */
    public void printLevelOrder()
    {
        for(int i=1; i<height(root); i++)
        {
            printGivenLevel(root, i);

        }
    }

    //print given level
    public void printGivenLevel(Node node, int level)
    {
        if(node == null)
            return;
        else if(level == 1)
            System.out.print(node.key + " ");
        else if(level >1)
        {
            printGivenLevel(node.left, level-1);
            printGivenLevel(node.right, level-1);
        }
    }

    /* level order traversal using queues
    * complexity is O(n)*/
    public void bradthFirstTraversal(Node node)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
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

    /* check if two trees are identical
    * Two trees are identical when the number of nodes and the keys of each node is the same*/
    public boolean identicalTrees(Node node1, Node node2)
    {
        if(node1 == null && node2 == null)
            return true;
        else if ((node1 != null && node2 != null))
            return ((node1.key == node2.key) && identicalTrees(node1.left, node2.left) && identicalTrees(node1.right, node2.right));
        else
            return false;
    }


    /* check if binary tree is balanced*/
    public int balanceTreeCheck(Node node)
    {
        if(node == null)
            return 0;

        int left = balanceTreeCheck(node.left);
        if (left == -1)
            return -1;

        int right = balanceTreeCheck(node.right);
        if (right == -1)
            return -1;

        if(Math.abs(left-right) > 1 )
            return -1;

        return Math.max(left,right)+1;

    }

    public boolean isTreeBalanced(Node root){
        int result = balanceTreeCheck(root);
        return (result > 0);
    }

    /* construct tree when inorder and post order is given*/
    public Node constructFromInorderAndPostorder(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd ){
        if(inorderStart > inorderEnd || postorderStart > postorderEnd)
            return null;
        int root = postorder[postorderEnd];
        Node node = new Node(root);

        if(inorderStart == inorderEnd)
            return node;

        int root_index = 0;
        for(int i=inorderStart; i<inorder.length; i++) {
            if (inorder[i] == root) {
                root_index = i;
                break;
            }

        }

        int leftSubTreeCount = root_index - inorderStart;
        int rightSubTreeCout = inorderEnd - root_index;

        node.left = constructFromInorderAndPostorder(inorder, inorderStart, inorderStart+leftSubTreeCount-1, postorder, postorderStart, postorderStart+leftSubTreeCount-1);
        node.right = constructFromInorderAndPostorder(inorder, inorderEnd-rightSubTreeCout+1, inorderEnd, postorder,  postorderEnd-rightSubTreeCout, postorderEnd-1);

        return node;

    }

    public Node constructFromInorderAndPostorder(int[] inorder, int[] postorder)
    {
        return constructFromInorderAndPostorder(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    /*construct tree from inorder and preorder traversals*/
    public Node constructFromInorderAndPreorder(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd)
    {
        if(inStart > inEnd || preStart > preEnd)
            return null;

        int root = preorder[preStart];
        int root_index = 0;

        for (int i=0; i<inorder.length; i++)
        {
            if(inorder[i] == root)
            {
                root_index = i;
                break;
            }
        }

        Node node = new Node(root);

        if(inStart == inEnd)
            return node;

        int leftSubTreeCount = root_index - inStart;
        int rightSubTreeCout = inEnd - root_index;

        node.left = constructFromInorderAndPreorder(inorder, preorder, inStart, inStart+leftSubTreeCount-1, preStart+1, preStart+leftSubTreeCount);
        node.right = constructFromInorderAndPreorder(inorder, preorder, inEnd-rightSubTreeCout+1, inEnd, preEnd-rightSubTreeCout+1, preEnd);

        return node;
    }

    public Node constructFromInorderAndPreorder(int[] inorder, int[] preorder)
    {
        return constructFromInorderAndPreorder(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }


    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);

        //print inorder
        tree.printInorder(tree.root);
        System.out.println();

        //print non-recursive inorder
        tree.nonRecursiveInorder(tree.root);

        //print preorder
        tree.printPreorder(tree.root);
        System.out.println();

        //print postorder
        tree.printPostorder(tree.root);
        System.out.println();

        //print tree size
        System.out.println("Size: " + size(tree.root));

        //print tree height
        System.out.println("Height: " + tree.height(tree.root));

        //print given level
        tree.printGivenLevel(tree.root, 2);
        System.out.println();

        //level order traversal - O(n)
        tree.bradthFirstTraversal(tree.root);
        System.out.println();

        //print if tree is balanced or not
        System.out.println("Is tree balanced? " + tree.isTreeBalanced(tree.root));

        //create a new tree
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);

        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);

        tree2.root.right.left = new Node(6);

        tree2.printInorder(tree2.root);
        System.out.println();
        tree2.printInorder(tree.root);
        System.out.println();

        //print if tree is identical or not
        System.out.println("Are the two trees indentical? " + tree.identicalTrees(tree.root, tree2.root));

        //add new node to tree2
        tree2.root.right.right = new Node(7);

        //print if tree is identical or not
        tree2.printInorder(tree2.root);
        System.out.println();
        tree2.printInorder(tree.root);
        System.out.println();
        System.out.println("Are the two trees indentical? " + tree.identicalTrees(tree.root, tree2.root));


        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] preorder = {1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        //given inorder and pre-order arrays, construct a binary tree
        BinaryTree newTree = new BinaryTree();

        newTree.root = newTree.constructFromInorderAndPreorder(inorder, preorder);
        newTree.printInorder(newTree.root);
        System.out.println();
        newTree.printPostorder(newTree.root);
        System.out.println();
        newTree.printPreorder(newTree.root);
        System.out.println();

        //given inorder and post-order, construct a binary tree
        BinaryTree buildTree = new BinaryTree();
        buildTree.root = buildTree.constructFromInorderAndPostorder(inorder, postorder);
        newTree.printInorder(newTree.root);
        System.out.println();
        newTree.printPostorder(newTree.root);
        System.out.println();
        newTree.printPreorder(newTree.root);



    }
}
