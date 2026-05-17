// Name: Amanda Brock
// Date: May 17, 2026
// Purpose: Creates a domestic division object.

public class DomesticDivision extends Division {

    private String state;

    // Constructor
    public DomesticDivision(String divisionName, int accountNumber,
                            String state) {

        super(divisionName, accountNumber);

        this.state = state;
    }

    // Override display method
    @Override
    public String display() {

        return "Domestic Division\n" +
               "Division Name: " + divisionName + "\n" +
               "Account Number: " + accountNumber + "\n" +
               "State: " + state + "\n";
    }
}