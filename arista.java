/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salgado;

/**
 *
 * @author Traumatologia
 */
public class arista {
    int peso;
    Nodo inicio;
    Nodo  fin;
    int posicion;
    arista siguiente =null;

    public arista(int peso, Nodo A, Nodo B)
    {
        inicio = A;
        fin = B;
        this.peso = peso;
    }
}
