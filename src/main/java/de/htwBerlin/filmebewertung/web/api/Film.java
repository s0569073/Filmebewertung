package de.htwBerlin.filmebewertung.web.api;

public class Film {

    private long id;
    private String filmName;
    private int bewertung;
    private String kommentar;
    private String bewerter;

    public Film(long id,String filmName, int bewertung, String kommentar, String bewerter) {
        this.id = id;
        this.filmName = filmName;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.bewerter = bewerter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getBewerter() {
        return bewerter;
    }

    public void setBewerter(String bewerter) {
        this.bewerter = bewerter;
    }
}
