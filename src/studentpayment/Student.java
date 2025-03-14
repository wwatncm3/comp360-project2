package studentpayment;

public class Student {
    // Attributes for all Students
    protected String lastName;
    protected String firstName;
    protected String address;
    protected String id;
    protected final double HOURLY_RATE = 20.0;
    
    // Constructor
    public Student(String lastName, String firstName, String address, String id) {
        this.lastName =lastName;
        this.firstName = firstName;
        this.address = address;
        this.id = id;
    }

    // Getters & Setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =lastName;
    }

    public String getFirstName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName =firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id =id;
    }

    // Monthly Payment Calculation Method
    public double calculateMonthlyPayment() {
        return 0.0;
    }

    // Nine Month Payment Calculation Method
    public double calculateNineMonthPayment(){
        return calculateMonthlyPayment() * 9;

    }

    // method overlloding
    public String getStudentInfo(){
        return "Name: " + firstName + " " + lastName + "\nID: " + id + "\nAddress: " + address;
    }

    public String getStudentInfo(boolean includePayment) {
        if (includePayment) {
            return getStudentInfo() + "\nMonthly Payment: $" + String.format("%.2f", calculateMonthlyPayment());
        } else {
            return getStudentInfo();
        }
    }

    //Method to get student type as a string
    public String getStudentType(){
        return "Student";

    
    }

}
