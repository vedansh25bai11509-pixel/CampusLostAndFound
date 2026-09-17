public class ClaimRequest {

    private int itemId;
    private String claimantName;
    private String status;

    public ClaimRequest(int itemId, String claimantName) {
        this.itemId = itemId;
        this.claimantName = claimantName;
        this.status = "PENDING";
    }

    public int getItemId() {
        return itemId;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        status = "APPROVED";
    }

    public void reject() {
        status = "REJECTED";
    }

    public void displayRequest() {
        System.out.println("\n========== CLAIM REQUEST ==========");
        System.out.println("Item ID       : " + itemId);
        System.out.println("Claimant      : " + claimantName);
        System.out.println("Status        : " + status);
        System.out.println("===================================");
    }
}