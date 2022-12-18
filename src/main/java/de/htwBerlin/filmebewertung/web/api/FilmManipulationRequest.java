package de.htwBerlin.filmebewertung.web.api;

public class FilmManipulationRequest {

    private String filmName;
    private int bewertung;
    private String kommentar;
    private String bewerter;

    public FilmManipulationRequest(String filmName, int bewertung, String kommentar, String bewerter) {
        this.filmName = filmName;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.bewerter = bewerter;
    }

    public FilmManipulationRequest() {}

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


