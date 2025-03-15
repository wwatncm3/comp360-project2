package studentpayment;

//MTA.java - Master's Teaching Assistant
public class MTA extends Student {
    private int labHours; // 10 hrs per week
    private int lectureHours; // 3 hrs per week


    public MTA(String lastName, String firstName, String address, String id, int labHours, int lectureHours) {
        super(lastName, firstName, address, id);
        this.labHours = (labHours > 10) ? 10 : labHours; // Enforce max 10 hours
        this.lectureHours = (lectureHours > 3) ? 3 : lectureHours; // Enforce max 3 hours

    }
    public int getLabHours(){
        return labHours;
    }

    public void setLabHours(int labHours){
        this.labHours = (labHours > 10) ? 10 : labHours;
    }

    public int getLectureHours(){
        return lectureHours;
    }

    public void setLectureHours(int lectureHours){
        this.lectureHours = (lectureHours > 3) ? 3 : lectureHours;
    }
	
    @Override
    public double calculateMonthlyPayment(){
        //4 weeks in a month
        return (labHours + lectureHours) * HOURLY_RATE *4;
    }

    @Override
    public String getStudentType(){
        return "Master's Teaching Assistant";

        
    }

    }

