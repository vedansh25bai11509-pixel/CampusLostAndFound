import java.util.Scanner;

public class Main {

    static ItemManager manager = new ItemManager();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        manager.loadData();

        while (true) {

            System.out.println("\n==============================================");
            System.out.println("             CAMPUS LOST & FOUND");
            System.out.println("==============================================");
            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. Search Items");
            System.out.println("4. View All Items");
            System.out.println("5. Claim Found Item");
            System.out.println("6. Mark Item as Returned");
            System.out.println("7. View My Reports");
            System.out.println("8. Student Profile");
            System.out.println("9. View Claim Requests");
            System.out.println("10. Generate Report");
            System.out.println("11. Exit");
            System.out.println("==============================================");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    reportLost(scanner);
                    break;

                case "2":
                    reportFound(scanner);
                    break;

                case "3":
                    manager.searchItems(scanner);
                    break;

                case "4":
                    manager.showAllItems();
                    break;

                case "5":
                    manager.claimItem(scanner);
                    break;

                case "6":
                    manager.markReturned(scanner);
                    break;

                case "7":
                    manager.showMyReports(scanner);
                    break;

                case "8":
                    createProfile(scanner);
                    break;

                case "9":
                    manager.showClaimRequests();
                    break;

                case "10":
                    manager.generateReport();
                    break;

                case "11":
                    manager.saveData();
                    System.out.println("\nThank you for using Campus Lost & Found!");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Please enter 1-11.");
            }
        }
    }

    static void reportLost(Scanner scanner) {

        System.out.println("\n========== REPORT LOST ITEM ==========");

        Item item = InputHelper.readItem(scanner, "LOST");

        manager.addItem(item);

        System.out.println("\nLost item reported successfully.");
        System.out.println("Your Item ID is: " + item.getId());
    }

    static void reportFound(Scanner scanner) {

        System.out.println("\n========== REPORT FOUND ITEM ==========");

        Item item = InputHelper.readItem(scanner, "FOUND");

        manager.addItem(item);

        System.out.println("\nFound item reported successfully.");
        System.out.println("Your Item ID is: " + item.getId());
    }

    static void createProfile(Scanner scanner) {

        System.out.println("\n========== STUDENT PROFILE ==========");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        User user = new User(name, studentId, email);

        System.out.println("\nProfile created successfully!");

        user.displayUser();
    }
}