package fabriziopesaresi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import fabriziopesaresi.entities.ElementoCatalogo;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void save(ElementoCatalogo elemento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elemento);
        transaction.commit();
        System.out.println("Elemento salvato: " + elemento.getTitolo());
    }

    public void deleteByIsbn(String isbn) {
        ElementoCatalogo trovato = em.find(ElementoCatalogo.class, isbn);
        if (trovato != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(trovato);
            transaction.commit();
            System.out.println("Elemento rimosso correttamente.");
        } else {
            System.out.println("Elemento con ISBN " + isbn + " non trovato.");
        }
    }

    public ElementoCatalogo findByIsbn(String isbn) {
        return em.find(ElementoCatalogo.class, isbn);
    }

    public List<ElementoCatalogo> findByAnno(int anno) {
        return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno", ElementoCatalogo.class)
                .setParameter("anno", anno)
                .getResultList();
    }

    public List<ElementoCatalogo> findByAutore(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", ElementoCatalogo.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    public List<ElementoCatalogo> findByTitolo(String titolo) {
        return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE LOWER(e.titolo) LIKE LOWER(:titolo)", ElementoCatalogo.class)
                .setParameter("titolo", "%" + titolo + "%")
                .getResultList();
    }
}