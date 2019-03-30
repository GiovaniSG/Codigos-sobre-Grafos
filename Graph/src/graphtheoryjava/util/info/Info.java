package graphtheoryjava.util.info;

import graphtheoryjava.util.*;
import java.util.ArrayList;

public class Info {
	public Grafo grafo;

	public Info(Grafo p_grafo) {
		this.grafo = p_grafo;
	}
        
    //1 Lista de Adjacencia
        public void imprime(){
            System.out.println("Lista de Adjacencia");
		for (int i = 0; i < grafo.adjList.size(); ++i) {
			System.out.print(i);
			for (int j = 0; j < grafo.adjList.get(i).size(); ++j) {
				System.out.printf("->" + grafo.adjList.get(i).get(j).destino + " ");
			}
                            System.out.println();
			}

    //1 Matrix de Adjacencia
            System.out.println("Matrix de Adjacencia");
		for (int i = 0; i < grafo.vertices.size(); ++i) {
                    for (int j = 0; j < grafo.vertices.size(); ++j) {
			System.out.print(grafo.adjMatrix[i][j] + "  ");
                    }
			System.out.println();
		}
}
			
//2 Ordem do Grafo
	public int Ordem() {
		return grafo.vertices.size();
	}

	//3 Lista de arestas adjacentes
	public ArrayList<Arco> Adjacente(Arco aresta) {
		ArrayList<Arco> adj = new ArrayList();
		for (int i = 0; i < grafo.arestas.size(); i++) {
			if (grafo.arestas.get(i).origem == aresta.origem && grafo.arestas.get(i).destino == aresta.destino)
				;
			else if (grafo.arestas.get(i).origem == aresta.origem || grafo.arestas.get(i).destino == aresta.destino
					|| grafo.arestas.get(i).origem == aresta.destino || grafo.arestas.get(i).destino == aresta.origem)
				adj.add(grafo.arestas.get(i));
		}
		return adj;
	}

	//4 Lista de Vertices adjacenties sucessor
	public ArrayList<Integer> VAdjacenteS(int vertice) {
		ArrayList<Integer> VAdjS = new ArrayList();
			for (int j = 0; j < grafo.vertices.size(); j++) {
				if (grafo.adjMatrix[vertice][j] != 0)
					VAdjS.add(j);
			}
		

		return VAdjS;
	}

	//5 Lista de Vertices adjacenties antecessor
	public ArrayList<Integer> VAdjacenteA(int vertice) {
		ArrayList<Integer> VAdjA = new ArrayList();

		for (int i = 0; i < grafo.vertices.size(); i++) {
				if (grafo.adjMatrix[i][vertice] != 0)
					VAdjA.add(i);
		}

		return VAdjA;

	}
        
        //6 Retornar Arestas incidentes a um vertice
        public ArrayList<Arco> AIncidenteVert (int vertice){
            ArrayList<Arco> AIVert = new ArrayList();
           
            for (int i = 0; i < grafo.vertices.size(); i++) {
                if (grafo.adjMatrix[i][vertice] != 0){
                    int j=0;
                    while(grafo.adjList.get(i).get(j).destino != vertice){
                        j++;
                    }
                AIVert.add(grafo.adjList.get(i).get(j));
                }  
		}
            
            return AIVert;
        }
        
        //7 Retorna vertices incidentes a uma aresta
        public ArrayList<Integer> VIncidenteA (Arco aresta){
            ArrayList<Integer> vert = new ArrayList();
            vert.add(aresta.origem);
            vert.add(aresta.destino);
            return vert;
        }
        
        //8 Grau de um vertice entrada
        public int GrauIn(int vert){
            int grau = 0;
            
            if(vert >= 0 && vert <= grafo.vertices.size()){ 
                for (int i = 0; i < grafo.vertices.size(); i++) {
				if (grafo.adjMatrix[i][vert] != 0)
					grau++;
		}
            }else	
                System.out.println("Valor nao existe!");
         return grau;
        }
         //9 Grau de um vertice saida
        public int GrauOut(int vert){
            int grau = 0;
            
            if(vert >= 0 && vert <= grafo.vertices.size()){ 
                for (int i = 0; i < grafo.vertices.size(); i++) {
				if (grafo.adjMatrix[vert][i] != 0)
					grau++;
		}
            }else	
                System.out.println("Valor nao existe!");
         return grau;
        }
        //10 Se dois vertices são adjacentes
        public String VerticesAdjacentes(int v1,int v2){
            if(grafo.adjMatrix[v1][v2] != 0 || grafo.adjMatrix[v2][v1] !=0){
                return "sao Adjacentes";
            }else return"nao sao adjacentes";            
        }
}
