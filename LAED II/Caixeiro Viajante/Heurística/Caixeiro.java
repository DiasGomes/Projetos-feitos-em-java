import java.io.*;
import java.util.ArrayList;

public class Caixeiro{
    private static String[] arquivo_nome = {"si535.txt", "pa561.txt", "si1032.txt"};
    private static int[] numCidades = {535, 561, 1032};
    private static int matriz[][]  = new int[1032][1032];
    public static void main(String[] args){
        //inicializando matriz
        for(int k = 0; k < 1032; k++){
            for(int h = 0; h < 1032;  h++){
                matriz[k][h] = 0;
            }
        }
        // lendo cada arquivo de uma vez
        for(int i = 0; i < 3; i++){
            // informacoes da saida
            linha();
            System.out.println("Arquivo: "+arquivo_nome[i]);
            System.out.println("Numero de cidades: "+numCidades[i]);
            // lendo conteudo do arquivo especificado
            try{
                BufferedReader leitor = new BufferedReader(new FileReader(arquivo_nome[i]));
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
                if(i == 0){
                    geraMatrizTriangularSuperior(conteudo, numCidades[i]);
                }else{
                    geraMatriz(conteudo);
                }
                // Descobre o caminho
                VizinhoMaisProximo vizinho = new VizinhoMaisProximo(matriz, numCidades[i]);
                imprimiCusto(vizinho);
                linha();
                //fechando leitor
                leitor.close();
            }catch(IOException e){
                System.out.println("Erro ao abrir/ler arquivo");
            }
        }

    }

    private static void imprimiCusto(VizinhoMaisProximo n){
        System.out.println("custo total: "+ n.getCost());
    }

    private static void imprimiCaminho(VizinhoMaisProximo n){
        int[] caminho = n.getPath();
        for(int j = 0; j < caminho.length; j++){
            System.out.print(caminho[j]+" -> ");
        }System.out.println("");
    }

    private static void linha(){
        System.out.println("---------------------------------");
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

    private static void geraMatriz(String conteudo){
        String[] numStr = conteudo.split(" ");
        int x = 0, y = 0;
        for(int l = 0; l < numStr.length;l++){
            try{
                matriz[x][y] = Integer.parseInt(numStr[l]);
                if(numStr[l].equals("0")){
                    x++;
                    y=0;
                }else{
                    y++;
                }
            }catch(NumberFormatException e){
                continue;
            }
        }
    }

    private static void geraMatrizTriangularSuperior(String conteudo, int numCidades){
        
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

    }

}
