import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jasypt.util.text.BasicTextEncryptor;

public class Starter extends Application {

    public static void main(String[] args) {

        String password = "sahan1234";

        String key = "#5566asd";

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

        basicTextEncryptor.setPassword(key);

        String encrypt = basicTextEncryptor.encrypt(password);

        System.out.println("Encryped Pssword : "+encrypt);

        String decrypt = basicTextEncryptor.decrypt(encrypt);

        System.out.println("Decryped Password : "+decrypt);


        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
        stage.show();
    }
}