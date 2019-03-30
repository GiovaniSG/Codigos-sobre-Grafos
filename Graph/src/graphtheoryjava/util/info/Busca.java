package graphtheoryjava.util.info;

import graphtheoryjava.util.Grafo;
import java.util.ArrayList;

public class Busca {

    public Grafo grafo;

    public Busca(Grafo p_grafo) {
        this.grafo = p_grafo;
    }
    public Info info = new Info(grafo);

    //11 busca em largura
    public int[] BuscaemLargura(int vertice) {
        ArrayList<Integer> Fila = new ArrayList();
        int[] visitados = new int[grafo.vertices.size()];
        for (int i = 0; i < grafo.vertices.size(); i++) {
            visitados[i] = 0;
        }
        visitados[vertice] = 1;
        Fila.add(vertice);
        int n=2;

        while (!Fila.isEmpty()) {
            int u = Fila.remove(0);
            for (int j = 0; j < grafo.vertices.size(); j++) {
                if (grafo.adjMatrix[u][j] != 0) {
                    if (visitados[j] == 0) {
                        visitados[j] = n;
                        n++;
                        Fila.add(j);
                    }
                }
            }
        }

        return visitados;
    }

    //12 busca em profundidade
    public int[] BuscaemProfundidade(int vertice) {

        ArrayList<Integer> Pilha = new ArrayList();
        int[] visitados = new int[grafo.vertices.size()];

        for (int i = 0; i < grafo.vertices.size(); i++) {
            visitados[i] = 0;
        }
        visitados[vertice] = 1;
        Pilha.add(vertice);
        int n = 2;

        while (!Pilha.isEmpty()) {
            int u = Pilha.get(Pilha.size() - 1);
            ArrayList<Integer> Sucessores = new ArrayList();

            for (int j = 0; j < grafo.vertices.size(); j++) {
                if (grafo.adjMatrix[u][j] != 0)
                    Sucessores.add(j);
            }

            int cont = 0;
            for (int j = 0; j < Sucessores.size(); j++) {
                int v = Sucessores.get(j);
                cont = 1;
                if (visitados[v] == 0) {
                    visitados[v] = n;
                    n++;
                    Pilha.add(v);
                    cont = 0;
                    break;
                }
            }
            if (cont == 1||Sucessores.isEmpty()) {
                Pilha.remove(Pilha.size() - 1);
            }
        }

        return visitados;
    }

    //13 busca em profundidade recursiva
    private int[] Profundidade(int u,int[] vis,int n){
        vis[u] = n;
        ArrayList<Integer> Suc = new ArrayList();
        for (int j = 0; j < grafo.vertices.size(); j++) {
                if (grafo.adjMatrix[u][j] != 0)
                    Suc.add(j);
            }
        for (int i = 0; i < Suc.size(); i++) {
                if (vis[Suc.get(i)]==0){
                    n++;
                    Profundidade(Suc.get(i),vis,n);
                }
            }
        return vis;
    }
    public int[] BuscaemProfundidadeRecursiva(int vertice) {

        int[] visitados = new int[grafo.vertices.size()];

        for (int i = 0; i < grafo.vertices.size(); i++) {
            visitados[i] = 0;
        }
        int n=1;
        if(visitados[vertice]==0){
               visitados = Profundidade(vertice,visitados,n); 
        }
        return visitados;
    }
    //14 componentes conexas
    private int[] ProfConex(int u,int marca,int[] vis){
        vis[u]=marca;
        ArrayList<Integer> Suc = new ArrayList();
        for (int j = 0; j < grafo.vertices.size(); j++) {
                if (grafo.adjMatrix[u][j] != 0)
                    Suc.add(j);
            }
        for(int i=0;i<Suc.size();i++){
            if(vis[Suc.get(i)]==0){
                ProfConex(Suc.get(i),marca,vis);
            }
        }
        return vis;
    }
    public int CompConexas (){
        int [] visitados = new int[grafo.vertices.size()];
        for(int i=0;i<grafo.vertices.size();i++){
            visitados[i]=0;
        }
        int componentes = 0;
        for(int i=0;i<visitados.length;i++){
            if(visitados[i]==0){
                componentes++;
                visitados = ProfConex(i,componentes,visitados);
            }
        }
        return componentes;
    }
    //15 Ordem Topologica
    private ArrayList<Integer> ProfOrd(int u,int[] vis,ArrayList<Integer> ord){
        vis[u]=1;
        ArrayList<Integer> Suc = new ArrayList();
        for (int j = 0; j < grafo.vertices.size(); j++) {
                if (grafo.adjMatrix[u][j] != 0)
                    Suc.add(j);
            }
        for(int i=0;i<Suc.size();i++){
            if(vis[Suc.get(i)]==0){
                ProfOrd(Suc.get(i),vis,ord);
            }
        }
        ord.add(0, u);
        return ord;
    }
    public ArrayList<Integer> OrdTop(){
        ArrayList<Integer> Ordem = new ArrayList();
        int [] visitados = new int[grafo.vertices.size()];
        for(int i=0;i<grafo.vertices.size();i++){
            visitados[i]=0;
        }
        for(int i=0;i<visitados.length;i++){
            if(visitados[i]==0){
                Ordem = ProfOrd(i,visitados,Ordem);
            }
        }
        return Ordem;
    }
}
