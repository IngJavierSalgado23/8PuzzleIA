package salgado;

import java.util.ArrayList;

public class Nodo {
    boolean visitado = false;
    private int[][] puzzle;
    public String movement;
    public ArrayList<arista> vecinos = new ArrayList();
    private int recompensa;

    public Nodo(int[][] puzzle, String m) {
        this.puzzle = puzzle;
        this.movement = m;
    }

    public void add_vecino(arista a) {
        vecinos.add(a);
    }

    public int[][] getPuzzle() {
        return this.puzzle;
    }

    public void imprimePuzzle() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + i + " j = " + j + " = " + this.puzzle[i][j]);
            }
        }
    }
    public int get_recompensa()
    {
        return this.recompensa;
    }
    public void set_recompensa(int x)
    {
        this.recompensa = x;
    }
}
