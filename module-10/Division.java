// Name: Amanda Brock
// Date: May 17, 2026
// Purpose: Abstract Division class for company divisions.

public abstract class Division {

    protected String divisionName;
    protected int accountNumber;

    // Constructor
    public Division(String divisionName, int accountNumber) {
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }

    // Abstract display method
    public abstract String display();
}