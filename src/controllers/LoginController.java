package controllers;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.data;
import models.user;

public class LoginController {
    @FXML
    private Hyperlink si_forgotPass;
    @FXML
    private Button si_loginBtn;
    @FXML
    private Pane si_loginForm;
    @FXML
    private PasswordField si_password;
    @FXML
    private TextField si_username;
    @FXML
    private Button side_CreateBtn;
    @FXML
    private Button side_LoginBtn;
    @FXML
    private AnchorPane side_form;
    @FXML
    private Pane signupForm;
    @FXML
    private TextField su_email;
    @FXML
    private PasswordField su_password;
    @FXML
    private Button su_signupBtn;
    @FXML
    private TextField su_username;

    private static final String XML_FILE = "users.xml";

    //SLIDER FOTO LOGIN KE SIGN INI
    @FXML
    public void switchForm(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();

        if (event.getSource() == side_CreateBtn) {
            slider.setNode(side_form);
            slider.setToX(625);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                side_LoginBtn.setVisible(true);
                side_CreateBtn.setVisible(false);
            });

            slider.play();
        } else if (event.getSource() == side_LoginBtn) {
            slider.setNode(side_form);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                side_LoginBtn.setVisible(false);
                side_CreateBtn.setVisible(true);
            });

            slider.play();
        }
    }

    @FXML
    void handleButtonAction_su(ActionEvent event) {
        String username = su_username.getText();
        String email = su_email.getText();
        String password = su_password.getText();    
        
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("===== SEMUA FIELD HARUS DIISI =====");
            return;
        }

        try {
            saveToXML(email, username, password);
            System.out.println("===== PENDAFTARAN AKUN GOTANI ANDA BERHASIL ======");
            clearSignUpFields();
        } catch (IOException e) {
            System.out.println("===== TERJADI KESALAHAN SAAT MENYIMPAN DATA: " + e.getMessage() +" =====");
        }
    }

    @FXML
    void handleButtonAction_si(ActionEvent event) {
        try {
            handleLoginButtonAction(event);
        } catch (IOException e) {
            System.out.println("===== TERJADI KESALAHAN SAAT LOGIN: " + e.getMessage()+" =====");
        }
    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) throws IOException {
        String username = si_username.getText();
        String password = si_password.getText();
        
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("===== USERNAME DAN PASSWORD HARUS DIISI =====");
            return;
        }

        List<user> users = readFromXML();
        boolean isLoginSuccess = false;
        
        for (user user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isLoginSuccess = true;
                break;
            }
        }
        
        if (isLoginSuccess) {
            //NGAMBIL USN USER
            data.username = si_username.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainPage.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.setMinHeight(855);
            stage.setMinWidth(1360);
            stage.setMaxHeight(860);
            stage.setMaxWidth(1355);

            stage.show();
            
            Stage loginStage = (Stage) si_loginBtn.getScene().getWindow();
            loginStage.close();
            
            System.out.println("===== ANDA BERHASIL LOGIN KE APLIKASI GOTANI =====");
        } else {
            System.out.println("===== GAGAL LOGIN, USERNAME ATAU PASSWORD SALAH =====");
        }
    }

    void saveToXML(String email, String username, String password) throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("list", List.class);
        xStream.alias("user", user.class);

        List<user> users = readFromXML();
        users.add(new user(email, password, username));

        try (FileWriter writer = new FileWriter(XML_FILE)) {
            xStream.toXML(users, writer);
        }
    }

    @SuppressWarnings("unchecked")
    List<user> readFromXML() throws IOException {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("list", List.class);
        xStream.alias("user", user.class);

        File file = new File(XML_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            return (List<user>) xStream.fromXML(reader);
        } catch (Exception e) {
            System.out.println("Error reading XML, returning empty list: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void clearSignUpFields() {
        su_username.clear();
        su_email.clear();
        su_password.clear();
    }
}