// Name: Amanda Brock
// Date: May 10, 2026
// Purpose: Creates ArrayList with 10 strings. Uses for-loops, try-catch,
// exceptions, and autoboxing/unboxing.


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ArrayListProgram extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Creates ArrayList for games
        ArrayList<String> games = new ArrayList<>();

        // Add 10 game titles to ArrayList
        games.add("Windrose");
        games.add("Overwatch");
        games.add("Baldur's Gate 3");
        games.add("Clair Obscur: Expedition 33");
        games.add("Enshrouded");
        games.add("Little Nightmares");
        games.add("Ori and the Blind Forest");
        games.add("Where Winds Meet");
        games.add("RV There Yet?");
        games.add("Peak");

        // Creates layout
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));

        Label titleLabel = new Label("Game List:");
        titleLabel.setFont(Font.font("Arial", 18));

        GridPane gameGrid = new GridPane();
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setHgap(15);
        gameGrid.setVgap(12);

        int column = 0;
        int row = 0;

        // Loops through ArrayList and displays each game
        for (String game : games) {
            Label gameLabel = new Label(game);
            gameLabel.setMinSize(200, 32);
            gameLabel.setAlignment(Pos.CENTER);
            gameLabel.setStyle(
                    "-fx-border-color: lightgray;" +
                    "-fx-background-color: #f8f8f8;" +
                    "-fx-font-size: 13px;" +
                    "-fx-border-radius: 6px;" +
                    "-fx-background-radius: 6px;"
            );

            gameGrid.add(gameLabel, column, row);
            column++;

            if (column > 1) {
                column = 0;
                row++;
            }
        }

        // Instructions for user input
        Label instructionLabel = new Label(
                "Enter the index number (0-9) of the game you want to see again:"
        );

        instructionLabel.setFont(Font.font(14));

        TextField inputField = new TextField();
        inputField.setPromptText("Enter index (0-9)");
        inputField.setMaxWidth(250);
        inputField.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-padding: 8px;"
        );

        // Button to display selected game
        Button showButton = new Button("Show Game");
        showButton.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-padding: 6px 18px;"
        );

        Label resultTitle = new Label("Result:");
        resultTitle.setFont(Font.font(16));

        // Label for displaying output/results
        Label resultLabel = new Label("Your result will appear here.");
        resultLabel.setMinSize(320, 40);
        resultLabel.setAlignment(Pos.CENTER);
        resultLabel.setStyle(
                "-fx-border-color: lightgray;" +
                "-fx-background-color: #fafafa;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10px;"
        );

        // Button handler
        showButton.setOnAction(e -> {

            try {

                String userInput = inputField.getText();
                // Autoboxing/unboxing
                Integer selectedIndex = Integer.valueOf(userInput);
                resultLabel.setText(
                        "Selected Game: " + games.get(selectedIndex)
                );

            } catch (IndexOutOfBoundsException ex) {
                // Exception
                resultLabel.setText(
                        "Exception has been thrown: Out of Bounds"
                );

            } catch (NumberFormatException ex) {
                // Exception
                resultLabel.setText(
                        "Invalid input. Please enter a number."
                );
            }
        });

        mainLayout.getChildren().addAll(
                titleLabel,
                gameGrid,
                instructionLabel,
                inputField,
                showButton,
                resultTitle,
                resultLabel
        );


        Scene scene = new Scene(mainLayout, 520, 560);


        primaryStage.setTitle("ArrayList JavaFX Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}