package Graph;

import com.sun.javafx.geom.Edge;

import java.util.Arrays;

/**
 * Created by aishwaryasrinivasan on 11/10/16.
 */
public class UndirectedGraph {

    /* Undirected graphs are graphs with edges that connect vertices with no particular vertex representing the source or destination.
     * Undirected graphs do not have self or parallel loops as the edge from vertex 'a' to 'b' is the same as edge from vertex 'b' to 'a' */

    int V, E;
    Edge[] edges;

    class Edge{
        int vertexA, vertexB;
    }


    public UndirectedGraph(int v, int e){
        V = v;
        this.E = e;
        edges =  new Edge[E];
        for(int i=0; i<E; i++){
            edges[i] = new Edge();
        }
    }

    /* This method finds the parent of the set */
    public int find(int[] parent, int i){
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    /* This method is to union two subsets */
    public void unionSet(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    /* Detecting cycle in a undirected graph using union find algorithm
       * Complexity of this method is O(log n) */
    public int isCyclic(){
        int[] parent = new int[V];
        //initialize parent array to -1 since we haven't found the parent of any subset
        // Also -1 because we no vertex will have the value -1
        Arrays.fill(parent, -1);

        for(int i=0; i<E; i++){
            int x = find(parent, this.edges[i].vertexA);
            int y = find(parent, this.edges[i].vertexB);

            if(x == y)
                return 1;

            unionSet(parent , x, y);
        }
        return 0;
    }

    public static void main(String[] args){
        //3 vertices and 3 edges
        int v = 3, e = 3;
        UndirectedGraph g = new UndirectedGraph(v, e);
        //edge between 0 and 1
        g.edges[0].vertexA = 0;
        g.edges[0].vertexB = 1;
        //edge between 1 and 2
        g.edges[1].vertexA = 1;
        g.edges[1].vertexB = 2;
        //edge between 1 and 2
        g.edges[2].vertexA = 2;
        g.edges[2].vertexB = 0;
    }


}
