package studentpayment;

//PhDTAR.java - PhD Teaching and Research Assistant


public class PhDTAR extends Student {
    private int labHours; // 10 hrs per week
    private int lectureHours; // 3 hrs per week
    private int researchHours; // 7 hours per week

    public PhDTAR(String lastName, String firstName, String address, String id, int labHours, int lectureHours, int researchHours) {
        super(lastName, firstName, address, id);
        this.labHours = (labHours > 10) ? 10 : labHours; // Enforce max 10 hours
        this.lectureHours = (lectureHours > 3) ? 3 : lectureHours; // Enforce max 3 hours
        this.researchHours = (researchHours > 7) ? 7 : researchHours; // Enforce max 7 hours



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

    public int getResearchHours(){
        return researchHours;
    }

    public void setResearchHours(int researchHours){
        this.researchHours = (researchHours > 7) ? 7 : researchHours;
    }


	
    @Override
    public double calculateMonthlyPayment(){
        //4 weeks in a month
        return (labHours + lectureHours + researchHours) * HOURLY_RATE *4;
    }

    @Override
    public String getStudentType(){
        return "PhD Teaching and Research Assistant";

        
    }
}
    

    
