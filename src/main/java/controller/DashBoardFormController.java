package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {

    public AnchorPane loadFormContent;

    public void btnCustomerForm(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/customer_form.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);

    }

    public void btnItemForm(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/register_form.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    public void btnOrderForm(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/orderForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);

    }
}
