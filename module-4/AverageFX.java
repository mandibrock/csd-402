// Amanda Brock
// April 12, 2026
// Purpose of code: To find the averages of various arrays.
// I went through several versions of this program. First, was terminal output only. Second, was a simple UI
// with no alignment and different font sizes (it was a mess).. to about 10 other versions. Finally ended up
// with something I was happy with after a lot of research and a lot of trial and error. 

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class AverageFX extends Application {

    public static short average(short[] array) {
        short sum = 0;
        for (short n : array) sum += n;
        return (short) (sum / array.length);
    }

    public static int average(int[] array) {
        int sum = 0;
        for (int n : array) sum += n;
        return sum / array.length;
    }

    public static long average(long[] array) {
        long sum = 0;
        for (long n : array) sum += n;
        return sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0;
        for (double n : array) sum += n;
        return sum / array.length;
    }

    @Override
    public void start(Stage stage) {

        // Arrays
        short[] shortArray = {2, 4, 6};
        int[] intArray = {10, 20, 30, 40, 50};
        long[] longArray = {100, 200};
        double[] doubleArray = {1.5, 2.5, 3.5, 4.5};

        Label title = new Label("Average Calculator");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(6);
        grid.setAlignment(Pos.CENTER);

        // Column layout:
        // 0 = labels, 1 = divider, 2–6 = values
        // 7 = divider, 8 = results

        ColumnConstraints c0 = new ColumnConstraints();
        c0.setMinWidth(80);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setMinWidth(8);

        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();
        ColumnConstraints c4 = new ColumnConstraints();
        ColumnConstraints c5 = new ColumnConstraints();
        ColumnConstraints c6 = new ColumnConstraints();

        c2.setPrefWidth(38);
        c3.setPrefWidth(38);
        c4.setPrefWidth(38);
        c5.setPrefWidth(38);
        c6.setPrefWidth(38);

        c2.setHalignment(HPos.CENTER);
        c3.setHalignment(HPos.CENTER);
        c4.setHalignment(HPos.CENTER);
        c5.setHalignment(HPos.CENTER);
        c6.setHalignment(HPos.CENTER);

        ColumnConstraints c7 = new ColumnConstraints();
        c7.setMinWidth(8);

        ColumnConstraints c8 = new ColumnConstraints();
        c8.setMinWidth(70);
        c8.setHalignment(HPos.RIGHT);

        grid.getColumnConstraints().addAll(c0, c1, c2, c3, c4, c5, c6, c7, c8);

        // Row constraints 
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(24);
            grid.getRowConstraints().add(row);
        }

        // Section titles
        Label arraysTitle = new Label("Arrays");
        arraysTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        grid.add(arraysTitle, 0, 0);
        GridPane.setHalignment(arraysTitle, HPos.LEFT);

        Label resultsTitle = new Label("Avg. Results");
        resultsTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        grid.add(resultsTitle, 8, 0);
        GridPane.setHalignment(resultsTitle, HPos.CENTER);

        // Dividers
        Separator leftDivider = new Separator(Orientation.VERTICAL);
        leftDivider.setPrefHeight(120);
        grid.add(leftDivider, 1, 1, 1, 4);

        Separator rightDivider = new Separator(Orientation.VERTICAL);
        rightDivider.setPrefHeight(120);
        grid.add(rightDivider, 7, 1, 1, 4);

        // Row labels
        grid.add(new Label("Short:"), 0, 1);
        grid.add(new Label("Int:"), 0, 2);
        grid.add(new Label("Long:"), 0, 3);
        grid.add(new Label("Double:"), 0, 4);

        // Array values
        grid.add(new Label("2"), 2, 1);
        grid.add(new Label("4"), 3, 1);
        grid.add(new Label("6"), 4, 1);

        grid.add(new Label("10"), 2, 2);
        grid.add(new Label("20"), 3, 2);
        grid.add(new Label("30"), 4, 2);
        grid.add(new Label("40"), 5, 2);
        grid.add(new Label("50"), 6, 2);

        grid.add(new Label("100"), 2, 3);
        grid.add(new Label("200"), 3, 3);

        grid.add(new Label("1.5"), 2, 4);
        grid.add(new Label("2.5"), 3, 4);
        grid.add(new Label("3.5"), 4, 4);
        grid.add(new Label("4.5"), 5, 4);

        // Results values
        Label r1 = new Label("-");
        Label r2 = new Label("-");
        Label r3 = new Label("-");
        Label r4 = new Label("-");

        grid.add(r1, 8, 1);
        grid.add(r2, 8, 2);
        grid.add(r3, 8, 3);
        grid.add(r4, 8, 4);

        // Button
        Button button = new Button("Calculate");

        button.setOnAction(e -> {
            r1.setText(String.valueOf(average(shortArray)));
            r2.setText(String.valueOf(average(intArray)));
            r3.setText(String.valueOf(average(longArray)));
            r4.setText(String.format("%.2f", average(doubleArray)));

            stage.sizeToScene();
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(title, grid, button);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout);

        stage.setTitle("Average Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}