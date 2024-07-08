package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class TokoController {

    @FXML private ImageView bibitJagungImage;
    @FXML private ImageView berasImage;
    @FXML private ImageView singkongImage;
    @FXML private ImageView pupukImage;
    @FXML private ImageView kangkungImage;
    @FXML private ImageView nangkaImage;
    // Tambahkan ImageView lainnya sesuai kebutuhan

    @FXML private Text bibitJagungPrice;
    @FXML private Text berasPrice;
    @FXML private Text singkongPrice;
    @FXML private Text pupukPrice;
    @FXML private Text kangkungPrice;
    @FXML private Text nangkaPrice;
    // Tambahkan Text untuk harga produk lainnya

    @FXML private Spinner<Integer> bibitJagungSpinner;
    @FXML private Spinner<Integer> berasSpinner;
    @FXML private Spinner<Integer> singkongSpinner;
    @FXML private Spinner<Integer> pupukSpinner;
    @FXML private Spinner<Integer> kangkungSpinner;
    @FXML private Spinner<Integer> nangkaSpinner;
    // Tambahkan Spinner untuk produk lainnya

    @FXML private Button bibitJagungButton;
    @FXML private Button berasButton;
    @FXML private Button singkongButton;
    @FXML private Button pupukButton;
    @FXML private Button kangkungButton;
    @FXML private Button nangkaButton;
    // Tambahkan Button untuk produk lainnya

    @FXML
    public void initialize() {
        // Inisialisasi komponen, misalnya set nilai awal Spinner
        setupSpinners();
        setupPrices();
    }

    private void setupSpinners() {
        // Konfigurasi nilai minimum, maksimum, dan awal untuk setiap Spinner
    }

    private void setupPrices() {
        bibitJagungPrice.setText("Rp. 85.000");
        berasPrice.setText("Rp. 45.000");
        singkongPrice.setText("Rp. 45.000");
        pupukPrice.setText("Rp. 45.000");
        kangkungPrice.setText("Rp. 45.000");
        nangkaPrice.setText("Rp. 45.000");
        // Set harga untuk produk lainnya
    }

    @FXML
    private void handleAddToCart(javafx.event.ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (sourceButton == bibitJagungButton) {
            addBibitJagungToCart();
        } else if (sourceButton == berasButton) {
            addBerasToCart();
        }
        // Tambahkan kondisi untuk button lainnya
    }

    private void addBibitJagungToCart() {
        @SuppressWarnings("unused")
        int quantity = bibitJagungSpinner.getValue();
        // Logika untuk menambahkan Bibit Jagung ke keranjang
    }

    private void addBerasToCart() {
        @SuppressWarnings("unused")
        int quantity = berasSpinner.getValue();
        // Logika untuk menambahkan Beras ke keranjang
    }

    // Tambahkan metode untuk menangani penambahan produk lainnya ke keranjang
}