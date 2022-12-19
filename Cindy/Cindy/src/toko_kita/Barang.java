/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toko_kita;

import java.util.ArrayList;

/**
 *
 * @author Cindy
 */
public class Barang extends Produk{
    private String barcode;
    private String expired;
    String kategori;

    public Barang(String barcode, String expired, String kategori, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.kategori = kategori;
    }
    
    public Barang(String Barcode, String nama_produk, double harga, int jumlah) {
        super(nama_produk, harga, jumlah);
        this.barcode=barcode;
    }

  
    public boolean isExpired(String expired){
        return true;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    
    @Override
    public String getNama_produk() {
        return nama_produk;
    }

    @Override
    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }
}