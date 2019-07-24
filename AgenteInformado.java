package salgado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class AgenteInformado {

    public static void main(String args[]) {
        new AgenteInformado();
    }

    public AgenteInformado() {

    }
    ambiente puzzle = new ambiente();
    ArrayList<Nodo> route = new ArrayList();
    int xcount = 0;
    private int nodosVisitados = 0;
    int fx = 0;

    public void createAgenteInformado() {
        Nodo head_grafo;
        HashMap map = new HashMap();
        head_grafo = puzzle.createAmbiente();
        head_grafo.imprimePuzzle();
        h_outOfOrder(head_grafo, map);

    }

    public Nodo h_outOfOrder(Nodo inicio, HashMap map) {
        Stack recompensa = new Stack();
        if (inicio.visitado == false) {
            inicio.visitado = true;
            if (Arrays.deepEquals(inicio.getPuzzle(), puzzle.getEndState().getPuzzle())) {
                System.out.println("Se llego a la meta");
                inicio.imprimePuzzle();
                backTrace(inicio, puzzle.getStartState(), map);
                return inicio;
            }
        }
        if (!inicio.vecinos.isEmpty()) {
            for (int i = 0; i < inicio.vecinos.size(); i++) {
                Nodo tempo = inicio.vecinos.get(i).fin;
                if (tempo.visitado == false) {
                    check_order(tempo);
                    if (recompensa.isEmpty()) {
                        recompensa.push(tempo);
                    } else {
                        Nodo anterior = (Nodo) recompensa.pop();                            //Evaluo cual Nodo tiene mayor funcion de utilidad, descarto al menor o igual.
                        if (tempo.get_recompensa() <= anterior.get_recompensa()) {
                            recompensa.push(anterior);
                        } else {
                            recompensa.push(tempo);
                        }
                    }
                }
            }
            if (recompensa.isEmpty()) { //Los vecinos del nodo no fueron generado por el grafo.
              //Ruta muerta, calculando nueva ruta*/
                inicio.vecinos.get(0).fin.visitado = false;
                map.values().remove(inicio);
                h_outOfOrder(inicio.vecinos.get(0).fin, map);
            } else {
                Nodo decision = (Nodo) recompensa.pop();
                fx =  1 + (-1 * decision.get_recompensa());
                map.put(decision, inicio);
                h_outOfOrder(decision, map);                 //Recursion. Recorro todo el grafo hasta encontrar mi estado meta y guardo la ruta.
            }
        }
        return null;
    }

    public int check_order(Nodo actual) { //Funcion de utilidad. Heuristica. Checo cuantos numeros estan fuera de orden
        int[] tempoPuzzle = new int[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempoPuzzle[count] = actual.getPuzzle()[i][j];
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < 8; i++) {
            if (tempoPuzzle[i] != i + 1) {
                count++;
            }
        }
        if (tempoPuzzle[8] != 0) {
            count++;
        }
        actual.set_recompensa(-1 * count);
        return count;
    }

    public void backTrace(Nodo inicio, Nodo destino, HashMap map) //Del nodo meta, regresamos al nodo inicio
    {
        System.out.println("Cantidad de nodos visitados " + map.size());
        nodosVisitados = map.size();
        ArrayList route = new ArrayList();              //Se crea un arraylist que contenga toda la ruta hasta la meta
        route.add(inicio);
        boolean found = false;
        System.out.println("BackTracing");
        Nodo tempo = inicio;
        while (!found) {                                //Usando un hashmap, partimos del nodo meta hacia el nodo padre hasta llegar al nodo inicio.
            tempo = (Nodo) map.get(tempo);
            System.out.println("New route added");
            route.add(tempo);
            if (Arrays.deepEquals(tempo.getPuzzle(), destino.getPuzzle())) {
                found = true;
            }
        }
        System.out.println("Numero de movimientos para la victoria " + route.size());
        reverseList(route);
        System.out.println("End backtracing");
        System.out.println("f(x) = " + fx);
    }

    public void reverseList(ArrayList<Nodo> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("-----------------------");
            list.get(i).imprimePuzzle();
            route.add(list.get(i));
        }
    }

    public Nodo getInicio() {
        return puzzle.getStartState();
    }

    public int getNodosVisitado() {
        return nodosVisitados;
    }
}
