package BinaryTree;
import java.util.*;
/**
 * Created by aishwaryasrinivasan on 21/09/16.
 */
public class BinarySearchTree extends BinaryTree
{

    /* Inserting into BST
    * Search from root to leaf node.
    * If key to be inserted is less that root, traverse left sub-tree
    * else traverse right sub-tree.
    * Once leaf is found, insert the node as left or right child
    * depending on if the key of the new node is greater or less than the leaf's key*/

    public Node insertIntoBST(Node node, int key)
    {
        if(node == null || node.key == key)
        {
            return new Node(key);
        }
        else if(node.key > key)
           node.left = insertIntoBST(node.left, key);
        else
            node.right = insertIntoBST(node.right, key);

        return node;
    }

    /* Searching for a key in a BST
    * compare key to key of root. Return root if they match.
    * Otherwise, check if key is less than key of node, Traverse
    * left sub-tree. Else, traverse the right subtree.
    * return true if key is found within the bst, else return false.
     */

    public boolean searchBST(int key)
    {
            return searchBST(this.root, key);
    }

    public boolean searchBST(Node node, int key)
    {
        if(node== null)
            return false;
        else if(node.key == key)
            return true;

            if(key < node.key)
                return searchBST(node.left, key);
            else
               return searchBST(node.right, key);
    }

    public void insertIntoBST(int key)
    {
        if(this.root == null)
            this.root = new Node(key);
        insertIntoBST(this.root, key);
    }

    /* Deleting Node from BST
    * If the node is a leaf node, simply delete the node
    * If the node has only one child, copy the child into node and delete child
    * If the Node has two children, copy the inorder successor or predecessor and delete the*/
    public Node deleteFromBST(Node node, int key)
    {
        if (node == null)
            return node;

        if(key < node.key)
        {
            node.left = deleteFromBST(node.left, key);
        }
        else if(key > node.key)
        {
            node.right = deleteFromBST(node.right, key);
        }
        else
        {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            /* get the minimum value in the right sub-tree
            * replace the key with the min value*/
            node.key = minValue(node.right);
            /* delete the node which had the minimum value */
            node.right = deleteFromBST(node.right, node.key);
        }
        return node;
    }

    /* get min value from sub-tree
    * in case of a BST it is the left node if the left node is not null*/
    public int minValue(Node node)
    {
        int minv = node.key;
        while (node.left != null)
        {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }

    public void deleteFromBST(int key)
    {
        deleteFromBST(this.root, key);
    }

    /* Check if given tree is a BST
    * tree is bst if the nodes of the left sub-tree have keys smaller then the root
    * and that of the right sub-tree are greater than the root for each sub-tree. */
    public boolean isBST(Node node){

        /* The key of each successor node of the inorder traversal should be
         * greater than the key of its predecessor */
       // return isBST(node, 0, 0);
        ArrayList<Integer> al = new ArrayList<>();
      return isBST(node, 0, al);
    }

    /*max is the max alue in the left sub-tree na dmin is the min value in the right sub-tree
    * The min value should be greater than the max value*/
    public boolean isBST(Node node, int index, ArrayList<Integer> al)
    {
        if(node == null )
            return true;

        isBST(node.left, index, al);

        al.add(node.key);
        index+=index;

        isBST(node.right, index, al);

        if( index > 0 && al.get(index) < al.get(index-1))
            return false;
        else
            return true;

    }

    public static int prev = Integer.MIN_VALUE;

    /* Check if the given binary tree is a binary search tree */
    public boolean checkBST(Node node)
    {
        if(node == null)
            return true;

        if(!checkBST(node.left))
            return false;

        if(node.key <= prev)
            return false;

        prev = node.key;

        if(!checkBST(node.right))
            return false;

        return true;
    }


    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertIntoBST(50);
        bst.insertIntoBST(30);
        bst.insertIntoBST(20);
        bst.insertIntoBST(40);
        bst.insertIntoBST(70);
        bst.insertIntoBST(60);
        bst.insertIntoBST(80);

//        bst.printInorder(bst.root);
//        System.out.println();
//
//        int key = 60;
//        System.out.println("Is key " + key + " present? " + bst.searchBST(key));
//
//        key = 25;
//        System.out.println("Is key " + key + " present? " + bst.searchBST(key));
//
//        bst.deleteFromBST(20);
//        bst.printInorder(bst.root);
//
//        bst.deleteFromBST(50);

        bst.isBST(bst.root);
    }


}
