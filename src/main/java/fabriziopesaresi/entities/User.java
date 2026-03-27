package fabriziopesaresi.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    @Column(name = "numero_tessera", unique = true, nullable = false)
    private String numeroTessera;

    public User() {}

    public User(String nome, String cognome, LocalDate dataNascita, String numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getNumeroTessera() { return numeroTessera; }

    @Override
    public String toString() {
        return "User{" + "nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", tessera='" + numeroTessera + '\'' + '}';
    }
}