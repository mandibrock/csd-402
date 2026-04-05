// Amanda Brock
// April 5, 2026
// Assignment 2.2
// Purpose: This program lets the user play Rock-Paper-Scissots against
// the computer using JavaFX.
//
// It also drove me insane for 3 days. I cried. A lot.
// VS Code hated everything about JavaFX and it took a lot of 
// researching to get it to run properly. ;_;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

// Runs the game using JavaFX
public class Rpsgame extends Application {

    // Launches JavaFX
    public static void main(String[] args) {
        launch(args);
    }

    // Sets up the entire UI and game interaction
    @Override
    public void start(Stage stage) {

        // Title at top
        Label title = new Label("Rock Paper Scissors");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Instructions for the game
        Label instructions = new Label("Enter 1 (Rock), 2 (Paper), or 3 (Scissors):");

        // Input box
        TextField inputField = new TextField();
        inputField.setMaxWidth(120);

        // Play button
        Button playButton = new Button("Play");
        playButton.setPrefWidth(120);

        // Results section 
        VBox resultBox = new VBox(5);
        resultBox.setAlignment(Pos.CENTER);

        Label userLabel = new Label();
        Label compLabel = new Label();

        // Final results
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Region spacer = new Region();
        spacer.setMinHeight(10);

        resultBox.getChildren().addAll(userLabel, compLabel, spacer, resultLabel);

        // Things that happen when the user clicks play
        playButton.setOnAction(e -> {
            try {
                // Turn input into number
                int userChoice = Integer.parseInt(inputField.getText());

                // Make sure number is valid
                if (userChoice < 1 || userChoice > 3) {
                    resultLabel.setText("Enter 1, 2, or 3.");
                    return;
                }

                // Get computers choice / figure out who won
                int computerChoice = getComputerChoice();
                String result = determineWinner(userChoice, computerChoice);

                // Show both choices
                userLabel.setText("You chose: " + choiceToString(userChoice) + " (" + userChoice + ")");
                compLabel.setText("Computer chose: " + choiceToString(computerChoice) + " (" + computerChoice + ")");

                // Display results
                if (result.equals("win")) {
                    resultLabel.setText("YOU WIN.");
                } else if (result.equals("lose")) {
                    resultLabel.setText("YOU LOSE.");
                } else {
                    resultLabel.setText("IT'S A TIE.");
                }

                inputField.clear();

            } catch (Exception ex) {
                // If input is invalid, catch it here
                resultLabel.setText("Please enter 1, 2, or 3.");
            }
        });

        // Main lauout that stacks everything vertically
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        layout.getChildren().addAll(
                title,
                instructions,
                inputField,
                playButton,
                resultBox
        );

        // Create window for the scene and set its size
        Scene scene = new Scene(layout, 360, 260);

        // Sets up the stage
        stage.setTitle("Rock Paper Scissors");
        stage.setScene(scene);
        stage.show();
    }

    // Randomly generate computers choice
    public int getComputerChoice() {
        return new Random().nextInt(3) + 1;
    }

    // Determine the winner
    public String determineWinner(int user, int comp) {
        if (user == comp) return "tie";

        if ((user == 1 && comp == 3) ||
            (user == 2 && comp == 1) ||
            (user == 3 && comp == 2)) {
            return "win";
        }

        return "lose";
    }

    // Convert number to text
    public String choiceToString(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Invalid";
        }
    }
}