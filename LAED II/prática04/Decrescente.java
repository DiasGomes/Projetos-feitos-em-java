import java.io.*;

public class Decrescente {
    
    private static int intervalo = 10000;
    public static int contador = 0;
    
    public static void main(String args[]){
        
        try{
            // Criando arquivo de saída
            File arquivo = new File("saida_decrescente.txt");

            // Sobreescrevendo
            if(arquivo.exists()){
                arquivo.delete();
            } 
            OutputStream os = new FileOutputStream(arquivo);
            Writer wr = new OutputStreamWriter(os); 
            BufferedWriter saida = new BufferedWriter(wr);

            // Variando intervalos
            while(intervalo < 110000){
                // criando um vetor temporario
                Item vetor[] = new Item[intervalo+1];
                // inserindo elementos ordenados crescentes no vetor
                for(int i = intervalo; i >= 0; i--){
                    vetor[i] = new Item(i);
                } 
                // zerando contador
                contador = 0;
                // Ordenando o vetor
                HeapSort.heapsort(vetor, intervalo);
                // Escrevendo no arquivo
                saida.write("Árvore de: " + intervalo + " elementos");
                saida.newLine();
                saida.write("Comparações executadas: "+ contador);
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


