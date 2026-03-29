// Amanda Brock
// March 29, 2026
// Assignment 1.3
// Purpose: This program calculates the amount of energy (in Joules)
// needed to heat water based on user input.


import javax.swing.JOptionPane; // for pop-up dialogs

public class WaterEnergyCalculator {
    public static void main(String[] args) {

        try {
            // get inputs and convert them to numbers
            double waterMass = Double.parseDouble(
                JOptionPane.showInputDialog("Enter the amount of water in kilograms:")
            );

            double initialTemp = Double.parseDouble(
                JOptionPane.showInputDialog("Enter the initial temperature (in Celsius):")
            );

            double finalTemp = Double.parseDouble(
                JOptionPane.showInputDialog("Enter the final temperature (in Celsius):")
            );

            // calculate energy using the formula
            double Q = waterMass * (finalTemp - initialTemp) * 4184;

            // format with commas and 2 decimal places
            String result = String.format("%,.2f", Q);

            // display result
            JOptionPane.showMessageDialog(
                null,
                "Energy Needed:\n" + result + " Joules"
            );

        } catch (NumberFormatException e) {
            // this runs if the user types something that isn’t a number
            JOptionPane.showMessageDialog(
                null,
                "Invalid input. Please enter numbers only."
            );
        }
    }
}