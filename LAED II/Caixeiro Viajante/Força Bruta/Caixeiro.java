import java.io.*;

public class Caixeiro{

    private static String arquivo_nome = "cidades.txt";
    private static int matriz[][] = new int[14][14];
    private static int caminho[] = new int[14];
    private static String conteudo = "";

    public static void main(String[] args){
        // definindo arquivo a ser lido
        if(args.length == 1){
            arquivo_nome = args[0];
        }else{
            System.out.println("Nome do arquivo nao informado, entao 'cidades.txt' sera usado como default");
            arquivo_nome = "cidades.txt";
        }
        // lendo conteudo do arquivo
        try{
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo_nome));
            String [] temp = new String[10];
            for (int i=0; i<13; i++) {
                String linha = leitor.readLine();
                temp = linha.split(" ");
                for (int j=0; j<14; j++){
                    matriz[i][j] = Integer.parseInt(temp[j]);
                }
                    
            }
        }catch(IOException e){
            System.out.println("Erro ao abrir/ler arquivo");
        }
        
        for(int tamanho = 2; tamanho <= 12;tamanho++){
            // mostra a matriz que representa o grafo
            linha();
            System.out.println("Grafo de tamanho: "+ tamanho);
            linha();
            Imprimi(tamanho);
            linha();
            // usando a forca bruta
            for (int i = 1; i <= tamanho; i++){
                caminho[i] = i;
            }
            long start = System.nanoTime();
            int custoMinimo = tspdp(matriz, caminho, 1, tamanho);
            long end = System.nanoTime();
            System.out.print("Solucao otima: ");
            for (int i = 1; i <= tamanho; i++){
                System.out.print(caminho[i] + "->");
            }
            System.out.println("1");
            System.out.println("Tempo gasto: "+ Long.toString(end - start)+"ns");
        }
    } 

// Codigo fonte dessa funcao
// https://acervolima.com/programa-java-para-resolver-o-problema-do-caixeiro-viajante-usando-o-metodo-de-insercao-incremental/
    private static int tspdp(int c[][], int tour[], int start, int n){
  
        int mintour[] = new int[14];
        int temp[] = new int[14];
        int mincost = 999, ccost, i, j, k;
  
        if (start == n - 1){
            return (c[tour[n - 1]][tour[n]] + c[tour[n]][1]);
        }
  
        // Logic for implementing the minimal cost
        for (i = start + 1; i <= n; i++){
  
            for (j = 1; j <= n; j++){
                temp[j] = tour[j];
            }
            
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];
  
            if ((c[tour[start]][tour[i]] + (ccost = tspdp(c, temp, start + 1, n))) < mincost) {
  
                mincost = c[tour[start]][tour[i]] + ccost;
  
                for (k = 1; k <= n; k++){
                    mintour[k] = temp[k];
                }
            }
        }
  
        // Now, iterating over the path (mintour) to
        // compute its cost
        for (i = 1; i <= n; i++){
            tour[i] = mintour[i];
        }
        // Returning the cost of min path
        return mincost;
    }


    private static void Imprimi(int size){
        int i, j;
        for(i = 0; i < size; i++){
            for(j = 0; j < size;  j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void linha(){
        System.out.println("---------------------------------");
    }

}
