import java.util.Scanner;

public class InputHelper {
    public static Item readItem(Scanner scanner, String type) {
        String name = readRequired(scanner, "Enter your name: ");
        String itemName = readRequired(scanner, "Enter item name: ");
        String category = readRequired(scanner, "Enter category: ");
        String location = readRequired(scanner, "Where was it lost/found? ");
        String date = readRequired(scanner, "Enter date (DD-MM-YYYY): ");
        String description = readRequired(scanner, "Enter description: ");

        return new Item(
            0,
            type,
            itemName,
            category,
            location,
            date,
            description,
            name,
            type.equals("FOUND") ? "AVAILABLE" : "OPEN"
        );
    }

    private static String readRequired(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty. Please try again.");
        }
    }
}
