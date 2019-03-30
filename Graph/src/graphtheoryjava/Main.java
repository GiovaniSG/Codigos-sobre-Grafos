package graphtheoryjava;

import graphtheoryjava.util.Leitura;
import graphtheoryjava.util.Arco;
import graphtheoryjava.util.Grafo;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import graphtheoryjava.util.info.Busca;
import graphtheoryjava.util.info.Info;
import graphtheoryjava.util.info.MenorCaminho;

public class Main {
	public static void main(String[] args) {

		try {
			 System.out.println("Arquivo Grafo");
			Scanner entrada = new Scanner(System.in);
			String nomeArquivo = entrada.nextLine();
			Leitura leitura = new Leitura();
			
			Grafo grafo = leitura.leArquivo(nomeArquivo);
			Info F = new Info(grafo);
                        Busca B = new Busca(grafo);
            
            //teste 1 Lista de Adjacencia e Matrix de Adjacencia  
             F.imprime();
             
            //teste 2 Ordem do Grafo
            int Ordem =  F.Ordem();
            System.out.println("\nOrdem do Grafo: " + Ordem);
            int n = 4;
            //teste 3 Lista de arestas adjacentes
            ArrayList<Arco> ArestaAdj;
            ArestaAdj = F.Adjacente(F.grafo.arestas.get(n));
            System.out.println("\nArcos adjacentes: ");
            for(int i = 0; i < ArestaAdj.size(); i++){
            	System.out.println(ArestaAdj.get(i).origem +" "+ArestaAdj.get(i).destino+" "+ArestaAdj.get(i).peso);
            }
            
          //teste 4 Lista de Vertices adjacenties sucessor
            ArrayList<Integer> VAdjS;
            VAdjS = F.VAdjacenteS(n);
            System.out.println("\nLista de Vertices adjacentes sucessor "+ n +":");
            for(int i = 0; i < VAdjS.size(); i++){
            	System.out.println(VAdjS.get(i));
            }
            
           //teste 5 Lista de Vertices adjacenties antecessor
            ArrayList<Integer> VAdjA ;
            VAdjA = F.VAdjacenteA(n);
            System.out.println("\nLista de Vertices adjacenties antecessores "+ n +":");
            for(int i = 0; i < VAdjA.size(); i++){
            	System.out.println(VAdjA.get(i));
            }
            
            //teste 6
            ArrayList<Arco> AIVert;
            AIVert = F.AIncidenteVert(n);
            
            System.out.println("\nLista Arestas incidentes ao vertice "+ n +":");
            for(int i = 0; i < AIVert.size(); i++){
            	System.out.println(AIVert.get(i).origem +" "+ AIVert.get(i).destino +" "+  AIVert.get(i).peso);
            }
            
            //teste 7 
            
            ArrayList<Integer> vert;
            vert = F.VIncidenteA(grafo.arestas.get(0));
            System.out.println("\nLista vertices incidentes a uma aresta "+ 0 +":");
            
            for(int i = 0; i < vert.size(); i++){
            	System.out.println(vert.get(i));
            }
            
            //teste 8           
            int grau;
            grau = F.GrauIn(2);     
            System.out.println("\nGrau de um vertice entrada " + 2 +": "+ grau);
            
            //teste 9 
            grau = F.GrauOut(3);
            System.out.println("\nGrau de um vertice saida " + 3 +": "+ grau);
            
            //teste 10
            String vertA = F.VerticesAdjacentes(2, 4);
            System.out.println("\nVertices 2 e 4 "+ vertA);
            //teste 11
            int[] visitados;
            visitados = B.BuscaemLargura(0);
            System.out.println("\nBusca em Largura: ");
            for(int i = 0; i < visitados.length; i++){
                System.out.print(visitados[i]);
                System.out.print(" ");
            }
            //teste 12
            int[] visitados2;
            visitados2 = B.BuscaemProfundidade(3);
            System.out.println("\nBusca em Profundidade: ");
            for(int i = 0; i < visitados2.length; i++){
                System.out.print(visitados2[i]);
                System.out.print(" ");
            }
                    System.out.println();
            //teste 13
            int[] visitados3;
            visitados3 = B.BuscaemProfundidadeRecursiva(3);
            System.out.println("\nBusca em Profundidade Recursiva: ");
            for(int i = 0; i < visitados3.length; i++){
                System.out.print(visitados3[i]);
                System.out.print(" ");
            }
            System.out.println();
            //teste 14
            System.out.println("Componentes Conexas:\n"+B.CompConexas());
            
            //teste 15
            System.out.println("Ordem Topologica:");
            ArrayList<Integer> OrdemTop;
            OrdemTop = B.OrdTop();
            for(int i = 0; i < OrdemTop.size(); i++){
                System.out.print(OrdemTop.get(i));
                System.out.print(" ");
            }
    		
            //Parte II

            System.out.println("\n\nAlgoritmo de Dijkstra");
            Scanner ler = new Scanner(System.in);
            String Arquivo = ler.nextLine();
            Leitura L = new Leitura();
            Grafo grafo= L.leArquivo(Arquivo);
            
            MenorCaminho MCaminho = new MenorCaminho(grafo);
			
            System.out.println("Informe um vertice de origem e um de destino!");
            Scanner verti = new Scanner(System.in);
			int orig = verti.nextInt();
			
			int desti = verti.nextInt();
			
			ArrayList<Integer> sequencia;  
			sequencia = MCaminho.Dijkstra(orig,desti);
			
			System.out.print("Caminho do "+ orig+" ao "+ desti +": ");
			for(int i = 0; i < sequencia.size();i++){
			System.out.print(sequencia.get(i)+" ");
			
			}
			
			System.out.println("\n\nAlgoritmo de Bellman Ford");
			sequencia = MCaminho.BellmanFord(orig,desti);
			
			System.out.print("Caminho do "+ orig+" ao "+ desti +": ");
			for(int i = 0; i < sequencia.size();i++){
			System.out.print(sequencia.get(i)+" ");
			
			}
			
			
	} catch (IOException e) {
		}
	}
}