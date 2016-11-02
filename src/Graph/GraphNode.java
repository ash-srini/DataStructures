package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.lang.*;

/**
 * Created by aishwaryasrinivasan on 18/10/16.
 */


    class GraphNode {
        String data;
        //implement relation between nodes
        LinkedList<Graph.GraphNode> adjGraphNodes;

        public GraphNode(String data){
            this.data = data;
            adjGraphNodes = new LinkedList<Graph.GraphNode>();
        }

        public int numPaths(Graph.GraphNode destination, int maxSteps){
            int pathCount = 0;
            pathCount= numPaths(this, destination, maxSteps, pathCount);
            return pathCount;
        }

        public int numPaths(Graph.GraphNode source, Graph.GraphNode destination, int maxSteps, int pathCount){


          if(source.data == destination.data)
               return 1;
            else{
              Iterator<Graph.GraphNode> i = adjGraphNodes.listIterator();
              while(i.hasNext()){
                  if(maxSteps!=0){
                      maxSteps--;
                     pathCount+=numPaths(i.next(), destination, maxSteps, pathCount);
                  }else
                      return pathCount;
              }
          }
          return pathCount;

        }

        public static void main(String[] args){

            Graph.GraphNode A = new Graph.GraphNode("A");
            Graph.GraphNode B = new Graph.GraphNode("B");
            Graph.GraphNode C = new Graph.GraphNode("C");

            A.adjGraphNodes.add(B);
            A.adjGraphNodes.add(C);

            B.adjGraphNodes.add(A);

            C.adjGraphNodes.add(B);

            System.out.println(A.numPaths(B, 4));
            System.out.println(A.numPaths(B, 3));
            System.out.println(A.numPaths(B, 2));
            System.out.println(A.numPaths(C, 5));

        }


    }


