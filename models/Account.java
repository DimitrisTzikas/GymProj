package gymproj.models;

public class Account{

    // Attributes
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private String registrationDate;
    // End Attributes

    // Constructors
    public Account(String name, String surname, String phoneNumber, String email, String username, String password, String registrationDate){
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }
    // End Constructors

    // Methods
    public String getName(){return this.name;}
    public String getSurname(){return this.surname;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public String getEmail(){return this.email;}
    public String getUsername(){return this.username;}
    public String getRegistrationDate(){return this.registrationDate;}
    // End Methods

}
