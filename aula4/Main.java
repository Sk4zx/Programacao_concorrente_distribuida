package aula4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer numExec = 0;
        while (true) {
            Counter counter = new Counter(0);

            Incrementer inc1 = new Incrementer(counter);
            Incrementer inc2 = new Incrementer(counter);
            Incrementer inc3 = new Incrementer(counter);
            Incrementer inc4 = new Incrementer(counter);

            inc1.start();
            inc2.start();
            inc3.start();
            inc4.start();

            inc1.join();
            inc2.join();
            inc3.join();
            inc4.join();
            
            numExec++;
            if (counter.getValue() != 4) {
                System.out.println("numero de execuções: " + numExec);
                System.out.println("valor final do contador: " + counter.getValue());
                break;
            }

            System.out.println("Valor final do contador:" + counter.getValue());
        }
    }
}
