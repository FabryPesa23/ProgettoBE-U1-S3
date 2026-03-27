package fabriziopesaresi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import fabriziopesaresi.dao.CatalogoDAO;
import fabriziopesaresi.entities.Libro;
import fabriziopesaresi.entities.Periodicita;
import fabriziopesaresi.entities.Rivista;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBE-U1-S3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try (em) {
            CatalogoDAO dao = new CatalogoDAO(em);
            Libro l1 = new Libro("123-ABC", "Il Signore degli Anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy");
            Rivista r1 = new Rivista("456-DEF", "Focus", 2024, 50, Periodicita.MENSILE);

            dao.save(l1);
            dao.save(r1);

            System.out.println("Ricerca ISBN: " + dao.findByIsbn("123-ABC").getTitolo());

            System.out.println("Elementi del 2024: " + dao.findByAnno(2024).size());

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        } finally {
            emf.close();
        }
    }
}