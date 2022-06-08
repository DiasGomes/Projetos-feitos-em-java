public class XAGM {

  private int antecessor[];
  private double p[];
  private XGrafo grafo;

  public XAGM (XGrafo grafo) { this.grafo = grafo; }  

  public void obterAgm (int raiz) throws Exception {
      
    int n = this.grafo.numVertices();
    this.p = new double[n]; // peso dos vertices
    int vs[] = new int[n+1]; // vertices
    boolean itensHeap[] = new boolean[n];
    this.antecessor = new int[n];
    // inicializa antecessores, pesos e vertices
    for (int u = 0; u < n; u ++) {
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE; // infinito
      vs[u+1] = u; // Heap indireto a ser construido
      itensHeap[u] = true;
    }

    p[raiz] = 0;
    // constroi heap
    Heap heap = new Heap (p, vs); 
    heap.constroi ();
    // enquanto houver elementos na heap
    while (!heap.vazio ()) {
      int u = heap.retiraMin (); 
      itensHeap[u] = false;
      // enquanto houver adjacencias
      if (!this.grafo.listaAdjVazia (u)) {
        XGrafo.Aresta adj = grafo.primeiroListaAdj (u);
        while (adj != null) {
          int v = adj.v2 ();
          if (itensHeap[v] && (adj.peso () < this.peso (v))) {
            // novo antecessor com peso de aresta menor
            antecessor[v] = u; 
            // o heap vai ter de ser refeito
            heap.diminuiChave (v, adj.peso ());
          }
          adj = grafo.proxAdj (u);
        }
      }
    }
  }

  public int antecessor (int u) { return this.antecessor[u]; }

  public double peso (int u) { return this.p[u]; }

  public void imprime () {
    for (int u = 0; u < this.p.length; u++)
      if (this.antecessor[u] != -1) 
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" + peso (u));
  }

}
