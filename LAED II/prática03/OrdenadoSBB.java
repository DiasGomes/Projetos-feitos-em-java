import java.io.*;

public class OrdenadoSBB {
    
    private static int intervalo = 10000;
    public static int contador = 0;
    public static void main(String args[]){
        
        try{
            // Criando arquivo de saída
            File arquivo = new File("saida_SBB_ordenada.txt");

            // Sobreescrevendo
            if(arquivo.exists()){
                arquivo.delete();
            } 
            OutputStream os = new FileOutputStream(arquivo);
            Writer wr = new OutputStreamWriter(os); 
            BufferedWriter saida = new BufferedWriter(wr);

            // Variando intervalos
            while(intervalo <= 100000){

                // Criando a árvore
                ArvoreSBB myTree = new ArvoreSBB();
                // inserindo elementos ordenados na àrvore
                for(int i = 0; i < intervalo;i++){
                    myTree.insere(new Item(i));
                } 

                // zerando contador
                contador = 0;
                // Pesquisando um elemento não existente na árvore
                // e verificando tempo gasto na pesquisa
                long start = System.nanoTime();
                myTree.pesquisa(new Item(110000));
                long end = System.nanoTime();
                // Escrevendo no arquivo
                saida.write("Árvore de: " + intervalo + " elementos");
                saida.newLine();
                saida.write("Tempo gasto na pesquisa: " + Long.toString(end - start) + "ns - Comparações executadas: "+ contador);
                saida.newLine();saida.newLine();
                intervalo += 10000; 
            }
            
            // Fechando Arquivo
            saida.close();  

        }        
        catch(IOException e){
            System.out.println("Erro ao abrir/criar arquivo");
        }

    }

}



