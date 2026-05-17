import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UseDivision extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Division objects
        InternationalDivision intl1 =
                new InternationalDivision(
                        "Neon Pulse Records",
                        1001,
                        "Netherlands",
                        "Dutch");

        InternationalDivision intl2 =
                new InternationalDivision(
                        "Bassline Syndicate",
                        1002,
                        "Germany",
                        "German");

        DomesticDivision dom1 =
                new DomesticDivision(
                        "Festival Operations",
                        2001,
                        "Florida");

        DomesticDivision dom2 =
                new DomesticDivision(
                        "Stage Production Crew",
                        2002,
                        "California");

        // Main title
        Label mainTitle =
                new Label("EDM Company Division Report");

        mainTitle.setFont(
                Font.font("Segoe UI", FontWeight.SEMI_BOLD, 24));

        // International section title
        Label internationalTitle =
                new Label("=== INTERNATIONAL DIVISION ===");

        internationalTitle.setFont(
                Font.font("Segoe UI", FontWeight.SEMI_BOLD, 18));

        internationalTitle.setMaxWidth(Double.MAX_VALUE);

        internationalTitle.setAlignment(Pos.CENTER);

        // International content
        Label internationalContent =
                new Label(
                        intl1.display() +
                        "\n------------------------------\n\n" +
                        intl2.display());

        internationalContent.setFont(
                Font.font("Courier New", 16));

        internationalContent.setStyle(
                "-fx-border-color: black;" +
                "-fx-border-width: 1;" +
                "-fx-padding: 15;" +
                "-fx-background-color: white;"
        );

        // Domestic section title
        Label domesticTitle =
                new Label("=== DOMESTIC DIVISION ===");

        domesticTitle.setFont(
                Font.font("Segoe UI", FontWeight.SEMI_BOLD, 18));

        domesticTitle.setMaxWidth(Double.MAX_VALUE);

        domesticTitle.setAlignment(Pos.CENTER);

        // Domestic content
        Label domesticContent =
                new Label(
                        dom1.display() +
                        "\n------------------------------\n\n" +
                        dom2.display());

        domesticContent.setFont(
                Font.font("Courier New", 16));

        domesticContent.setStyle(
                "-fx-border-color: black;" +
                "-fx-border-width: 1;" +
                "-fx-padding: 15;" +
                "-fx-background-color: white;"
        );

        // Layout
        VBox root = new VBox(20);

        root.setPadding(new Insets(25));

        root.setAlignment(Pos.TOP_CENTER);

        root.getChildren().addAll(
                mainTitle,
                internationalTitle,
                internationalContent,
                domesticTitle,
                domesticContent
        );

        // Scene
        Scene scene = new Scene(root);

        primaryStage.setTitle("UseDivision");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}