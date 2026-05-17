// Name: Amanda Brock
// Date: May 17, 2026
// Purpose: Creates an international division object.

public class InternationalDivision extends Division {

    private String country;
    private String language;

    // Constructor
    public InternationalDivision(String divisionName, int accountNumber,
                                 String country, String language) {

        super(divisionName, accountNumber);

        this.country = country;
        this.language = language;
    }

    // Override display method
    @Override
    public String display() {

        return "International Division\n" +
               "Division Name: " + divisionName + "\n" +
               "Account Number: " + accountNumber + "\n" +
               "Country: " + country + "\n" +
               "Language: " + language + "\n";
    }
}