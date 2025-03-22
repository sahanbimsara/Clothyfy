package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.customer.CustomerController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;
import model.Customer;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    @FXML
    private JFXComboBox cmbCustomerId;

    @FXML
    private JFXComboBox cmbItemCode;

    @FXML
    private TableColumn colDesc;

    @FXML
    private TableColumn colItemCode;

    @FXML
    private TableColumn colQty;

    @FXML
    private TableColumn colTotal;

    @FXML
    private TableColumn colUnitPrice;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblTotal;

    @FXML
    private TableView tblCart;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtDesc;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtStock;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
         setDateAndTime();
    }

    @FXML
    void placeOrderOnAction(ActionEvent event) {

    }

    private void setDateAndTime(){
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String format = dateFormat.format(date);
        lblDate.setText(format);
       // =================

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    LocalTime now = LocalTime.now();
                    lblTime.setText(now.getHour()+":"+now.getMinute()+":"+now.getSecond());
                }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDateAndTime();
        loadCustomerIds();

        cmbCustomerId.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
           if (newValue != null){
           searchCustomerData(newValue.toString());
           }
        });
    }

    private void searchCustomerData(String customerId) {
        Customer customer = new CustomerController().searchCustomer(customerId);
        System.out.println(customer);

        txtCustomerName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());

    }

    private void loadCustomerIds(){
        CustomerController customerController = new CustomerController();

        ObservableList<String> customerIds = FXCollections.observableArrayList();

        List<Customer> all = new CustomerController().getAll();

        all.forEach(customer -> {

            customerIds.add(customer.getId());
        });

        cmbCustomerId.setItems(customerIds);
    }
}
