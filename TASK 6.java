import java.util.*;

public class TriageSystem {
    public static class Patient {
        private final String name;
        private final int severity;
        private final long sequenceNumber;

        public Patient(String name, int severity, long sequenceNumber) {
            this.name = name;
            this.severity = severity;
            this.sequenceNumber = sequenceNumber;
        }

        @Override
        public String toString() {
            return name + "(S" + severity + ")";
        }
    }

    public static void main(String[] args) {
        Comparator<Patient> triageComparator = Comparator
            .comparingInt((Patient p) -> p.severity)
            .thenComparingLong(p -> p.sequenceNumber);

        PriorityQueue<Patient> queue = new PriorityQueue<>(triageComparator);
        long counter = 0;

        queue.add(new Patient("Ravi", 3, counter++));
        queue.add(new Patient("Meena", 1, counter++));
        queue.add(new Patient("John", 3, counter++));
        queue.add(new Patient("Asha", 5, counter++));
        queue.add(new Patient("Kumar", 1, counter++));
        queue.add(new Patient("Lata", 2, counter++));

        System.out.print("Treatment Order: ");
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            order.append(queue.poll()).append(" ");
        }
        System.out.println(order.toString().trim());
    }
}
