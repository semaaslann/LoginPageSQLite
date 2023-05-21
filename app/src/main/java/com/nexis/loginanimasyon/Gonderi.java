package com.nexis.loginanimasyon;

public class Gonderi {
    private int profil, gonderi;
    private String adsoyad;

    public Gonderi(int profil, String adsoyad, int gonderi){
        this.profil = profil;
        this.adsoyad = adsoyad;
        this.gonderi = gonderi;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public int getGonderi() {
        return gonderi;
    }

    public void setGonderi(int gonderi) {
        this.gonderi = gonderi;
    }
}
