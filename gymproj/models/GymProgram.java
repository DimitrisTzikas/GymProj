package gymproj.models;

public class GymProgram{

    // Attributes
    private String title;
    private String day;
    private String hour;
    private String category;
    private float cost;
    // End Attributes

    // Constructors
    public GymProgram(String title, String day, String hour, String category, float cost){
        this.title = title;
        this.day = day;
        this.hour = hour;
        this.category = category;
        this.cost = cost;
    }
    // End Constructors

    // Methods
    public String getTitle(){return this.title;}
    public String getDay(){return this.day;}
    public String getHour(){return this.hour;}
    public String getCategory(){return this.category;}
    public float getCost(){return this.cost;}

    public String toString(){
        return this.title + "\n"
            + this.day + "\n"
            + this.hour + "\n"
            + this.category + "\n"
            + this.cost + "\n";
    }
    // End Methods

}
