
import java.util.LinkedList;
import java.util.Random;


/*LinkedList é mais lento para percorrer a lista acessando índices aleatórios
 * pois percorrer O(n) vezes, consumindo cada vez mais memória de nó em nó
 * Porém, é mais eficar que ArrayList para acessar e adicionar itens no inicio 
 * no fim da estrutura. 
  */

public class LinkedListComplexity {

    public static Random random = new Random();
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        /*Ocupando o LinkedList */
        for(int i = 0; i <= 1000000; i++){
            list.add(i);
        }

        /*Complexidade para procurar um item aleatório*/
        itemAleatorio(list);

        /*Complexidade para procurar o primeiro item*/
        primeiroItem(list);
        
        /*Complexidade para adicionar um item ao primeiro indice*/
        putPrimeiroItem(list);

        /*Complexidade para remover o primeiro item da lista*/
        removePrimeiroItem(list);
    }

    public static void itemAleatorio(LinkedList<Integer> list){
        System.out.println("Medindo tempo para linked.get(random)");
        medirTempo(() -> {
            list.get(random.nextInt(list.size())); //O(n)
        });
    }

    public static void primeiroItem(LinkedList<Integer> list){
        System.out.println("Medindo tempo para linked.get(0)");
        medirTempo(() -> {
            list.get(0); //O(n)
        });
    }

    public static void putPrimeiroItem(LinkedList<Integer> list){
        System.out.println("Medindo tempo para linked.push(i)");
        medirTempo(() -> {
            list.push(random.nextInt());//O(1)
        });
    }

    public static void removePrimeiroItem(LinkedList<Integer> list){
        System.out.println("Medindo tempo para linked.removeFirst(i)");
        medirTempo(() -> {
            list.removeFirst();//O(1)
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
