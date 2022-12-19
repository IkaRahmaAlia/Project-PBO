/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toko_kita;

/**
 *
 * @author Cindy
 */
public class Makanan extends Produk{
    private int id;
    private int daya_tahan;

    public Makanan(int id, int daya_tahan, String nama_produk, double harga, int jumlah, double diskon) {
        super(nama_produk, harga, jumlah, diskon);
        this.id = id;
        this.daya_tahan = daya_tahan;
    }
    
    public Makanan(int id, String nama_produk, double harga, int jumlah) {
        super(nama_produk, harga, jumlah);
        this.id = id;
    }

    public boolean isSpoiled(int daya_tahan){
      return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDaya_tahan() {
        return daya_tahan;
    }

    public void setDaya_tahan(int daya_tahan) {
        this.daya_tahan = daya_tahan;
    }
}