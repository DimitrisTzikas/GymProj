package gymproj.models;

import java.util.ArrayList;

public class Gym{

    // Attributes
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String afm;
    private ArrayList<Account> accounts;
    private ArrayList<GymProgram> gymPrograms;
    // End Attributes

    // Constructors
    public Gym(String name, String address, String phoneNumber, String email, String afm){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.afm = afm;
        accounts = new ArrayList();
        gymPrograms = new ArrayList();
    }
    // End Constructors

    // Methods
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public String getEmail(){return this.email;}
    public String getAfm(){return this.afm;}
    public void addAccount(Account account){this.accounts.add(account);}
    public void addGymProgram(GymProgram gymProgram){this.gymPrograms.add(gymProgram);}
    // End Methods

}
