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
public class MakananController implements Initializable {
    
    MakananModel m = new MakananModel(); 

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
    private TableView<Makanan> tblihat;
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
    @FXML
    private TableColumn<Makanan, StringProperty> colProduk;
    @FXML
    private TableColumn<Makanan, DoubleProperty> colHarga;
    @FXML
    private TableColumn<Makanan, IntegerProperty> colJumlah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showData(); 
    }

    private void showData(){
        ObservableList<Makanan> makanan = m.getMakanan();
        colProduk.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tblihat.setItems(null);
        tblihat.setItems(makanan); 
    }

    @FXML
    private void sendData(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(fieldBarcode.getText());
        int jumlah = Integer.parseInt(fieldJumlah.getText());
        double harga = Double.parseDouble(fieldHarga.getText());
        
        Makanan m1 = new Makanan(id, fieldNamaProduk.getText(), harga, jumlah);
        m.addMakanan(m1);
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
        int id = Integer.parseInt(fieldBarcode.getText());
        int jumlah = Integer.parseInt(fieldJumlah.getText());
        double harga = Double.parseDouble(fieldHarga.getText());
        
        Makanan m1 = new Makanan(id, fieldNamaProduk.getText(), harga, jumlah);
        m.deleteMakanan(m1);
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
