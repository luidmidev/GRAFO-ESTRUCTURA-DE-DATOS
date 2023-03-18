package grafo;

import java.util.ArrayList;

public class Grafo<T> {

    private ArrayList<Nodo<T>> LAdyacente;

    public Grafo() {
        this.LAdyacente = new ArrayList();
    }

    public void crearNodo(T objNodo) {
        Nodo<T> nodo = new Nodo<>(objNodo);
        if (!existeNodo(objNodo)) {
            LAdyacente.add(nodo);
        } else {
            System.out.println("El nodo {" + objNodo + "} ya existe");
        }

    }

    private Boolean existeNodo(T objNodo) {
        return LAdyacente.stream().anyMatch(Nodo -> (Nodo.getObjNodo().equals(objNodo)));
    }

    private Nodo<T> buscarNodo(T objNodo) {
        for (Nodo<T> nodo : LAdyacente) {
            if (nodo.getObjNodo().equals(objNodo)) {
                return nodo;
            }
        }
        return null;
    }

    public void crearArco(T objInicio, T objFin) {
        if (existeNodo(objInicio) && existeNodo(objFin) && !existeArco(objInicio, objFin)) {
            buscarNodo(objInicio).getArcos().add(objFin);
        } else {
            System.out.println("Revise que ambos nodos existan o que no exista un arco entre ambos");
        }
    }

    private Boolean existeArco(T objInicio, T objFin) {
        if (existeNodo(objInicio) && existeNodo(objFin)) {
            return buscarNodo(objInicio).getArcos().stream().anyMatch(objNodo -> (objNodo.equals(objFin)));
        } else {
            return false;
        }
    }

    public void eliminarNodo(T objNodo) {
        if (existeNodo(objNodo)) {
            for (Nodo<T> nodo : LAdyacente) {
                if (nodo.getArcos().contains(objNodo)) {
                    nodo.getArcos().remove(objNodo);
                }
            }
            LAdyacente.remove(buscarNodo(objNodo));
        } else {
            System.out.println("Revise que el nodo exista");
        }
    }

    public void eliminarArco(T objInicio, T objFin) {
        if (existeNodo(objInicio) && existeNodo(objFin) && existeArco(objInicio, objFin)) {
            for (Nodo<T> nodo : LAdyacente) {
                if (nodo.getObjNodo().equals(objInicio)) {
                    nodo.getArcos().remove(objFin);
                }
            }
        } else {
            System.out.println("Revise que ambos nodos existan o que exista un arco entre ambos");
        }
    }

    public boolean sonAdyacentes(T objInicio, T objFin) {
        return Boolean.logicalXor(existeArco(objInicio, objFin), existeArco(objFin, objInicio));
    }

    public int[][] generarMatrizAdyacencia() {
        Integer n = LAdyacente.size();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sonAdyacentes(LAdyacente.get(i).getObjNodo(), LAdyacente.get(j).getObjNodo())) {
                    matriz[i][j] = 1;
                }
            }
        }
        System.out.print("[   ]");
        for (int i = 0; i < n; i++) {
            System.out.print("[ " + LAdyacente.get(i).getObjNodo() + " ]");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    System.out.print("[ " + LAdyacente.get(i).getObjNodo() + " ]");
                }
                System.out.print("[ " + matriz[i][j] + " ]");
            }
            System.out.println();
        }
        return matriz;
    }

    @Override
    public String toString() {
        return "Grafo[" + "LAdyacente : (" + LAdyacente + ")]";
    }

}
