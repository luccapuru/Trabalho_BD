import javafx.application.Application;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.stage.Stage;

public class Gerente extends Application {

    @Override
    public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("gerente.fxml"));
            Scene cena = new Scene(root);
            stage.setScene(cena);
            stage.setTitle("Gerente de E-sports");
            stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

