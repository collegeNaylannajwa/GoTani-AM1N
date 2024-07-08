package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class BuatAkunTaniController {

    @FXML
    private Button btnSignin;

    @FXML
    private Button btnSignup;

    @FXML
    private TextField txtUsername;

    @FXML
    private Label btnForgot;

    @FXML
    private Label lblErrors;

    @FXML
    private PasswordField txtPassword1;

    @FXML
    private TextField txtUsername2;

    @FXML
    private TextField txtUsername21;

    @FXML
    void handleButtonAction(ActionEvent event) {
        // This method is called when the "Buat Akun" button is clicked
        if (event.getSource() == btnSignin) {
            createAccount();
        }
    }

    private void createAccount() {
        String username = txtUsername.getText();
        String email = txtUsername2.getText();
        String password = txtPassword1.getText();
        String certificateLink = txtUsername21.getText();

        // TODO: Implement account creation logic here
        // For example:
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || certificateLink.isEmpty()) {
            lblErrors.setText("Semua field harus diisi.");
        } else {
            // Perform account creation
            // If successful:
            // Clear fields and show success message
            // If failed:
            lblErrors.setText("Gagal membuat akun. Silakan coba lagi.");
        }
    }

    @FXML
    void initialize() {
        // Initialize your controller here
        btnSignup.setOnAction(event -> login());
    }

    private void login() {
        // TODO: Implement login logic or navigation to login screen
    }

    @SuppressWarnings("unused")
    private void forgotPassword() {
        // TODO: Implement forgot password logic
    }
}