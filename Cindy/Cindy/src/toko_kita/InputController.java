/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package toko_kita;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cindy
 */
public class InputController implements Initializable {
    
    BarangModel b = new BarangModel(); 

    @FXML
    private AnchorPane lbl;
    @FXML
    private Label lbToko;
    @FXML
    private Label lbMenu;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Barang> tblihat;
    @FXML
    private TableColumn<Barang, StringProperty> colBarcode;
    @FXML
    private TableColumn<Barang, StringProperty> colProduk;
    @FXML
    private TableColumn<Barang, DoubleProperty> colHarga;
    @FXML
    private TableColumn<Barang, IntegerProperty> colJumlah;
    @FXML
    private TextField fieldProduk;
    @FXML
    private Button btnBrg;
    @FXML
    private Button btnmakan;
    @FXML
    private TextField fieldBarcode;
    @FXML
    private TextField fieldNamaProduk;
    @FXML
    private TextField fieldHarga;
    @FXML
    private TextField fieldJumlah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showData(); 
    }

    public void showData(){
        ObservableList<Barang> barang = b.getBarang(); 
        
        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colProduk.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tblihat.setItems(null);
        tblihat.setItems(barang); 
    }

    @FXML
    private void sendData(ActionEvent event) throws SQLException {
        int jumlah = Integer.parseInt(fieldJumlah.getText());
        double harga = Double.parseDouble(fieldHarga.getText());
        
        Barang brg = new Barang(fieldBarcode.getText(), fieldNamaProduk.getText(), harga, jumlah);
        b.addBarang(brg);
        clear(); 
    }
    
    void clear(){
        fieldBarcode.clear();
        fieldNamaProduk.clear();
        fieldHarga.clear();
        fieldJumlah.clear();
    }

    @FXML
    private void deleteInput(ActionEvent event) {
        int jumlah = Integer.parseInt(fieldJumlah.getText());
        double harga = Double.parseDouble(fieldHarga.getText());
        
        Barang brg = new Barang(fieldBarcode.getText(), fieldNamaProduk.getText(), harga, jumlah);
        b.deleteBarang(brg);
        clear();
    }

    @FXML
    private void toBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Input.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnBrg.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void toMakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnmakan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
}
