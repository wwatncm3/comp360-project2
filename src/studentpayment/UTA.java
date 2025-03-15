//UTA.java - Undergraduate Teaching Assistant
package studentpayment;
public class UTA extends Student {
    private int labHours; // Max  10 hrs per week

    public UTA(String lastName, String firstName, String address, String id, int labHours) {
        super(lastName, firstName, address, id);
        this.labHours = (labHours > 10) ? 10 : labHours; // Enforce max 10 hours

    }
    public int getLabHours(){
        return labHours;
    }

    public void setLabHours(int labHours){
        this.labHours = (labHours > 10) ? 10 : labHours;
    }
	
    @Override
    public double calculateMonthlyPayment(){
        //4 weeks in a month
        return labHours * HOURLY_RATE *4;
    }

    @Override
    public String getStudentType(){
        return "Undergraduate Teaching Assistant";


    }
}
