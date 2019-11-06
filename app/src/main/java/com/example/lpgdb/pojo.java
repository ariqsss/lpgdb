package com.example.lpgdb;

public class pojo {
    // Store the id of the  movie poster
    private String order_jumlah;
    // Store the name of the movie
    private String order_tanggal;
    // Store the release date of the movie
    private String order_harga;

    // Constructor that is used to create an instance of the Movie object
    public pojo(String order_jumlah, String order_tanggal, String order_harga) {
        this.order_jumlah = order_jumlah;
        this.order_tanggal = order_tanggal;
        this.order_harga = order_harga;
    }

    public String getOrder_jumlah() {
        return order_jumlah;
    }

    public void setOrder_jumlah(String order_jumlah) {
        this.order_jumlah = order_jumlah;
    }

    public String getOrder_tanggal() {
        return order_tanggal;
    }

    public void setOrder_tanggal(String order_tanggal) {
        this.order_tanggal = order_tanggal;
    }

    public String getOrder_harga() {
        return order_harga;
    }

    public void setOrder_harga(String order_harga) {
        this.order_harga = order_harga;
    }
}
