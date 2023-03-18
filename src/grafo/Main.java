package grafo;

public class Main {
    
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();
        grafo.crearNodo("A");
        grafo.crearNodo("B");
        grafo.crearNodo("C");
        grafo.crearNodo("D");
        grafo.crearNodo("E");
        grafo.crearNodo("F");
        grafo.crearNodo("G");
        grafo.crearArco("G", "A");
        grafo.crearArco("D", "E");
        grafo.eliminarNodo("A");
        grafo.eliminarArco("D", "E");
        grafo.eliminarArco("Z", "E"); //ELIMNANDO NODO IMPOSIBLE
        grafo.generarMatrizAdyacencia();
        System.out.println(grafo);
    }
}
