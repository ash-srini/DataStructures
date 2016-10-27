package Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by aishwaryasrinivasan on 24/09/16.
 */
public class Graph {

    /* Directed graph implementation using adjacency list */

    int vertices;
    //Array of linked list
    LinkedList<Integer> adjList[];

    public Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }


    public void addDirectedEdge(int v, int w) {
        adjList[v].add(w);
    }

    /*  Traverse breadth first from vertex v using loop*/
    public void breadthFirstTraversal(int v, boolean[] visited) {
        //Queue for storing the vertices in the order we need to traverse
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //mark given vertex as visited
        visited[v] = true;

        //add it to the queue
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            //print the mode from the top of the queue
            System.out.print(v + " ");
            //Iterate through the adjacency list
            Iterator<Integer> i = adjList[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    //each node added to the queue is marked as visited
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }


    }

    /* Print/search all connected nodes of a graph using breadth first method
    * This will not print disconnected nodes of the graph*/
    public void breadthFirstTraversal(int v) {

        //array to store the vertices visited
        boolean[] visited = new boolean[vertices];
        breadthFirstTraversal(v, visited);
    }

    /* Print/search all nodes of disconnected graph using breadth first method */
    public void BFS(int v){
        boolean[] visited = new boolean[vertices];
        for(int i=0; i< vertices; i++){
            if(visited[i] == false)
              breadthFirstTraversal(i, visited);
        }
    }

    /*  Traverse depth first from vertex v using recursion.
    * Complexity is O(V+E) where V is the number of vertices and E is the number of edges*/
    public void depthFirstTraversal(int v){
        boolean[] visited = new boolean[vertices];
        depthFirstTraversal(v, visited);

    }

    /* DFS traversal to print/search all nodes of a disconnected graphs */
    public void DFS(int v){
        boolean[] visited = new boolean[vertices];
        for(int i=0; i< vertices; i++){
            if(visited[i] == false)
                depthFirstTraversal(i, visited);
        }
    }

    public void depthFirstTraversal(int v, boolean[] visited){

        if(!visited[v]){
            System.out.print(v + " ");
            visited[v] = true;
            Iterator<Integer> i = adjList[v].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n])
                    depthFirstTraversal(n, visited);
            }
        }

    }

    /* Detecting cycle in a directed graph can be done using DFS*/
    public boolean isCyclic(){
        boolean[] visited = new boolean[vertices];
        return isCyclic(0, visited);

    }

    public boolean isCyclic(int v, boolean[] visited){
        if(!visited[v]){
            visited[v] = true;
            Iterator<Integer> i = adjList[v].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(visited[n])
                    return true;
                else isCyclic(n, visited);
            }
        }
        return false;
    }

    /* Topological sorting */

    /* Print all paths from source to destination */
    public void printPaths(int u, int v){
        boolean[] visited =  new boolean[vertices];
        int[] path = new int[vertices];
        int pathIndex = 0;
        printAllPaths(u,v,visited,path, pathIndex);

    }

    public void printAllPaths(int u, int v, boolean[] visited, int[] path, int pathIndex){
        visited[u] = true;
        path[pathIndex] = u;
        pathIndex++;

        if(u == v){
            for (int i=0; i<pathIndex; i++){
                System.out.print(path[i]+ " ");

            }
        }else{
            Iterator<Integer> iterator = adjList[u].listIterator();
            while(iterator.hasNext()){
                int visitIndex = iterator.next();
                if(!visited[visitIndex])
                    printAllPaths(visitIndex, v, visited, path, pathIndex);
            }
        }
        System.out.println();
        pathIndex--;
        visited[u] = false;
    }


    /* Following are the applications of BFS */

    /* Following are the applications of DFS */

    public static void main(String[] args)
    {
        Graph graph = new Graph(7);

        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(2, 0);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 3);

        graph.addDirectedEdge(4,5);
        graph.addDirectedEdge(4,6);
        graph.addDirectedEdge(5,6);

        graph.breadthFirstTraversal(2);
        System.out.println();
        graph.depthFirstTraversal(2);
        System.out.println();
        graph.BFS(2);
        System.out.println();
        graph.DFS(2);
        System.out.println();
        System.out.println("Is graph cyclic? " + graph.isCyclic());

        Graph g = new Graph(6);
        g.addDirectedEdge(0,1);
        g.addDirectedEdge(0,2);
        g.addDirectedEdge(0,3);
        g.addDirectedEdge(3,4);
        g.addDirectedEdge(2,5);
        System.out.println("Is graph cyclic? " + g.isCyclic());

        Graph dag = new Graph(4);

        dag.addDirectedEdge(0,1);
        dag.addDirectedEdge(0,2);
        dag.addDirectedEdge(0,3);
        dag.addDirectedEdge(1,3);
        dag.addDirectedEdge(2,0);
        dag.addDirectedEdge(2,1);

        System.out.println("Is dag graph cyclic? " +dag.isCyclic());
        dag.printPaths(2,3);
    }

}
