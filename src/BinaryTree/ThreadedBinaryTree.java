package BinaryTree;

/**
 * Created by aishwaryasrinivasan on 20/09/16.
 */
public class ThreadedBinaryTree extends BinaryTree{

    /* Convert a given tree to a singly threaded binary tree*/
    public void convertToSinglyThreaded(Node node, Node prev)
    {
        if(node == null)
            return;
        else
        {
            convertToSinglyThreaded(node.right, prev);
            if(node.right==null &&  prev!=null)
            {
                node.right = prev;
            }
            convertToSinglyThreaded(node.left, node);
        }

    }

    /* More threaded problems to come */

    public static void main(String[] args)
    {
        ThreadedBinaryTree btree = new ThreadedBinaryTree();
        btree.root = new Node(1);

        btree.root.left = new Node(2);
        btree.root.right = new Node(3);

        btree.root.left.left = new Node(4);
        btree.root.left.right = new Node(5);

        btree.root.right.left = new Node(6);
        btree.root.right.right = new Node(7);

        /* Given tree structure is as below
                      1
    				/   \
    			   2	 3
    			  / \   / \
    			 4   5 6   7
         */

        /*Convert given tree into singly threaded Binary tree.
         In a Singly threaded Binary Tree, the nodes with right child as null should have
         their right pointer point to the next node in its inorder traversal.
         */
        btree.convertToSinglyThreaded(btree.root, null);
        System.out.println(btree.root);
        btree.convertToDoublyThreaded(btree.root, null, null);
        System.out.println(btree.root);

    }
}
