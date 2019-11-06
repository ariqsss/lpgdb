package model;

public class Penjualanmodel {
    private int id;
    private String nama;
    private String status;
    private String alamat;
    private String jumlah;
    private String tanggal;

    public Penjualanmodel( String nama, String status, String alamat, String jumlah, String tanggal) {

        this.nama = nama;
        this.status = status;
        this.alamat = alamat;
        this.jumlah = jumlah;
        this.tanggal = tanggal;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPangkalan() {
        return pangkalan;
    }

    public void setPangkalan(String pangkalan) {
        this.pangkalan = pangkalan;
    }

    private String pangkalan;
}
