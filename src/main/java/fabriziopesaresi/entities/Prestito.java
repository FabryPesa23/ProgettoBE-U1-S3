package fabriziopesaresi.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato_isbn")
    private ElementoCatalogo elementoPrestato;

    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(User utente, ElementoCatalogo elemento, LocalDate dataInizio) {
        this.utente = utente;
        this.elementoPrestato = elemento;
        this.dataInizioPrestito = dataInizio;
        // Calcolo automatico +30 giorni (punto 3 del README)
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    public User getUtente() { return utente; }
    public void setUtente(User utente) { this.utente = utente; }
    public ElementoCatalogo getElementoPrestato() { return elementoPrestato; }
    public void setElementoPrestato(ElementoCatalogo elemento) { this.elementoPrestato = elemento; }
    public LocalDate getDataInizioPrestito() { return dataInizioPrestito; }
    public LocalDate getDataRestituzionePrevista() { return dataRestituzionePrevista; }
    public LocalDate getDataRestituzioneEffettiva() { return dataRestituzioneEffettiva; }
    public void setDataRestituzioneEffettiva(LocalDate data) { this.dataRestituzioneEffettiva = data; }

    @Override
    public String toString() {
        return "Prestito{" + "utente=" + utente.getCognome() + ", titolo=" + elementoPrestato.getTitolo() + ", scadenza=" + dataRestituzionePrevista + '}';
    }
}