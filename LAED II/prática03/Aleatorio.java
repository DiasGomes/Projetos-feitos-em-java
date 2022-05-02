import java.io.*;

public class Aleatorio {
    
    private static int intervalo = 10000;
    private static int ordem = 2;
    public static int contador = 0;
    
    public static void main(String args[]){
        
        try{
            // Criando arquivo de saída
            File arquivo = new File("saida_aleatoria.txt");

            // Sobreescrevendo
            if(arquivo.exists()){
                arquivo.delete();
            } 
            OutputStream os = new FileOutputStream(arquivo);
            Writer wr = new OutputStreamWriter(os); 
            BufferedWriter saida = new BufferedWriter(wr);

            // Variando intervalos
            while(ordem < 8){
                while(intervalo < 110000){
                    saida.write("Ordem da Árvore: "+ ordem);
                    saida.newLine();
                    // Criando a árvore
                    ArvoreB myTree = new ArvoreB(ordem);
                    // inserindo elementos aleatórios na àrvore
                    for(int i = 0; i < intervalo;i++){
                        int rand = (int) (Math.random() * intervalo);
                        myTree.insere(new Item(rand));
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
                ordem+=2;
            }
            
            // Fechando Arquivo
            saida.close();  

        }        
        catch(IOException e){
            System.out.println("Erro ao abrir/criar arquivo");
        }

    }

}

