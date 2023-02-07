import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class Graph {
    int u,v;
    ArrayList<ArrayList<Integer>> vertices;
    public Graph(int u, int v){
        this.u = u;
        this.v = v;
        this.vertices = new ArrayList<ArrayList<Integer>>(u);
        for(int i=0; i < u; i++){
            this.vertices.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v){
        this.vertices.get(u).add(v);
        if(!this.vertices.get(v).contains(u)){
            this.vertices.get(v).add(u);
        }
    }

    public int degreeVertex(int a){
        return this.vertices.get(a).size();
    }

    public void printAdjVertices(int a){
        System.out.println("Edges adjacent to vertex "+a+":");
        ArrayList temp = this.vertices.get(a);
        for(int i=0; i < temp.size(); i++){
            System.out.println(""+temp.get(i));
        }
    }

    public void BFS(int vertex){
        System.out.println("Breadth first search starting from vertex "+vertex);
        int i, currentVertexCounterInTempList;
        int cv = vertex;
        boolean cont = true;
        ArrayList tempList = new ArrayList<Integer>(this.vertices.size());
        ArrayList queueList = new ArrayList<Integer>(this.vertices.size());
        for(i=0; i<this.vertices.size(); i++){
            queueList.add(i);
        }
        i=0;
        currentVertexCounterInTempList = 0;
        queueList.set(vertex, Integer.valueOf(-1));
        tempList.add(cv);
        while(cont){
            //for loop to test if all there are still nodes in our queue
            for (int j=0; j< queueList.size(); j++) {
                if(!queueList.get(j).equals(Integer.valueOf(-1))){
                    cont = true;
                    break;
                }
                else{
                    cont = false;
                }
            }
            //end
            for(int k=0; k<this.vertices.get(cv).size(); k++){
                if(!tempList.contains(Integer.valueOf(this.vertices.get(cv).get(k)))){
                    tempList.add(this.vertices.get(cv).get(k));
                    queueList.set(queueList.indexOf(Integer.valueOf(this.vertices.get(cv).get(k))),-1);
                }

            }
            currentVertexCounterInTempList++;
            cv = (int) tempList.get(currentVertexCounterInTempList);
        }
        for(int l=0; l<tempList.size(); l++){
            System.out.print(" "+tempList.get(l));
        }

    }


    public void DFS(int vertex){

    }

    public static void main(String[] args) {
        int a, b, c, d;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges:");
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println("a = "+b+", b="+b);
        Graph myGraph = new Graph(a, b);
        for(int i=0; i<b;i++){
            c = scanner.nextInt();
            d = scanner.nextInt();
            myGraph.addEdge(c,d);
        }
        myGraph.BFS(0);
//        for(int j=0; j < a; j++){
//            System.out.println("degree of vertex "+j+":"+myGraph.degreeVertex(j));
//            myGraph.printAdjVertices(j);
//        }
    }
}
