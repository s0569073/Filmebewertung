package de.htwBerlin.filmebewertung.persistence;

import javax.persistence.*;

@Entity(name = "filme")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "film_name", nullable = false)
    private String filmName;

    @Column(name = "bewertung", nullable = false)
    private int bewertung;

    @Column(name = "kommentar")
    private String kommentar;

    @Column(name = "bewerter")
    private String bewerter;

    public FilmeEntity(long id, String filmName, int bewertung, String kommentar, String bewerter) {
        this.id = id;
        this.filmName = filmName;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.bewerter = bewerter;
    }

    protected FilmeEntity() {
    }

    public long getId() {
        return id;
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
