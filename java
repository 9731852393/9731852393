// JavaFX code to display the retrieved information
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.apache.http.client.fluent.Request;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        
        // Making HTTP GET request to retrieve information from Python backend
        try {
            String response = Request.Get("http://localhost:5000/retrieve").execute().returnContent().asString();
            textArea.setText(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StackPane root = new StackPane();
        root.getChildren().add(textArea);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("JavaFX Display");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
