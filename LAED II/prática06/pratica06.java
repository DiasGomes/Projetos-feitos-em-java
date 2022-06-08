public class pratica06 {

    private static XGrafo grafo1, grafo2;

    public static void main(String args[]) throws Exception{
        // instancia grafos
        grafo1 = new XGrafo(9);
        grafo2 = new XGrafo(8);

        // cria o primeiro grafo
        criaGrafo1();
        grafo1.imprime();
        // cria AGM
        XAGM agm1 = new XAGM(grafo1);
        agm1.obterAgm((int) 'a' - 97);
        agm1.imprime();

        // cria o segundo grafo
        criaGrafo2();
        grafo2.imprime();
        // cria AGM
        XAGM agm2 = new XAGM(grafo2);
        agm2.obterAgm(1 - 1);
        agm2.imprime();
    }

    private static void criaGrafo1(){
        // vertice A
        grafo1.insereAresta((int) 'a' - 97,(int) 'b' - 97,5);
        grafo1.insereAresta((int) 'a' - 97,(int) 'd' - 97,10);
        grafo1.insereAresta((int) 'a' - 97,(int) 'd' - 97,10);
        grafo1.insereAresta((int) 'a' - 97,(int) 'g' - 97,10);
        grafo1.insereAresta((int) 'a' - 97,(int) 'h' - 97,10);
        // vertice B
        grafo1.insereAresta((int) 'b' - 97,(int) 'a' - 97,5);
        grafo1.insereAresta((int) 'b' - 97,(int) 'f' - 97,5);
        grafo1.insereAresta((int) 'b' - 97,(int) 'h' - 97,5);
        grafo1.insereAresta((int) 'b' - 97,(int) 'k' - 99,10);
        // vertice C
        grafo1.insereAresta((int) 'c' - 97,(int) 'd' - 97,5);
        grafo1.insereAresta((int) 'c' - 97,(int) 'e' - 97,10);
        grafo1.insereAresta((int) 'c' - 97,(int) 'g' - 97,5);
        // vertice D
        grafo1.insereAresta((int) 'd' - 97,(int) 'a' - 97,10);
        grafo1.insereAresta((int) 'd' - 97,(int) 'c' - 97,5);
        grafo1.insereAresta((int) 'd' - 97,(int) 'e' - 97,5);
        grafo1.insereAresta((int) 'd' - 97,(int) 'g' - 97,10);
        // vertice E
        grafo1.insereAresta((int) 'e' - 97,(int) 'a' - 97,5);
        grafo1.insereAresta((int) 'e' - 97,(int) 'c' - 97,10);
        grafo1.insereAresta((int) 'e' - 97,(int) 'd' - 97,5);
        grafo1.insereAresta((int) 'e' - 97,(int) 'k' - 99,10);
        // vertice F
        grafo1.insereAresta((int) 'f' - 97,(int) 'b' - 97,5);
        grafo1.insereAresta((int) 'f' - 97,(int) 'g' - 97,15);
        // vertice G
        grafo1.insereAresta((int) 'g' - 97,(int) 'a' - 97,10);
        grafo1.insereAresta((int) 'g' - 97,(int) 'c' - 97,5);
        grafo1.insereAresta((int) 'g' - 97,(int) 'd' - 97,10);
        grafo1.insereAresta((int) 'g' - 97,(int) 'f' - 97,15);
        // vertice H
        grafo1.insereAresta((int) 'h' - 97,(int) 'a' - 97,10);
        grafo1.insereAresta((int) 'h' - 97,(int) 'b' - 97,5);
        grafo1.insereAresta((int) 'h' - 97,(int) 'k' - 99,20);
        // vertice K
        grafo1.insereAresta((int) 'k' - 99,(int) 'b' - 97,10);
        grafo1.insereAresta((int) 'k' - 99,(int) 'e' - 97,10);
        grafo1.insereAresta((int) 'k' - 99,(int) 'h' - 97,20);
    
    }

    private static void criaGrafo2(){
        // vertice 1
        grafo2.insereAresta(1-1, 2-1, 8);
        grafo2.insereAresta(1-1, 3-1, 2);
        grafo2.insereAresta(1-1, 7-1, 9);
        // vertice 2
        grafo2.insereAresta(2-1, 1-1, 8);
        grafo2.insereAresta(2-1, 3-1, 3);
        grafo2.insereAresta(2-1, 4-1, 2);
        grafo2.insereAresta(2-1, 5-1, 7);
        grafo2.insereAresta(2-1, 6-1, 5);
        grafo2.insereAresta(2-1, 8-1, 6);
        // vertice 3
        grafo2.insereAresta(3-1, 1-1, 2);
        grafo2.insereAresta(3-1, 2-1, 3);
        grafo2.insereAresta(3-1, 4-1, 9);
        grafo2.insereAresta(3-1, 7-1, 6);
        // vertice 4
        grafo2.insereAresta(4-1, 2-1, 2);
        grafo2.insereAresta(4-1, 3-1, 9);
        grafo2.insereAresta(4-1, 5-1, 6);
        grafo2.insereAresta(4-1, 7-1, 2);
        // vertice 5
        grafo2.insereAresta(5-1, 2-1, 7);
        grafo2.insereAresta(5-1, 3-1, 6);
        grafo2.insereAresta(5-1, 5-1, 5);
        grafo2.insereAresta(5-1, 7-1, 4);
        // vertice 6
        grafo2.insereAresta(6-1, 2-1, 5);
        grafo2.insereAresta(6-1, 5-1, 5);
        grafo2.insereAresta(6-1, 7-1, 6);
        grafo2.insereAresta(6-1, 8-1, 4);
        // vertice 7
        grafo2.insereAresta(7-1, 1-1, 9);
        grafo2.insereAresta(7-1, 3-1, 6);
        grafo2.insereAresta(7-1, 4-1, 2);
        grafo2.insereAresta(7-1, 5-1, 4);
        grafo2.insereAresta(7-1, 6-1, 6);
        grafo2.insereAresta(7-1, 8-1, 3);
        // vertice 8
        grafo2.insereAresta(8-1, 2-1, 6);
        grafo2.insereAresta(8-1, 6-1, 4);
        grafo2.insereAresta(8-1, 7-1, 3);

    }
    
}
