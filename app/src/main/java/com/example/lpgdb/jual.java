package com.example.lpgdb;

public class jual {
    // Store the id of the  movie poster
    private String penjualan_nama;
    private String penjualan_status;
    private String penjualan_alamat;
    private String penjualan_jumlah;
    // Store the name of the movie
    private String penjualan_tanggal;
    // Store the release date of the movie

    // Constructor that is used to create an instance of the Movie object
    public jual(String penjualan_nama, String penjualan_status, String penjualan_alamat, String penjualan_jumlah, String penjualan_tanggal) {
        this.penjualan_nama = penjualan_nama;
        this.penjualan_status = penjualan_status;
        this.penjualan_alamat = penjualan_alamat;
        this.penjualan_jumlah = penjualan_jumlah;
        this.penjualan_tanggal = penjualan_tanggal;
    }

    public String getPenjualan_nama() {
        return penjualan_nama;
    }

    public void setPenjualan_nama(String penjualan_nama) {
        this.penjualan_nama = penjualan_nama;
    }
//////////////////////////////////////////////////
    public String getPenjualan_status() {
        return penjualan_status;
    }

    public void setPenjualan_status(String penjualan_status) {
        this.penjualan_status = penjualan_status;
    }
///////////////////////////////////////////////////
    public String getPenjualan_alamat() {
        return penjualan_alamat;
    }

    public void setPenjualan_alamat(String penjualan_alamat) {
        this.penjualan_alamat = penjualan_alamat;
    }
    //////////////////////////////////////////////////////////
    public String getPenjualan_jumlah() {
        return penjualan_jumlah;
    }

    public void setPenjualan_jumlah(String penjualan_jumlah) {
        this.penjualan_jumlah = penjualan_jumlah;
    }
    /////////////////////////////////////////////////////////////
    public String getPenjualan_tanggal() {
        return penjualan_tanggal;
    }

    public void setPenjualan_tanggal(String penjualan_tanggal) {
        this.penjualan_tanggal = penjualan_tanggal;
    }
}
