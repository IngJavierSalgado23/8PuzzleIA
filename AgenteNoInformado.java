package salgado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class AgenteNoInformado {

    public static void main(String args[]) {

    }
    ambiente puzzle = new ambiente();
    ArrayList <Nodo> route = new ArrayList();
    private int nodosVisitados = 0;
    public AgenteNoInformado() {

    }

    public void createAgenteNoInformado() {
        puzzle.createAmbiente();
        DFS(puzzle.getStartState(), puzzle.getEndState()); //Escojo el nodo inicio del grafo y mando como se deberia ver el estado meta
    }

    public void DFS(Nodo inicio, Nodo destino) {
        System.out.println("Searching with DFS");
        Stack<Nodo> sNodos = new Stack();
        HashMap<Nodo, Nodo> map = new HashMap<Nodo, Nodo>();
        sNodos.push(inicio);
        Nodo tempo;
        while (!sNodos.isEmpty()) {
            tempo = sNodos.pop();
            if (tempo.visitado == false) {
                //System.out.println("Caminando por el Nodo"); //Si queremos ver como va recorriendo todo el grafo, descomentar estas lineas
                //tempo.imprimePuzzle();
                if (Arrays.deepEquals(tempo.getPuzzle(), destino.getPuzzle())) {
                    System.out.println("Se llego al nodo destino ");
                    tempo.imprimePuzzle();
                    backTrace(tempo, inicio, map);
                    break;
                }
            }
            tempo.visitado = true;
            for (int i = 0; i < tempo.vecinos.size(); i++) {
                if (tempo.vecinos.get(i).fin.visitado == false) {
                    sNodos.push(tempo.vecinos.get(i).fin);
                    map.put(tempo.vecinos.get(i).fin, tempo);
                }
            }

        }
    }

    public void backTrace(Nodo inicio, Nodo destino, HashMap map) //Del nodo meta, regresamos al nodo inicio
    {
        System.out.println("Numero de nodos visitados = " + map.size());
        nodosVisitados = map.size();
        ArrayList route = new ArrayList();              //Se crea un arraylist que contenga toda la ruta hasta la meta
        route.add(inicio);
        boolean found = false;
        System.out.println("BackTracing");
        Nodo tempo = inicio;
        while (!found) {                                //Usando un hashmap, partimos del nodo meta hacia el nodo padre hasta llegar al nodo inicio.
            tempo = (Nodo) map.get(tempo);
            route.add(tempo);
            if (Arrays.deepEquals(tempo.getPuzzle(), destino.getPuzzle())) {
                found = true;
            }
        }
        System.out.println("Numero de movimientos para la victoria " + route.size());
        
        reverseList(route);
        System.out.println("End backtracing");
    }

    public void reverseList(ArrayList<Nodo> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("-----------------------");
            list.get(i).imprimePuzzle();
            route.add(list.get(i));
        }
    }

    public Nodo getInicio()
    {
        return puzzle.getStartState();
    }
    public int getNodosVisitado()
    {
        return nodosVisitados;
    }
}
