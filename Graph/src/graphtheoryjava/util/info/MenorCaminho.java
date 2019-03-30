package graphtheoryjava.util.info;

import java.util.ArrayList;
import graphtheoryjava.util.Grafo;

public class MenorCaminho {

	Grafo grafo;

	public MenorCaminho(Grafo grafo_p) {
		grafo = grafo_p;
	}

	// Dijkstra
	public ArrayList<Integer> Dijkstra(int origem, int destino) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> Sequencia = new ArrayList<>();

		int[] dist = new int[grafo.vertices.size()];
		int[] pred = new int[grafo.vertices.size()];
		int menor;
		ArrayList<Integer> Q = new ArrayList<>();

		for (int i = 0; i < grafo.vertices.size(); i++) {
			dist[i] = 999999;
			pred[i] = -1;
		}

		dist[origem] = 0;
		
		for (int i = 0; i < grafo.vertices.size(); i++) {
			Q.add(i);
		}
		
		

		while (!Q.isEmpty()) {
			menor = min(dist, Q);
			Q.remove(Q.indexOf(menor));

			ArrayList<Integer> Sucessores = new ArrayList();

			for (int j = 0; j < grafo.vertices.size(); j++) {
				if (grafo.adjMatrix[menor][j] != 0)
					Sucessores.add(j);
			}

			for (int i = 0; i < Sucessores.size(); i++) {
				if (dist[Sucessores.get(i)] > (dist[menor] + grafo.adjMatrix[menor][Sucessores.get(i)])) {
					dist[Sucessores.get(i)] = (dist[menor] + grafo.adjMatrix[menor][Sucessores.get(i)]);
					pred[Sucessores.get(i)] = menor;
				}

			}
		}
		

		int aux = destino;
		Sequencia.add(destino);
		while (aux != origem) {
			aux = pred[aux];
			Sequencia.add(0, aux);
		}

		System.out.println("Peso do caminho: " + dist[destino]);

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("\nTempo de execucao do Dijkstra: " + elapsed / 1000 + "s");
		return Sequencia;
	}

	public int min(int dist[], ArrayList<Integer> Q) {
		int menorValor = 9999999, menorVertice = 0;

		for (int i = 0; i < Q.size(); i++) {
			if (menorValor > dist[Q.get(i)]) {
				menorValor = dist[Q.get(i)];
				menorVertice = Q.get(i);
			}
		}

		return menorVertice;
	}

	// Bellman-Ford
	public ArrayList<Integer> BellmanFord(int origem, int destino) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> Sequencia = new ArrayList();

		int[] dist = new int[grafo.vertices.size()];
		int[] pred = new int[grafo.vertices.size()];

		for (int i = 0; i < grafo.vertices.size(); i++) {
			dist[i] = 999999;
			pred[i] = -1;
		}

		dist[origem] = 0;

		for (int i = 0; i < grafo.vertices.size(); i++) {
			for (int j = 0; j < grafo.arestas.size(); j++) {
				if (dist[grafo.arestas.get(j).destino] > dist[grafo.arestas.get(j).origem]
						+ grafo.arestas.get(j).peso) {
					dist[grafo.arestas.get(j).destino] = dist[grafo.arestas.get(j).origem] + grafo.arestas.get(j).peso;
					pred[grafo.arestas.get(j).destino] = grafo.arestas.get(j).origem;
				}
			}

		}

		int aux = destino;
		Sequencia.add(destino);
		while (aux != origem) {
			aux = pred[aux];
			Sequencia.add(0, aux);
		}

		System.out.println("Peso do caminho: " + dist[destino]);

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Tempo de execução do Bellman Ford: " + elapsed / 1000 + "s");

		return Sequencia;
	}

}
