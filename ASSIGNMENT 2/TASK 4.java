import java.util.*;

public class PharmacyInventory {
    public static void main(String[] args) {
        Map<String, Integer> stockLookup = new HashMap<>();
        stockLookup.put("MED101", 150);
        stockLookup.put("MED105", 80);
        stockLookup.put("MED102", 200);

        System.out.println("Fast Stock Lookup MED102: " + stockLookup.get("MED102") + " units");

        Map<String, Integer> codeOrderedReport = new TreeMap<>(stockLookup);
        System.out.println("\n--- Daily Code-Ordered Inventory Report ---");
        for (Map.Entry<String, Integer> entry : codeOrderedReport.entrySet()) {
            System.out.println("Medicine Code: " + entry.getKey() + " | Quantity: " + entry.getValue());
        }

        Map<String, Integer> arrivalReport = new LinkedHashMap<>();
        arrivalReport.put("MED101", 150);
        arrivalReport.put("MED105", 80);
        arrivalReport.put("MED102", 200);

        System.out.println("\n--- Chronological Addition Inventory Report ---");
        for (Map.Entry<String, Integer> entry : arrivalReport.entrySet()) {
            System.out.println("Medicine Code: " + entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }
}
