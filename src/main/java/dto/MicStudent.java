package dto;

/**
 * Created by Michel Koolwaaij on 18-09-20.
 */
public class MicStudent {
    private String naam;
    private int nummer;
    private String emailadres;
    private String telefoonnummer;

    public MicStudent(String naam, int nummer, String emailadres, String telefoonnummer) {
        this.naam = naam;
        this.nummer = nummer;
        this.emailadres = emailadres;
        this.telefoonnummer = telefoonnummer;
    }

    public String getNaam() {
        return naam;
    }

    public int getNummer() {
        return nummer;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }
}
