package grafo;

import java.util.ArrayList;

public class Nodo<T> {

    private T objNodo;
    private ArrayList<T> arcos;

    public Nodo() {
    }

    public Nodo(T objNodo) {
        this.objNodo = objNodo;
        arcos = new ArrayList<>();
    }

    public T getObjNodo() {
        return objNodo;
    }

    public void setObjNodo(T objNodo) {
        this.objNodo = objNodo;
    }

    public ArrayList<T> getArcos() {
        return arcos;
    }

    public void setArcos(ArrayList<T> arcos) {
        this.arcos = arcos;
    }

    @Override
    public String toString() {
        return "Nodo[" + "Dato: " + objNodo + ", arcos: " + arcos + "]";
    }

}
