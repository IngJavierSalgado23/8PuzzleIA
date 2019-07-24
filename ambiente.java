package salgado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ambiente {

    private ArrayList<Nodo> listaNodos = new ArrayList();               //Lista que almacena todos los estados posibles. Se utiliza para no repetir estados.
    private int[][] solution;                                           //Puzzle ya resuelto, usado para comparar si el estado llego a la meta.
    private boolean found_solution = false;


     public ambiente() {

    }

    public Nodo createAmbiente() {
        //Si se quiere usar una prueba ya comprobada comentar la linea createStart().
        //Prueba #1. Practica #1
        int[][] puzzle = new int[3][3];
        puzzle[0][0] = 1;
        puzzle[0][1] = 3;
        puzzle[0][2] = 5;
        puzzle[1][0] = 8;
        puzzle[1][1] = 2;
        puzzle[1][2] = 6;
        puzzle[2][0] = 4;
        puzzle[2][1] = 7;
        puzzle[2][2] = 0;
        imprimePuzzle(puzzle);
        //Fin de prueba
        do {
            listaNodos.clear();
//           int[][] puzzle = createStart();   //Si se quiere usar un ejemplo ya probado para ahorrar tiempo, comentar esta linea.
            Nodo inicio = new Nodo(puzzle, "Inicio");
            listaNodos.add(inicio);
            this.solution = generateSolution();
            Nodo tempo;
            int count = 0;
            while (listaNodos.size() < 100000 || found_solution) {      //Va generando el grafo hasta encontrar la solucion o llegar al limite.
                tempo = listaNodos.get(count);
                if (checkSolution(tempo)) {                             //Checa si el nodo es solucion, si no lo es sigue generando el grafo
                    this.found_solution = true;                         //Si es solucion, sale del ciclo
                    System.out.println("Exito!!");
                    imprimePuzzle(tempo.getPuzzle());
                    break;
                }
                generateGrafo(tempo);                                   //Aumenta el grafo
                count++;
            }
            System.out.println("Solution found " + found_solution);
            System.out.println("lista Nodos size = " + listaNodos.size());
            //imprimeNodoPuzzle();                                      //Si se quiere observar todos los estados, descomentar esta linea.
        } while (!found_solution);                                      //Si no se encontro en n estados, genera un nuevo puzzle.
       // System.out.println("Nodo inicio hermanos " + listaNodos.get(0).vecinos.size());
       return (listaNodos.get(0));
    }

    public int[][] createStart() {                                  //Este metodo genera un puzzle random. 
        ArrayList numbers = new ArrayList();
        int tempo[][] = new int[3][3];
        int apuzzle[] = new int[9];                                 //Genera un array unidimensional del puzzle para checar si es resolvible.
        Random random = new Random();
        do {
            int count = 0;
            System.out.println("Generating new puzzle");
            for (int i = 0; i < 9; i++) {
                numbers.add(i);
            }
            while (!numbers.isEmpty()) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int randomNum = random.nextInt((numbers.size()));
                        tempo[i][j] = (int) numbers.get(randomNum);
                        apuzzle[count] = (int) numbers.get(randomNum);
                        count++;
                        numbers.remove(randomNum);
                    }
                }
            }
        } while (!isSolvable(apuzzle));                                //Comprueba si se puede resolver.Si no se puede genera uno nuevo.
        System.out.println("Can be solved");
        imprimePuzzle(tempo);
        return tempo;
    }

    public int[][] generateSolution() {                      //Este metodo crea el estado con el puzzle resuelto. Usado para que cada estado pueda comprobar si se llego a la meta
        int[][] tempo = new int[3][3];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempo[i][j] = count;
                count++;
            }
        }
        tempo[2][2] = 0;
        return tempo;
    }

    public void imprimePuzzle(int[][] tempo) {           //Imprime el puzzle en consola
        System.out.println("Imprimiendo puzzle");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + i + " j = " + j + " = " + tempo[i][j]);
            }
        }
    }

    public void generateGrafo(Nodo padre) { //De un nodo padre, checa cuales estados puede tener y los manda a crear.
        //Creamos los estados que puede tomar el nodo
        int[][] puzzle = padre.getPuzzle();
        int pointer = 0;
        boolean finish = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pointer = puzzle[i][j];
                //Checa para que lados se puede mover el cero sin salirse del puzzle.
                if (pointer == 0) {
                    i--;
                    if (i >= 0) {
                        createNodo(puzzle, i, j, "UP", padre);
                    }
                    i += 2;
                    if (i < 3) {
                        createNodo(puzzle, i, j, "DOWN", padre);
                    }
                    i--;
                    j--;
                    if (j >= 0) {
                        createNodo(puzzle, i, j, "LEFT", padre);
                    }
                    j += 2;
                    if (j < 3) {
                        createNodo(puzzle, i, j, "RIGHT", padre);
                    }
                    finish = true;
                    break;
                }
            }
            if (finish) {
                break;
            }
        }
        //imprimeNodoPuzzle();
    }

    public void createNodo(int[][] p, int i, int j, String movement, Nodo padre) { //Crea un nuevo estado
        int[][] puzzle = new int[3][3];
        for (int x = 0; x < 3; x++) {                       //Creando copia de la matriz para poder modificarla
            for (int y = 0; y < 3; y++) {
                puzzle[x][y] = p[x][y];
            }
        }
        int tempo;
        Nodo tempoNodo;
        //System.out.println("Padre ");
       // padre.imprimePuzzle();
       // System.out.println("Hijo " + movement);
        switch (movement) {                                 //Hace el swap y crea al nuevo estado.
            case "UP":
                tempo = puzzle[i][j];
                puzzle[i][j] = puzzle[i + 1][j];
                puzzle[i + 1][j] = tempo;
                tempoNodo = new Nodo(puzzle, movement);
                tempoNodo.add_vecino(new arista(1, tempoNodo, padre)); //Creo conexion entre nodos.
                padre.add_vecino(new arista(1, padre, tempoNodo));
                if (!checkRepeats(tempoNodo)) {                         //Checa si el estado ya existe.
                    listaNodos.add(tempoNodo);
                }
                break;
            case "DOWN":
                tempo = puzzle[i][j];
                puzzle[i][j] = puzzle[i - 1][j];
                puzzle[i - 1][j] = tempo;
                tempoNodo = new Nodo(puzzle, movement);
                tempoNodo.add_vecino(new arista(1, tempoNodo, padre)); //Creo conexion entre nodos.
                padre.add_vecino(new arista(1, padre, tempoNodo));
                if (!checkRepeats(tempoNodo)) {
                    listaNodos.add(tempoNodo);
                }
                break;
            case "LEFT":
                tempo = puzzle[i][j];
                puzzle[i][j] = puzzle[i][j + 1];
                puzzle[i][j + 1] = tempo;
                tempoNodo = new Nodo(puzzle, movement);
                tempoNodo.add_vecino(new arista(1, tempoNodo, padre)); //Creo conexion entre nodos.
                padre.add_vecino(new arista(1, padre, tempoNodo));
                if (!checkRepeats(tempoNodo)) {
                    listaNodos.add(tempoNodo);
                }
                break;
            case "RIGHT":
                tempo = puzzle[i][j];
                puzzle[i][j] = puzzle[i][j - 1];
                puzzle[i][j - 1] = tempo;
                tempoNodo = new Nodo(puzzle, movement);
                tempoNodo.add_vecino(new arista(1, tempoNodo, padre)); //Creo conexion entre nodos.
                padre.add_vecino(new arista(1, padre, tempoNodo));
                if (!checkRepeats(tempoNodo)) {;
                    listaNodos.add(tempoNodo);
                }
                break;
            default:
                System.out.println("ERROR. Movimiento impossible.");
        }
    }

    public boolean checkRepeats(Nodo check) {           //Checa cada estado antes de agregarlo a la lista para asegurarnos de no meter repetidos.
        for (int i = 0; i < listaNodos.size(); i++) {
            if (Arrays.deepEquals(listaNodos.get(i).getPuzzle(), check.getPuzzle())) {
                //System.out.println("Nodo repetido"); //Quitar
                return true;
            }
        }
        return false;
    }

    public void imprimeNodoPuzzle() {                   //Imprime todos los estados creados
        for (int i = 0; i < listaNodos.size(); i++) {
            System.out.println("Nuevo Nodo = " + i);
            listaNodos.get(i).imprimePuzzle();
        }
    }

    public boolean checkSolution(Nodo check) {          //Comprueba el estado con el estado final, para checar si se llego a la meta.
        if (Arrays.deepEquals(check.getPuzzle(), this.solution)) {
            found_solution = true;
            return true;
        }
        return false;
    }

    public boolean isSolvable(int[] puzzle) {           //Cuenta el numero de inversiones y establece si el puzzle se puede resolver o no.
        int inversions = 0;
        for (int i = 0; i < puzzle.length - 1; i++) {
            for (int j = i + 1; j < puzzle.length; j++) {
                if (puzzle[i] > puzzle[j]) {
                    inversions++;
                }
            }
            if (puzzle[i] == 0 && i % 2 == 1) {
                inversions++;
            }
        }
        return (inversions % 2 == 0);
    }

    public Nodo getStartState() {
        return listaNodos.get(0);
    }

    public Nodo getEndState() {
        return (new Nodo(solution, "Solucion"));
    }
}
