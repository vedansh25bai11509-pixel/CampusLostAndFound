import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {

    private final ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<ClaimRequest> claimRequests = new ArrayList<>();

    private int nextId = 1001;

    private static final String FILE_NAME = "data/items.txt";

    public void addItem(Item item) {

        if (item.getId() <= 0) {
            item.setId(nextId++);
        }

        items.add(item);

        if (item.getId() >= nextId) {
            nextId = item.getId() + 1;
        }

        saveData();
    }

    public void showAllItems() {

        if (items.isEmpty()) {
            System.out.println("\nNo items have been reported yet.");
            return;
        }

        System.out.println("\n========== ALL ITEMS ==========");

        for (Item item : items) {
            item.display();
        }
    }

    public void searchItems(Scanner scanner) {

        System.out.println("\n========== SEARCH ITEMS ==========");

        System.out.print("Enter item name, category, or location: ");

        String query = scanner.nextLine().trim().toLowerCase();

        if (query.isEmpty()) {
            System.out.println("Search text cannot be empty.");
            return;
        }

        boolean found = false;

        for (Item item : items) {

            if (item.getItemName().toLowerCase().contains(query)
                    || item.getCategory().toLowerCase().contains(query)
                    || item.getLocation().toLowerCase().contains(query)) {

                item.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo matching items found.");
        }
    }

    public void claimItem(Scanner scanner) {

        System.out.println("\n========== CLAIM FOUND ITEM ==========");

        System.out.print("Enter Item ID to claim: ");

        String input = scanner.nextLine().trim();

        try {

            int id = Integer.parseInt(input);

            Item item = findById(id);

            if (item == null) {

                System.out.println("Item not found.");

            } else if (!item.getType().equals("FOUND")) {

                System.out.println("Only found items can be claimed.");

            } else if (!item.getStatus().equals("AVAILABLE")) {

                System.out.println("This item is no longer available for claiming.");

            } else {

                System.out.print("Enter your name: ");

                String claimant = scanner.nextLine().trim();

                if (claimant.isEmpty()) {

                    System.out.println("Name cannot be empty.");
                    return;
                }

                ClaimRequest request =
                        new ClaimRequest(id, claimant);

                claimRequests.add(request);

                item.setStatus("CLAIM REQUESTED BY " + claimant);

                saveData();

                System.out.println("\nClaim request submitted successfully.");

                request.displayRequest();
            }

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid numeric Item ID.");
        }
    }

    public void markReturned(Scanner scanner) {

        System.out.println("\n========== MARK ITEM AS RETURNED ==========");

        System.out.print("Enter Item ID: ");

        String input = scanner.nextLine().trim();

        try {

            int id = Integer.parseInt(input);

            Item item = findById(id);

            if (item == null) {

                System.out.println("Item not found.");
                return;
            }

            if (item.getStatus().equals("RETURNED")) {

                System.out.println("This item is already marked as returned.");
                return;
            }

            item.setStatus("RETURNED");

            saveData();

            System.out.println("\nItem marked as returned successfully.");

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid numeric Item ID.");
        }
    }

    public void showMyReports(Scanner scanner) {

        System.out.println("\n========== MY REPORTS ==========");

        System.out.print("Enter your name: ");

        String name = scanner.nextLine().trim();

        boolean found = false;

        for (Item item : items) {

            if (item.getReporterName().equalsIgnoreCase(name)) {

                item.display();
                found = true;
            }
        }

        if (!found) {

            System.out.println("No reports found for this name.");
        }
    }

    public void showClaimRequests() {

        System.out.println("\n========== CLAIM REQUESTS ==========");

        if (claimRequests.isEmpty()) {

            System.out.println("No claim requests have been made yet.");
            return;
        }

        for (ClaimRequest request : claimRequests) {

            request.displayRequest();
        }
    }

    public int getTotalItems() {
        return items.size();
    }

    public int getLostItems() {

        int count = 0;

        for (Item item : items) {

            if (item.getType().equals("LOST")) {
                count++;
            }
        }

        return count;
    }

    public int getFoundItems() {

        int count = 0;

        for (Item item : items) {

            if (item.getType().equals("FOUND")) {
                count++;
            }
        }

        return count;
    }

    public int getReturnedItems() {

        int count = 0;

        for (Item item : items) {

            if (item.getStatus().equals("RETURNED")) {
                count++;
            }
        }

        return count;
    }

    private Item findById(int id) {

        for (Item item : items) {

            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public void generateReport() {

        ReportGenerator report = new ReportGenerator();

        report.generateReport(
                getTotalItems(),
                getLostItems(),
                getFoundItems(),
                getReturnedItems()
        );
    }

    public void saveData() {

        File file = new File(FILE_NAME);

        File parent = file.getParentFile();

        if (!parent.exists()) {
            parent.mkdirs();
        }

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(file))) {

            for (Item item : items) {

                writer.println(item.toFileString());
            }

        } catch (IOException e) {

            System.out.println(
                    "Could not save data: " + e.getMessage()
            );
        }
    }

    public void loadData() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                Item item = Item.fromFileString(line);

                if (item != null) {

                    items.add(item);

                    if (item.getId() >= nextId) {

                        nextId = item.getId() + 1;
                    }
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Could not load saved data: " + e.getMessage()
            );
        }
    }
}