public class pratica5 {

    private static XGrafo grafo1, grafo2;

    public static void main(String args[]){
        // criando o primeiro grafo
        grafo1 = new XGrafo(8,12);
        criaGrafo1();

        // criando o segundo grafo
        grafo2 = new XGrafo(10,14);
        criaGrafo2();

        // chegando se ha ciclos no primeiro grafo
        XCiclo ciclo1 = new XCiclo(grafo1);
        //grafo1.imprime();
        if(ciclo1.buscaEmProfundidade())
            System.out.println("Grafo 1 possui Ciclo");
        else 
            System.out.println("Grafo 1 NAO possui Ciclo");
        
        System.out.println();

        // chagando se ha ciclos no segundo grafo
        XCiclo ciclo2 = new XCiclo(grafo2);
        //grafo2.imprime();
        if(ciclo2.buscaEmProfundidade())
            System.out.println("Grafo 2 possui Ciclo");
        else 
            System.out.println("Grafo 2 NAO possui Ciclo");
    }

    private static void criaGrafo1(){
        // vertice 0
        grafo1.insereAresta(0, 1, 1);
        grafo1.insereAresta(0, 3, 1);
        grafo1.insereAresta(0, 4, 1);
        // vertice 1
        grafo1.insereAresta(1, 0, 1);
        grafo1.insereAresta(1, 2, 1);
        grafo1.insereAresta(1, 5, 1);
        // vertice 2
        grafo1.insereAresta(2, 1, 1);
        grafo1.insereAresta(2, 3, 1);
        grafo1.insereAresta(2, 6, 1);
        // vertice 3
        grafo1.insereAresta(3, 0, 1);
        grafo1.insereAresta(3, 2, 1);
        grafo1.insereAresta(3, 7, 1);
        // vertice 4
        grafo1.insereAresta(4, 0, 1);
        grafo1.insereAresta(4, 5, 1);
        grafo1.insereAresta(4, 7, 1);
        // vertice 5
        grafo1.insereAresta(5, 1, 1);
        grafo1.insereAresta(5, 4, 1);
        grafo1.insereAresta(5, 6, 1);
        // vertice 6
        grafo1.insereAresta(6, 2, 1);
        grafo1.insereAresta(6, 5, 1);
        grafo1.insereAresta(6, 7, 1);
        // vertice 7
        grafo1.insereAresta(7, 3, 1);
        grafo1.insereAresta(7, 4, 1);
        grafo1.insereAresta(7, 6, 1);
    }

    private static void criaGrafo2(){
        // vertice 0
        grafo2.insereAresta(0, 1, 1);
        grafo2.insereAresta(0, 2, 1);
        grafo2.insereAresta(0, 3, 1);
        grafo2.insereAresta(0, 5, 1);
        // vertice 1
        grafo2.insereAresta(1, 2, 1);
        // vertice2
        grafo2.insereAresta(2, 3, 1);
        grafo2.insereAresta(2, 4, 1);
        // vertice 4
        grafo2.insereAresta(4, 6, 1);
        // vertice 5
        grafo2.insereAresta(5, 4, 1);
        grafo2.insereAresta(5, 6, 1);
        // vertice 6
        grafo2.insereAresta(6, 7, 1);
        grafo2.insereAresta(6, 8, 1);
        // vertice 7
        grafo2.insereAresta(7, 8, 1);
        // vertice 8 
        // nao se conecta a ninguem
        // vertice 9
        grafo2.insereAresta(9, 6, 1);
    }

    private static void imprimeGrafos(){
        grafo1.imprime();
        System.out.println();
        grafo2.imprime();
    }
    
}
