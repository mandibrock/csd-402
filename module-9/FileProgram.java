// Name: Amanda Brock
// Date: May 10, 2026
// Purpose: Creates a new file if not created already, adds/appends 10 random
// numbers to file, reads the data, displays it.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FileProgram extends Application {

    @Override
    public void start(Stage stage) {

        // Creates layout
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));

        // Title
        Label titleLabel = new Label("Random Number File Generator");
        titleLabel.setFont(Font.font("Arial", 18));

        // Description
        Label descriptionLabel =
                new Label("Generate and store random numbers in data.file");
        descriptionLabel.setFont(Font.font(13));

        // Button
        Button generateButton = new Button("Generate Numbers");
        generateButton.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-padding: 8px 18px;"
        );

        // Text area for output
        TextArea outputArea = new TextArea();

        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setMaxWidth(300);
        outputArea.setPrefHeight(220);

        outputArea.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-border-color: lightgray;" +
                "-fx-control-inner-background: #fafafa;"
        );

        // Button click handler
        generateButton.setOnAction(event -> {
            outputArea.clear();
            File file = new File("data.file");
            // Random number gen
            Random random = new Random();

            // Create file if it doesn't exist
            try {
                if (file.createNewFile()) {
                    outputArea.appendText(
                            "File created: " +
                            file.getName() +
                            "\n\n"
                    );
                } else {
                    outputArea.appendText(
                            "File already exists. Appending data.\n\n"
                    );
                }

                // Open file for appending data
                FileWriter writer = new FileWriter(file, true);
                outputArea.appendText("Writing random numbers:\n");

                // Generate/write 10 numbers
                for (int i = 0; i < 10; i++) {
                    int randomNumber = random.nextInt(100);
                    writer.write(randomNumber + " ");
                    outputArea.appendText(randomNumber + " ");
                }

                writer.write("\n");
                writer.close();
                outputArea.appendText("\n\nReading file contents:\n");
                Scanner scanner = new Scanner(file);

                // Display each line from file
                while (scanner.hasNextLine()) {
                    outputArea.appendText(
                            scanner.nextLine() + "\n"
                    );
                }

                scanner.close();

            } catch (IOException e) {
               // Error handling
                outputArea.appendText("An error occurred.\n");
                outputArea.appendText(e.getMessage());
            }
        });

        layout.getChildren().addAll(
                titleLabel,
                descriptionLabel,
                generateButton,
                outputArea
        );

        Scene scene = new Scene(layout, 520, 360);

        stage.setTitle("JavaFX File Program");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}