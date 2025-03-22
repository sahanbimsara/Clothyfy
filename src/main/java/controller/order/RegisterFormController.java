package controller.order;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.User;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterFormController {

    @FXML
    private TextField txtCPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnRegister(ActionEvent event) throws SQLException {

        String key = "#5566asd";

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

        basicTextEncryptor.setPassword(key);

        String SQL = "INSERT INTO users (username,email,password) VALUES(?,?,?)";

        if (txtPassword.getText().equals(txtCPassword.getText())) {

            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users WHERE email=" + "'" + txtEmail.getText() + "'");

            if (!resultSet.next()) {
                User user = new User(
                        txtUserName.getText(),
                        txtEmail.getText(),
                        txtPassword.getText()
                );

                PreparedStatement psTm = connection.prepareStatement(SQL);
                psTm.setString(1, user.getUserName());
                psTm.setString(2, user.getEmail());
                psTm.setString(3, basicTextEncryptor.encrypt(user.getPassword()));
                psTm.executeUpdate();

            } else {
                new Alert(Alert.AlertType.ERROR, "user found!").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Check your password!!!").show();
        }


        }


    }


