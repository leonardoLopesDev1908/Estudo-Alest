
import java.util.Random;
import java.util.TreeSet;

public class TreeSetComplexity{

    private static Random random = new Random();
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();

        for(int i = 0; i < 1000000; i++){
            tree.add(i);
        }

        
        putItem(tree);

        getFirst(tree);
    }

    public static void putItem(TreeSet<Integer> tree){
        medirTempo(() -> {
            System.out.println("Medindo tree.add(random)");
            tree.add(random.nextInt());
        });
    }

    public static void getFirst(TreeSet<Integer> tree){
        medirTempo(() -> {
            System.out.println("Medindo tree.pollFirst()");
            tree.pollFirst();
        });
    }

    public static void medirTempo(Runnable task){
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println("Tempo de execução: " + (end - start) / 1_000_000.0);
    }
}