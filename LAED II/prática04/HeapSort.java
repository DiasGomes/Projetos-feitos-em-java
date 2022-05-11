public class HeapSort {

    public static void heapsort (Item v[], int n){
        // Usa a classe Heap
        Heap heap = new Heap(v);
        int dir = n;
        // constroi o heap
        heap.constroi();
        // ordena o vetor 
        while(dir > 1){ 
            Item x = v[1];
            v[1] = v[dir];
            v[dir] = x;
            dir--;
            heap.refaz(1 ,dir);
        }
    }

}
