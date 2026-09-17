public class ReportGenerator {

    public void generateReport(int totalItems, int lostItems, int foundItems, int returnedItems) {

        System.out.println("\n==========================================");
        System.out.println("       CAMPUS LOST & FOUND REPORT");
        System.out.println("==========================================");
        System.out.println("Total Reports    : " + totalItems);
        System.out.println("Lost Items       : " + lostItems);
        System.out.println("Found Items      : " + foundItems);
        System.out.println("Returned Items   : " + returnedItems);
        System.out.println("==========================================");
    }
}