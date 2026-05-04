//
// Name: Amanda Brock
// Date: 05/02/2026
// Purpose: JavaFX app that collects integers into an ArrayList
// and returns the largest value.
//

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AmandaArrayListTest extends Application {

    private ArrayList<Integer> numbers = new ArrayList<>();
    private TextArea displayArea;
    private Label resultOutput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // UI 
        Label instructionLabel = new Label("Enter integers (0 to finish):");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter a number");
        inputField.setMaxWidth(Double.MAX_VALUE);

        Button addButton = new Button("Add Number");
        Button maxButton = new Button("Find Largest");
        Button resetButton = new Button("Reset");

        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefHeight(150);
        displayArea.setMaxWidth(Double.MAX_VALUE);

        Label resultLabel = new Label("Largest Value:");
        resultOutput = new Label("");

        // layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setHgrow(Priority.ALWAYS);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();

        grid.getColumnConstraints().addAll(col0, col1, col2, col3);

        grid.add(instructionLabel, 0, 0);

        grid.add(inputField, 0, 1);
        grid.add(addButton, 1, 1);
        grid.add(maxButton, 2, 1);
        grid.add(resetButton, 3, 1);

        grid.add(new Label("Numbers Entered:"), 0, 2);
        grid.add(displayArea, 0, 3, 4, 1);

        grid.add(resultLabel, 0, 4);
        grid.add(resultOutput, 1, 4);

        // enter key support
        inputField.setOnAction(e -> addNumber(inputField, addButton));

        // add button
        addButton.setOnAction(e -> addNumber(inputField, addButton));

        // max button
        maxButton.setOnAction(e -> {
            Integer largest = max(numbers);
            resultOutput.setText(String.valueOf(largest));
        });

        // reset button
        resetButton.setOnAction(e -> {
            numbers.clear();
            displayArea.clear();
            resultOutput.setText("");

            inputField.setDisable(false);
            addButton.setDisable(false);

            inputField.clear();
            inputField.requestFocus();
        });

        // Scene
        Scene scene = new Scene(grid, 500, 320);
        stage.setTitle("ArrayList Max Finder");
        stage.setScene(scene);
        stage.show();
    }

    // method for adding numbers
    private void addNumber(TextField inputField, Button addButton) {
        try {
            int value = Integer.parseInt(inputField.getText());
            numbers.add(value);

            displayArea.appendText(value + "\n");
            inputField.clear();

            if (value == 0) {
                inputField.setDisable(true);
                addButton.setDisable(true);

                Integer largest = max(numbers);
                resultOutput.setText(String.valueOf(largest));
            }

        } catch (NumberFormatException ex) {
            displayArea.appendText("Invalid input. Please enter an integer.\n");
            inputField.clear();
        }
    }

    // method signature
    public static Integer max(ArrayList list) {

        if (list == null || list.size() == 0) {
            return 0;
        }

        Integer max = (Integer) list.get(0);

        for (Object obj : list) {
            Integer num = (Integer) obj;

            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}