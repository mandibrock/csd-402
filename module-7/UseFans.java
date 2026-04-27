// Amanda Brock
// April 26, 2026
// Purpose: Uses JavaFX to display a collection of fan objects and their status'.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UseFans extends Application {

    @Override
    public void start(Stage stage) {

        // Collection of fans
        ArrayList<Fan> fans = new ArrayList<>();

        fans.add(new Fan()); 
        fans.add(new Fan(Fan.FAST, true, 10, "blue"));
        fans.add(new Fan(Fan.MEDIUM, true, 8, "green"));
        fans.add(new Fan(Fan.SLOW, false, 7, "red"));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setAlignment(Pos.CENTER);

        int col = 1;

        // Header row
        grid.add(createHeader(""), 0, 0);

        for (int i = 0; i < fans.size(); i++) {
            grid.add(createHeader("Fan " + (i + 1)), col++, 0);
        }

        // Row labels
        grid.add(createCell("Status"), 0, 1);
        grid.add(createCell("Speed"), 0, 2);
        grid.add(createCell("Radius"), 0, 3);
        grid.add(createCell("Color"), 0, 4);

        // Fill fan data
        for (int i = 0; i < fans.size(); i++) {
            Fan fan = fans.get(i);

            int column = i + 1;

            // Status
            Label statusLabel = new Label(fan.isOn() ? "ON" : "OFF");
            statusLabel.setStyle(
                fan.isOn()
                    ? "-fx-text-fill: #2e7d32; -fx-font-weight: bold;"
                    : "-fx-text-fill: #c62828; -fx-font-weight: bold;"
            );

            grid.add(wrap(statusLabel), column, 1);

            // Speed (only if ON)
            String speedText = fan.isOn() ? fan.getSpeedString() : "-";
            grid.add(createCell(speedText), column, 2);

            // Radius
            grid.add(createCell(String.valueOf(fan.getRadius())), column, 3);

            // Color
            grid.add(createCell(fan.getColor()), column, 4);
        }

        StackPane root = new StackPane(grid);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        stage.setTitle("UseFans Collection Display");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // Cell
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

    // Header
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

    // Wrap for styled labels (status)
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