/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toko_kita;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Cindy
 */
public class BarangModel {
    private final Connection CONN;

    public BarangModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    
    public void addBarang(Barang barang) throws SQLException{
        String insertBarang = "INSERT INTO barang VALUES ('"
                 + barang.getBarcode() + "', '" + barang.getExpired()
                 + "', '" + barang.getKategori() + "', '" + barang.getNama_produk()
                 + "', '" + barang.getHarga() + "', '" + barang.getJumlah()
                 + "', , '" + barang.getDiskon() + "');";
         
        try { 
            if (CONN.createStatement().executeUpdate(insertBarang) > 0) {
                System.out.println("Berhasil Memasukkan Data");
            } else {
                System.out.println("Gagal Memasukan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data ");
        }
    }
   
   
    public void deleteBarang(Barang barang){
        String deleteBarang = "DELETE FROM barang WHERE barcode = '" + barang.getBarcode() + "';"; 
        
        try { 
            if (CONN.createStatement().executeUpdate(deleteBarang) > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data ");
        }
    }
    
    
    public ObservableList<Barang> getBarang(){
        ObservableList<Barang> barang = FXCollections.observableArrayList();
        
        try{
            String sql = "SELECT * FROM barang";
            ResultSet rs = CONN.createStatement().executeQuery(sql);
            while(rs.next()){
                Barang brg = new Barang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getDouble(7));
                barang.add(brg);
            }
           
        }catch(SQLException e){
            
        }
        return barang;
    }
    
}
