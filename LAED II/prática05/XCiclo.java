/*
 * Um grafo possui ciclo se apresentar uma ARESTA DE RETORNO
 * Aresta de retorno: conecta um vertice u com um antecessor v
 *  em uma arvore de busca em profundidade
 */

public class XCiclo {

  public static final byte branco = 0;
  public static final byte cinza  = 1;
  public static final byte preto  = 2;
  private int d[], t[], antecessor[];
  private XGrafo grafo;
  private boolean ciclo;

  public XCiclo (XGrafo grafo) {
    this.grafo = grafo; 
    int n = this.grafo.numVertices();
    d = new int[n]; 
    t = new int[n]; 
    ciclo = false;
    antecessor = new int[n];
  }

  private int visitaDfs (int u, int tempo, int cor[]) {
    // recebe cinza por ter sido visitado
    cor[u] = cinza; 
    // tempo de descoberta
    this.d[u] = ++tempo;
    //System.out.println ("Visita "+u+" Descoberta:"+this.d[u]+" cinza");
    if (!this.grafo.listaAdjVazia (u)) {
      XGrafo.Aresta a = this.grafo.primeiroListaAdj (u);
      while (a != null) {
        // recebe vertice adjacente
        int v = a.v2 ();
        // se for branco segue a busca
        if (cor[v] == branco) {
          this.antecessor[v] = u;
          tempo = this.visitaDfs (v, tempo, cor);
        }else if(cor[v] == cinza){
          // Aresta de Retorno
          ciclo = true;
        }
        a = this.grafo.proxAdj (u);
      }
    }
    cor[u] = preto; 
    this.t[u] = ++tempo;
    //System.out.println ("Visita " +u+ " Termino:" +this.t[u]+ " preto");
    return tempo;
  }
  // executa a busca em profundidade
  public boolean buscaEmProfundidade () {
    int tempo = 0; 
    int cor[] = new int[this.grafo.numVertices ()]; 
    // inicializa todos os vertices como brancos e sem antecessores
    for (int u = 0; u < grafo.numVertices (); u++) {
      cor[u] = branco; 
      this.antecessor[u] = -1;
    }  
    // faz a busca pelos vertices adjacentes   
    for (int u = 0; u < grafo.numVertices (); u++)
      if (cor[u] == branco) {
        tempo = this.visitaDfs (u, tempo, cor);
      }

      return ciclo;
  }
  // retorna tempo de descoberta
  public int d (int v) { return this.d[v]; }
  // retorna tempo de termino
  public int t (int v) { return this.t[v]; }
  // retorna vertice antecessor
  public int antecessor (int v) { return this.antecessor[v]; }

}