package finaltesting;
import java.util.LinkedList;
public class Graph {
	static class Graphs
	{
		int V;
		LinkedList <Integer> adjList[];
		Graphs(int V)
		{
			this.V=V;
			adjList=new LinkedList[V];
			for(int i=0;i<V;i++)
			{
				adjList[i]=new LinkedList<>();
			}
		}
	}
	
	static void addEdge(Graphs g,int src,int dest)
	{
		g.adjList[src].add(dest);
		g.adjList[dest].add(src);
		
	}
	
	static void print(Graphs g)
	{
		for(int v=0; v<g.V;v++)
		{
			System.out.println("Adjecent List for " + v);
			System.out.print("head");
			for(Integer p:g.adjList[v])
			{
				System.out.print(" - > " + p);
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		Graphs g = new Graphs(V);
		addEdge(g,0,1);
		addEdge(g,0,4);
		addEdge(g,1,4);
		addEdge(g,1,3);
		addEdge(g,1,2);
		addEdge(g,2,3);
		addEdge(g,3,4);
		
		print(g);
		
	}
}
