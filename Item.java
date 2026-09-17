public class Item {
    private int id;
    private final String type;
    private final String itemName;
    private final String category;
    private final String location;
    private final String date;
    private final String description;
    private final String reporterName;
    private String status;

    public Item(int id, String type, String itemName, String category,
                String location, String date, String description,
                String reporterName, String status) {
        this.id = id;
        this.type = type;
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.date = date;
        this.description = description;
        this.reporterName = reporterName;
        this.status = status;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
    public String getType() { return type; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
    public String getDescription() { return description; }
    public String getReporterName() { return reporterName; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public void display() {
        System.out.println("\n----------------------------------------------");
        System.out.println("Item ID      : " + id);
        System.out.println("Type         : " + type);
        System.out.println("Item         : " + itemName);
        System.out.println("Category     : " + category);
        System.out.println("Location     : " + location);
        System.out.println("Date         : " + date);
        System.out.println("Description  : " + description);
        System.out.println("Reported By  : " + reporterName);
        System.out.println("Status       : " + status);
        System.out.println("----------------------------------------------");
    }

    public String toFileString() {
        return id + "|" + clean(type) + "|" + clean(itemName) + "|" +
               clean(category) + "|" + clean(location) + "|" + clean(date) + "|" +
               clean(description) + "|" + clean(reporterName) + "|" + clean(status);
    }

    private String clean(String value) {
        return value.replace("|", "/");
    }

    public static Item fromFileString(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 9) return null;

        try {
            return new Item(
                Integer.parseInt(p[0]), p[1], p[2], p[3], p[4],
                p[5], p[6], p[7], p[8]
            );
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
