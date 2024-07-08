package home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setMinHeight(855);
        stage.setMinWidth(1360);
        stage.setMaxHeight(860);
        stage.setMaxWidth(1355);
        stage.setTitle("Login");

        stage.show();
    }
}
