
import java.util.ArrayList;
import java.util.Random;


/*ArrayList não é tão performático para remover ou adicionar itens no início
 * da estrutura por precisar mover todos os outros, tendo complexidade O(n).
 * Por outro lado, é extremamente rápido para acessos por índices: 0(1)
*/

public class ArrayListComplexity {

    public static Random random = new Random();
    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>();

        /*Ocupando o ArrayList */
        for(int i = 0; i <= 1000000; i++){
            arr.add(i);
        }
        /*Complexidade para procurar um item aleatório*/
        getItemAleatorio(arr);

        /*Complexidade para procurar o primeiro item*/
        getPrimeiroItem(arr);

        /*Complexidade para adicionar item no inicio*/
        putPrimeiroItem(arr);

        /*Complexidade para remover o primeiro item */
        removePrimeiroItem(arr);
    }

    public static void getItemAleatorio(ArrayList<Integer> arr){
        System.out.println("Medindo tempo para arr.get(random)");
        medirTempo(() -> {
            arr.get(random.nextInt(arr.size())); //acesso por índice é O(1) direto.
        });
    }

    public static void getPrimeiroItem(ArrayList<Integer> arr){
        System.out.println("Medindo tempo para arr.get(0)");
        medirTempo(() -> {
            arr.get(0); //O(1)
        });
    }

    public static void putPrimeiroItem(ArrayList<Integer> arr){
        System.out.println("Medindo tempo para arr.add(i)");
        medirTempo(() -> {
            arr.add(random.nextInt()); //0(1)
        });
    }

    public static void removePrimeiroItem(ArrayList<Integer> arr){
        System.out.println("Medindo tempo para arr.remove(0)");
        medirTempo(() -> {
            arr.remove(0); //remover o primeiro elemento exige deslocar todos os elementos, O(n).
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
