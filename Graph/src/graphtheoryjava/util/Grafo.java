package graphtheoryjava.util;

import java.util.ArrayList;

public class Grafo {

	public ArrayList<Integer> vertices;
	public ArrayList<Arco> arestas;
	public ArrayList<ArrayList<Arco>> adjList;
	public int[][] adjMatrix;

	public Grafo(ArrayList<Integer> vertices, ArrayList<Arco> arestas, ArrayList<ArrayList<Arco>> adjList,
			int[][] adjMatrix) {

		this.vertices = vertices;
		this.arestas = arestas;
		this.adjList = adjList;
		this.adjMatrix = adjMatrix;
	}

}
