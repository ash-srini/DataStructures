/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
package HackerRank;
import java.util.*;
import java.util.LinkedList;

class Node{
    int data;
    Node left,right;

    public Node(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}


class TestClass {

    Node root;


    public TestClass(){
        this.root = null;
    }



    public static void preOrderTraversal(Node node){
        if(node == null)
            return;

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */

        Scanner sc = new Scanner(System.in);
        int numOfTests = Integer.parseInt(sc.nextLine());

        for (int i=0; i<numOfTests; i++) {
            int numOfLines = Integer.parseInt(sc.nextLine());
            TestClass sillyTree = new TestClass();
            Queue<Node> queue = new LinkedList<Node>();

            for (int j = 0; j < numOfLines; j++){
                String[] lineNums = sc.nextLine().split(" ");
                if(sillyTree.root == null){
                    sillyTree.root = new Node(Integer.parseInt(lineNums[0]));
                    queue.add(sillyTree.root);
                }
                if(!queue.isEmpty() && lineNums.length == 3) {
                    Node tempNode = queue.poll();
                    int root = Integer.parseInt(lineNums[0]);
                    if (root == tempNode.data) {
                        int left = Integer.parseInt(lineNums[1]);
                        if (left != 0) {
                            tempNode.left = new Node(left);
                            queue.add(tempNode.left);
                        }
                        int right = Integer.parseInt(lineNums[2]);
                        if (right != 0) {
                            tempNode.right = new Node(right);
                            queue.add(tempNode.right);
                        }
                    }
                    else{
                        tempNode = queue.poll();
                        int left = Integer.parseInt(lineNums[1]);
                        if (left != 0) {
                            tempNode.left = new Node(left);
                            queue.add(tempNode.left);
                        }
                        int right = Integer.parseInt(lineNums[2]);
                        if (right != 0) {
                            tempNode.right = new Node(right);
                            queue.add(tempNode.right);
                        }

                    }
                }
            }
            if(sillyTree.root!=null)
                preOrderTraversal(sillyTree.root);
            System.out.println();

        }



    }

}
