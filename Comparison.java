import java.util.*;

public class Comparison {

    private static Random random = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        LinkedList<Integer> linked = new LinkedList<>();

        int size = 1_000_000;

        for (int i = 0; i < size; i++) {
            arr.add(i);
            linked.add(i);
        }
        getItemAleatorio(arr, linked);

        /*Complexidade para procurar o primeiro item*/
        getPrimeiroItem(arr, linked);

        /*Complexidade para adicionar item no inicio*/
        putPrimeiroItem(arr, linked);

        /*Complexida para adicionar em indice aleatorio */
        putAleatorio(arr, linked);
        
        /*Complexidade para adicionar item no fim */
        putUltimoItem(arr, linked);

        /*Complexidade para remover o primeiro item */
        removePrimeiroItem(arr, linked);
    }

    public static void getItemAleatorio(ArrayList<Integer> arr, LinkedList<Integer> linked){
        /*
         * 	ArrayList é mais rápido, pois o acesso aleatório é O(1) vs O(n) do LinkedList
         * 
         * arr.get(random)
            Tempo de execução: 0.2115

            linked.get(random)
            Tempo de execução: 2.3373
         */
        medirTempo(() -> {
            System.out.println("arr.get(random)");
            arr.get(random.nextInt(arr.size())); 
        });
        medirTempo(() -> {
            System.out.println("linked.get(random)");
            linked.get(random.nextInt(linked.size())); 
        }); 
    }

    public static void getPrimeiroItem(ArrayList<Integer> arr, LinkedList<Integer> linked){
        /*
         * Ambos muito rápidos, LinkedList é um pouco melhor pois é o primeiro nó
         * 
         * arr.get(0)
            Tempo de execução: 0.1346

            linked.get(0)
            Tempo de execução: 0.0617
         */
        medirTempo(() -> {
            System.out.println("arr.get(0)");
            arr.get(0);
        });
        medirTempo(() -> {
            System.out.println("linked.get(0)");
            linked.get(0); 
        });
    }

    public static void putPrimeiroItem(ArrayList<Integer> arr, LinkedList<Integer> linked){
        /*
        * LinkedList leva vantagem em inserções no início, sendo mais eficiente que ArrayList
        *
        arr.addFirst(random)
        Tempo de execução: 0.3738

        linked.addFirst(random)
        Tempo de execução: 0.0673

        */ 
        medirTempo(() -> {
            System.out.println("arr.addFirst(random)");
            arr.addFirst(random.nextInt());
        });
        medirTempo(() -> {
            System.out.println("linked.addFirst(random)");
            linked.add(random.nextInt()); 
        });
    }

    public static void putUltimoItem(ArrayList<Integer> arr, LinkedList<Integer> linked){
        /*
         * 	Quase igual, inserção no fim é eficiente em ambas
         * 
         *  arr.add(randomIndex, randomNumber)
            Tempo de execução: 0.2079

            linked.add(randomIndex, randomNumber)
            Tempo de execução: 1.1065

         */
        medirTempo(() -> {
            System.out.println("arr.add(random)");
            arr.add(random.nextInt(arr.size())); 
        });
        medirTempo(() -> {
            System.out.println("linked.add(random)");
            linked.add(random.nextInt(linked.size())); 
        });
    }
    
    public static void putAleatorio(ArrayList<Integer> arr, LinkedList<Integer> linked){
        /*
         * Inserir em uma posição aleatória em LinkedList geralmente é
         * mais lento que em ArrayList
         *  
         * arr.add(random)
            Tempo de execução: 0.0684

            linked.add(random)
            Tempo de execução: 0.0776
         */
        medirTempo(() -> {
            System.out.println("arr.add(randomIndex, randomNumber)");
            arr.add(random.nextInt(arr.size()), random.nextInt()); 
        });
        medirTempo(() -> {
            System.out.println("linked.add(randomIndex, randomNumber)");
            linked.add(random.nextInt(linked.size()), random.nextInt()); 
        });
    }

    public static void removePrimeiroItem(ArrayList<Integer> arr, LinkedList<Integer> linked){
        /*
         * LinkedList é muito mais rápido para remover o primeiro elemento (O(1))
         * 
         * arr.remove(0)
            Tempo de execução: 0.2854

            linked.poll()
            Tempo de execução: 0.0554
         */
        medirTempo(() -> {
            System.out.println("arr.remove(0)");
            arr.removeFirst();
        });
        medirTempo(() -> {
            System.out.println("linked.poll()");
            linked.poll();  
        });
    }

    public static void medirTempo(Runnable task){
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println("Tempo de execução: " + (end - start) / 1_000_000.0);
        System.out.println();
    }
}

