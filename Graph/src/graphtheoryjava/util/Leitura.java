package graphtheoryjava.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura {

	public File arquivo;
	public Grafo grafo;

	public Leitura() {

	}

	public Grafo leArquivo(String nomeArquivo) throws IOException {

		// abre o arquivo
		this.arquivo = new File(nomeArquivo);
		FileReader leitura = new FileReader(arquivo);
		BufferedReader armazenar = new BufferedReader(leitura);

		// lê o cabeçalho
		String[] linha;
		linha = armazenar.readLine().split(" ");
		int numVertices = Integer.parseInt(linha[0]);
		int numArcos = Integer.parseInt(linha[1]);

		// Inicializa as estruturas
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		ArrayList<ArrayList<Arco>> adjList = new ArrayList<ArrayList<Arco>>();
		int[][] adjMatrix = new int[numVertices][numArcos];
		ArrayList<Arco> arcos = new ArrayList<Arco>();

		// cria a lista de adjacencia e a matrix de adjacencia

		for (int i = 0; i < numVertices; ++i) {
			for (int j = 0; j < numVertices; ++j) {
				adjMatrix[i][j] = 0;
			}
		}

		for (int i = 0; i < numVertices; ++i) {
			adjList.add(new ArrayList<Arco>());
		}

		// preenche as estruturas

		// preenche a lista de vértices
		for (int i = 0; i < numVertices; ++i) {
			vertices.add(i);
		}

		for (int i = 0; i < numArcos; ++i) {
			String[] infoArco = armazenar.readLine().split(" ");
			int origem = Integer.parseInt(infoArco[0]);
			int destino = Integer.parseInt(infoArco[1]);
			int peso = Integer.parseInt(infoArco[2]);

			Arco e = new Arco(origem, destino, peso);

			arcos.add(e);

			adjList.get(origem).add(e);
			adjMatrix[origem][destino] = peso;

		}

		grafo = new Grafo(vertices, arcos, adjList, adjMatrix);

		// fecha o arquivo
		armazenar.close();
		leitura.close();
		return grafo;
	}
}
