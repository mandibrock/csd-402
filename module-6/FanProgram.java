// Amanda Brock
// April 19, 2026
// Purpose: Uses JavaFX to display 2 fan objects and their status'.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FanProgram extends Application {

    @Override
    public void start(Stage stage) {

        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.FAST, true, 10, "blue");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setAlignment(Pos.CENTER);

        // Header Row
        grid.add(createHeader(""), 0, 0);
        grid.add(createHeader("Fan 1"), 1, 0);
        grid.add(createHeader("Fan 2"), 2, 0);

        // Status Row
        Label fan1Status = new Label(fan1.isOn() ? "ON" : "OFF");
        Label fan2Status = new Label(fan2.isOn() ? "ON" : "OFF");

        fan1Status.setStyle(
            fan1.isOn()
                ? "-fx-text-fill: #2e7d32; -fx-font-weight: bold;"
                : "-fx-text-fill: #c62828; -fx-font-weight: bold;"
        );

        fan2Status.setStyle(
            fan2.isOn()
                ? "-fx-text-fill: #2e7d32; -fx-font-weight: bold;"
                : "-fx-text-fill: #c62828; -fx-font-weight: bold;"
        );

        grid.add(createCell("Status"), 0, 1);
        grid.add(wrap(fan1Status), 1, 1);
        grid.add(wrap(fan2Status), 2, 1);

        // Speed
        grid.add(createCell("Speed"), 0, 2);
        grid.add(createCell(fan1.getSpeedString()), 1, 2);
        grid.add(createCell(fan2.getSpeedString()), 2, 2);

        // Radius
        grid.add(createCell("Radius"), 0, 3);
        grid.add(createCell(String.valueOf(fan1.getRadius())), 1, 3);
        grid.add(createCell(String.valueOf(fan2.getRadius())), 2, 3);

        // Color
        grid.add(createCell("Color"), 0, 4);
        grid.add(createCell(fan1.getColor()), 1, 4);
        grid.add(createCell(fan2.getColor()), 2, 4);

        // Root container
        StackPane root = new StackPane(grid);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        stage.setTitle("Fan Class Demo");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // Regular cells
    private StackPane createCell(String text) {
        Label label = new Label(text);

        StackPane pane = new StackPane(label);
        pane.setPadding(new Insets(8));

        pane.setStyle(
            "-fx-border-color: #d3d3d3;" +
            "-fx-border-width: 0.5;" +
            "-fx-background-color: white;"
        );

        return pane;
    }

    // Header cells
    private StackPane createHeader(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-weight: bold;");

        StackPane pane = new StackPane(label);
        pane.setPadding(new Insets(8));

        pane.setStyle(
            "-fx-background-color: #f5f5f5;" +
            "-fx-border-color: #d3d3d3;" +
            "-fx-border-width: 0.5;"
        );

        return pane;
    }

    // Wrap labels (status cells)
    private StackPane wrap(Label label) {
        StackPane pane = new StackPane(label);
        pane.setPadding(new Insets(8));

        pane.setStyle(
            "-fx-border-color: #d3d3d3;" +
            "-fx-border-width: 0.5;" +
            "-fx-background-color: white;"
        );

        return pane;
    }

    public static void main(String[] args) {
        launch();
    }
}