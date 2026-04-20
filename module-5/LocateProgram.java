// Amanda Brock
// April 19, 2026
// Purpose: Displays arrays in a grid and highlights the largest and smallest values
// using the ArrayLocator class.

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LocateProgram extends Application {

    @Override
    public void start(Stage stage) {

        double[][] doubleArray = {
                {3.5, 2.1, 9.8},
                {4.4, 1.0, 7.2},
                {6.6, 8.3, 5.5}
        };

        int[][] intArray = {
                {3, 2, 9},
                {4, 7, 6},
                {1, 8, 5}
        };

        int[] largestDouble = ArrayLocator.locateLargest(doubleArray);
        int[] smallestDouble = ArrayLocator.locateSmallest(doubleArray);

        int[] largestInt = ArrayLocator.locateLargest(intArray);
        int[] smallestInt = ArrayLocator.locateSmallest(intArray);

        // Create grids 
        GridPane doubleGrid = createGrid(doubleArray, largestDouble, smallestDouble);
        GridPane intGrid = createGrid(intArray, largestInt, smallestInt);

        // Titles
        Label doubleTitle = new Label("Double Array");
        doubleTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Label intTitle = new Label("Int Array");
        intTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        // Double results
        Label doubleResultsHeader = new Label("Results");
        doubleResultsHeader.setStyle("-fx-font-weight: bold;");

        Label doubleResults = new Label(
                "Largest: (" + largestDouble[0] + ", " + largestDouble[1] + ")\n" +
                "Smallest: (" + smallestDouble[0] + ", " + smallestDouble[1] + ")"
        );

        VBox doubleRight = new VBox(5, doubleResultsHeader, doubleResults);
        doubleRight.setStyle(
                "-fx-padding: 10;" +
                "-fx-border-color: lightgray;" +
                "-fx-border-radius: 5;"
        );
        doubleRight.setMaxWidth(150);

        // Int results
        Label intResultsHeader = new Label("Results");
        intResultsHeader.setStyle("-fx-font-weight: bold;");

        Label intResults = new Label(
                "Largest: (" + largestInt[0] + ", " + largestInt[1] + ")\n" +
                "Smallest: (" + smallestInt[0] + ", " + smallestInt[1] + ")"
        );

        VBox intRight = new VBox(5, intResultsHeader, intResults);
        intRight.setStyle(
                "-fx-padding: 10;" +
                "-fx-border-color: lightgray;" +
                "-fx-border-radius: 5;"
        );
        intRight.setMaxWidth(150);

        // Rows 
        HBox doubleRow = new HBox(15,
                new VBox(10, doubleTitle, doubleGrid),
                doubleRight
        );
        doubleRow.setAlignment(Pos.TOP_LEFT);

        HBox intRow = new HBox(15,
                new VBox(10, intTitle, intGrid),
                intRight
        );
        intRow.setAlignment(Pos.TOP_LEFT);

        // Main layout
        VBox root = new VBox(15, doubleRow, intRow);
        root.setAlignment(Pos.TOP_LEFT);
        root.setStyle("-fx-padding: 15;");

        Scene scene = new Scene(root);
        stage.setTitle("Array Locator");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // Double grid (colors for results)
    private GridPane createGrid(double[][] array, int[] largest, int[] smallest) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                Label cell = new Label(String.valueOf(array[i][j]));
                cell.setMinWidth(50);
                cell.setAlignment(Pos.CENTER);

                if (i == largest[0] && j == largest[1]) {
                    cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: #b6fcb6;");
                } 
                else if (i == smallest[0] && j == smallest[1]) {
                    cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: #fcb6b6;");
                } 
                else {
                    cell.setStyle("-fx-border-color: black; -fx-padding: 5;");
                }

                grid.add(cell, j, i);
            }
        }

        return grid;
    }

    // Int grid (colors for results)
    private GridPane createGrid(int[][] array, int[] largest, int[] smallest) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                Label cell = new Label(String.valueOf(array[i][j]));
                cell.setMinWidth(50);
                cell.setAlignment(Pos.CENTER);

                if (i == largest[0] && j == largest[1]) {
                    cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: #b6fcb6;");
                } 
                else if (i == smallest[0] && j == smallest[1]) {
                    cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: #fcb6b6;");
                } 
                else {
                    cell.setStyle("-fx-border-color: black; -fx-padding: 5;");
                }

                grid.add(cell, j, i);
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        launch();
    }
}