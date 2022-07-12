import java.io.*;
import java.util.ArrayList;

public class Teste {

    private static String arquivo_nome = "teste2.txt";
    private static int numCidades = 10;
    private static int matriz[][]  = new int[10][10];

    public static void main(String[] args){
        //inicializando matriz
        for(int k = 0; k < 10; k++){
            for(int h = 0; h < 10;  h++){
                matriz[k][h] = 0;
            }
        }
        // lendo cada arquivo de uma vez
        // informacoes da saida
        linha();
        System.out.println("Arquivo: "+arquivo_nome);
        System.out.println("Numero de cidades: "+numCidades);
        // lendo conteudo do arquivo especificado
        try{
                BufferedReader leitor = new BufferedReader(new FileReader(arquivo_nome));
                String conteudo = "";
                String linha = leitor.readLine();
                // cabecalho a ser ignorado
                while(linha.equals("EDGE_WEIGHT_SECTION") == false){
                    linha = leitor.readLine();
                }
                // lendo conteudo de interesse   
                linha = leitor.readLine();
                while(linha.equals("EOF") == false){
                    conteudo += linha;
                    linha = leitor.readLine();
                }
                // criando uma matriz com o conteudo lido
                String[] numStr = conteudo.split(" ");
                ArrayList<Integer> num = new ArrayList<Integer>();

                for(int s = 0; s < numStr.length; s++){
                    try{
                        num.add(Integer.parseInt(numStr[s]));

                    }catch(NumberFormatException e){
                        continue;
                    }
                }
                
                int x = 0, y = 0;
                for(int l = 1; l < num.size();l++){
                    if(num.get(l) == 0){
                        x++;
                        y=x;
                    }else{
                        y++;
                    }
                    matriz[x][y] = num.get(l);
                    
                }
                //fechando leitor
                leitor.close();
            }catch(IOException e){
                System.out.println("Erro ao abrir/ler arquivo");
            }
            // Descobre o caminho
            //imprimiMatriz(matriz, numCidades);
            VizinhoMaisProximo vizinho = new VizinhoMaisProximo(matriz, numCidades);
            //NearestNeighbor vizinho = new NearestNeighbor(matriz,1);
            imprimiCusto(vizinho);
            imprimiCaminho(vizinho);
            linha();
    }

    private static void imprimiCusto(VizinhoMaisProximo n){
        System.out.println("custo total: "+ n.getCost());
    }

    private static void linha(){
        System.out.println("---------------------------------");
    }

    private static void imprimiCaminho(VizinhoMaisProximo n){
        int[] caminho = n.getPath();
        for(int j = 0; j < caminho.length; j++){
            System.out.print(caminho[j]+" -> ");
        }System.out.println("1");

    }

    private static void imprimiMatriz(int[][] m, int size){
        int i, j;
        linha();
        for(i = 0; i < size; i++){
            for(j = 0; j < size;  j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        linha();
    }
    
}
