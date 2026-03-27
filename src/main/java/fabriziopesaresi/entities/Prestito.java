package fabriziopesaresi.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato_id")
    private ElementoCatalogo elementoPrestato;

    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(User utente, ElementoCatalogo elemento, LocalDate dataInizio) {
        this.utente = utente;
        this.elementoPrestato = elemento;
        this.dataInizioPrestito = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
    }

    public UUID getId() { return id; }
    public User getUtente() { return utente; }
    public ElementoCatalogo getElementoPrestato() { return elementoPrestato; }
    public LocalDate getDataInizioPrestito() { return dataInizioPrestito; }
    public LocalDate getDataRestituzionePrevista() { return dataRestituzionePrevista; }
    public LocalDate getDataRestituzioneEffettiva() { return dataRestituzioneEffettiva; }
    public void setDataRestituzioneEffettiva(LocalDate data) { this.dataRestituzioneEffettiva = data; }

    @Override
    public String toString() {
        return "Prestito{" + "utente=" + utente.getCognome() + ", titolo=" + elementoPrestato.getTitolo() + ", scadenza=" + dataRestituzionePrevista + '}';
    }
}