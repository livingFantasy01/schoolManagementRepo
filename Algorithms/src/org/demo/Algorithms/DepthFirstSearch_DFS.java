package org.demo.Algorithms;

import java.util.LinkedList;
import java.util.Stack;

/*Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.*/
public class DepthFirstSearch_DFS {

	private int v;
	private LinkedList<Integer>[] adjecent;

	DepthFirstSearch_DFS(int v) {
		this.v = v;
		adjecent = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adjecent[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(DepthFirstSearch_DFS graph, int a, int b) {
		graph.adjecent[a].add(b);
		graph.adjecent[b].add(a);
	}

	private void dfs(int i) {

		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[v];
		stack.push(i);
		visited[i] = true;
		System.out.println(i);
		while (!stack.isEmpty()) {
			boolean temp = false;
			for (int a = 0; a < adjecent[i].size(); a++) {
				if (!visited[adjecent[i].get(a)]) {
					i = adjecent[i].get(a);
					stack.add(i);
					visited[i] = true;
					System.out.println(i);
					temp = true;
					break;
				}
			}

			if (!temp) {
				i = stack.pop();
				for (int a = 0; a < adjecent[i].size(); a++) {
					if (!visited[adjecent[i].get(a)]) {
						i = adjecent[i].get(a);
						stack.add(i);
						visited[i] = true;
						temp = true;
						System.out.println(i);
						break;
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		DepthFirstSearch_DFS dfsGraph = new DepthFirstSearch_DFS(5);
		dfsGraph.addEdge(dfsGraph, 0, 1);
		dfsGraph.addEdge(dfsGraph, 0, 2);
		dfsGraph.addEdge(dfsGraph, 1, 3);
		dfsGraph.addEdge(dfsGraph, 2, 4);
		dfsGraph.dfs(4);
	}

}
