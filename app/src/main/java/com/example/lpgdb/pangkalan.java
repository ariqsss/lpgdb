package com.example.lpgdb;

public class pangkalan {

    private String settingagen_idpangkalan;

    private String settingagen_namapangkalan;

    private String settingagen_hargapangkalan;

    private String settingagen_tglefektif;

    private String settingagen_nohppangkalan;

    private String settingagen_emailpangkalan;

    // Constructor that is used to create an instance of the Movie object
    public pangkalan(String idpangkalan,String namapangkalan,String hargapangkalan,String tglefektif,String nohppangkalan,String emailpangkalan) {
        this.settingagen_idpangkalan = idpangkalan;
        this.settingagen_namapangkalan = namapangkalan;
        this.settingagen_hargapangkalan = hargapangkalan;
        this.settingagen_tglefektif = tglefektif;
        this.settingagen_nohppangkalan = nohppangkalan;
        this.settingagen_emailpangkalan = emailpangkalan;
    }

    public String getSettingagen_idpangkalan() {
        return settingagen_idpangkalan;
    }

    public void setSettingagen_idpangkalan(String settingagen_idpangkalan) {
        this.settingagen_idpangkalan = settingagen_idpangkalan;
    }

    public String getSettingagen_namapangkalan() {
        return settingagen_namapangkalan;
    }

    public void setSettingagen_namapangkalan(String settingagen_namapangkalan) {
        this.settingagen_namapangkalan = settingagen_namapangkalan;
    }

    public String getSettingagen_hargapangkalan() {
        return settingagen_hargapangkalan;
    }

    public void setSettingagen_hargapangkalan(String settingagen_hargapangkalan) {
        this.settingagen_hargapangkalan = settingagen_hargapangkalan;
    }

    public String getSettingagen_tglefektif() {
        return settingagen_tglefektif;
    }

    public void setSettingagen_tglefektif(String settingagen_tglefektif) {
        this.settingagen_tglefektif = settingagen_tglefektif;
    }

    public String getSettingagen_nohppangkalan() {
        return settingagen_nohppangkalan;
    }

    public void setSettingagen_nohppangkalan(String settingagen_nohppangkalan) {
        this.settingagen_nohppangkalan = settingagen_nohppangkalan;
    }

    public String getSettingagen_emailpangkalan() {
        return settingagen_emailpangkalan;
    }

    public void setSettingagen_emailpangkalan(String settingagen_emailpangkalan) {
        this.settingagen_emailpangkalan = settingagen_emailpangkalan;
    }
}
