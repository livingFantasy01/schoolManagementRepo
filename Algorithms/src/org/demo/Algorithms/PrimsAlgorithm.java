package org.demo.Algorithms;

import java.util.Scanner;


/*Algorithm
1) Create a set mstSet that keeps track of vertices already included in MST.
2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the first vertex so that it is picked first.
3) While mstSet doesn’t include all vertices
….a) Pick a vertex u which is not there in mstSet and has minimum key value.
….b) Include u to mstSet.s
….c) Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices. For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v



The idea of using key values is to pick the minimum weight edge from cut. The key values are used only for vertices which are not yet included in MST, the key value for these vertices indicate the minimum weight edges connecting them to the set of vertices included in MST.

*/
public class PrimsAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the graph :");
		int n = Integer.parseInt(args[0]);
		int[][] graph = new int[n][n];
		boolean[] visited = new boolean[n];
		int min;
		int total = 0;
		int u = 0;
		int v = 0;

		System.out.println("Fill the graph for " + n + "x" + n + " matrix");
		int x = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(args[x]);
				if (graph[i][j] == 0) {
					graph[i][j] = Integer.MAX_VALUE;
					
				}
				x++;
			}
		}
		visited[0] = true;
		for (int counter = 0; counter < n - 1; counter++) {
			
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				
				if (visited[i] == true) {
					
					for (int j = 0; j < n; j++) {
						if(!visited[j]) {
						if(min > graph[i][j]) {
							min = graph[i][j];
							 u = i;
							 v = j;
							 
						}
						}
					}
					
				}
				
				
			}
			
			visited[v] = true;
			total = total + min;
			System.out.println("Minimum Edge found from "+u +" -> "+v + " with weight "+graph[u][v]);
			
		}
		
		System.out.println("total wight "+total);

	}

}
