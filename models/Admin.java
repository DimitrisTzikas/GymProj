package gymproj.models;

public class Admin{

    // Attributes
    private String recruitmentDate;
    private Account account;
    // End Attributes

    // Constructors
    public Admin(String recruitmentDate, Account account){
        this.recruitmentDate = recruitmentDate;
        this.account = account;
    }
    // End Constructors

    // Methods
    public String getRecruitmentDate(){return this.recruitmentDate;}
    public Account getAccount(){return this.account;}
    // End Methods

}
