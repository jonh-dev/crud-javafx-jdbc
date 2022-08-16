package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("/gui/MainView.fxml"));
            ScrollPane scrollPane = fxmlLoader.load();

            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            mainScene = new Scene(scrollPane);
            primaryStage.setTitle("Crud JavaFX with JDBC");
            primaryStage.setScene(mainScene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Scene getMainScene(){
        return mainScene;
    }

    public static void main(String[] args) {
        launch();
    }
}