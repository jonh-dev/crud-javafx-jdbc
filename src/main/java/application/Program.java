package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("/gui/MainView.fxml"));
        ScrollPane scrollPane = fxmlLoader.load();

        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        Scene mainScene = new Scene(scrollPane);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}