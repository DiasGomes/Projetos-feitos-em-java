import java.io.*;

public class Ordenado {
    
    private static int intervalo = 10000;
    private static int ordem = 2;
    public static int contador = 0;
    
    public static void main(String args[]){
        
        try{
            // Criando arquivo de saída
            File arquivo = new File("saida_ordenada.txt");

            // Sobreescrevendo
            if(arquivo.exists()){
                arquivo.delete();
            } 
            OutputStream os = new FileOutputStream(arquivo);
            Writer wr = new OutputStreamWriter(os); 
            BufferedWriter saida = new BufferedWriter(wr);
            // variando ordem
            while(ordem < 8){
                saida.write("Ordem da Árvore: "+ ordem);
                saida.newLine();
                // Variando intervalos
                while(intervalo < 110000){

                    // Criando a árvore
                    ArvoreB myTree = new ArvoreB(ordem);
                    // inserindo elementos ordenados na àrvore
                    for(int i = 0; i < intervalo;i++){
                        myTree.insere(new Item(i));
                    } 

                    // zerando contador
                    contador = 0;
                    // Pesquisando um elemento não existente na árvore
                    myTree.pesquisa(new Item(100001));
                    // Escrevendo no arquivo
                    saida.write("Árvore de: " + intervalo + " elementos");
                    saida.newLine();
                    saida.write("Comparações executadas: "+ contador);
                    saida.newLine();saida.newLine();
                    intervalo += 10000; 
                }
                ordem += 2;
                intervalo = 10000;
            }
            
            // Fechando Arquivo
            saida.close();  

        }        
        catch(IOException e){
            System.out.println("Erro ao abrir/criar arquivo");
        }

    }

}

