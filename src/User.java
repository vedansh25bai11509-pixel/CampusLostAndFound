public class User {

    private String name;
    private String studentId;
    private String email;

    public User(String name, String studentId, String email) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public void displayUser() {
        System.out.println("\n========== USER PROFILE ==========");
        System.out.println("Name       : " + name);
        System.out.println("Student ID : " + studentId);
        System.out.println("Email      : " + email);
        System.out.println("==================================");
    }
}