/**
* Esse codigo eh uma adaptação da Classe NearestNeighbor criada por @author simasware
* O codigo original pode ser encontrado em:
* https://simasware.wordpress.com/2013/07/04/implementacao-do-algoritmo-vizinho-mais-proximo-nearest-neighbor/
*/

public class VizinhoMaisProximo {

    private int[] path; 
    private int cost;
    private final int inicio = 0;
     
    public VizinhoMaisProximo(final int[][] matriz, int tamanho) {
        // inicia o caminho e o custo
        path = new int[tamanho];
        cost = 0; 
        // inicia caminho com infinito
        for (int i = 0; i < path.length; i++){
            path[i] = Integer.MAX_VALUE;
        }
        
        path[0] = inicio;
        int currentCity = inicio;
     
        
        for(int i = 1; i < tamanho; i++) {
            // encontra o vizinho mais proximo para a cidade em questao
            int nextCity = findMin(matriz[currentCity]);
            // confere se nao passou pela cidade
            if (nextCity != -1) {
                path[i] = nextCity;
                currentCity = nextCity;
            }
        }
    }
     
    // encontra o vizinho mais proximo daquela cidade
    private int findMin(int[] row) {
        int proximaCidade = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row.length; i++){
            //System.out.print(row[i]+" ");
            if (row[i] < min && !isCityInPath(path, i) && row[i] > 0) {
                if(row[i] > 0){
                    min = row[i];
                    proximaCidade = i;
                }
            }
        }
        //System.out.println("min: "+min);
        if(proximaCidade != -1){
            cost += min;
        }
        return proximaCidade;
    }
     
    // retorna o caminho
    public int[] getPath() {
        return path;
    }

    // retorna o custo
    public int getCost(){
        return cost;
    }
     
    public boolean isCityInPath(int[] path, int city) {
        for (int i = 0; i < path.length; i++) {
            if (path[i] == city) {
                return true;
            }
        }
        return false;
    }
    
}
