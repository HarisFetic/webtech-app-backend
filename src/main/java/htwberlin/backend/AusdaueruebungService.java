package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AusdaueruebungService {

    @Autowired
    AusdaueruebungRepository repo;

    public Ausdaueruebung save(Ausdaueruebung ausdaueruebung) {
        return repo.save(ausdaueruebung);
    }

    public Ausdaueruebung get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Ausdaueruebung> getAll() {
        Iterable<Ausdaueruebung> iterator = repo.findAll();
        List<Ausdaueruebung> ausdaueruebungen = new ArrayList<>();
        for (Ausdaueruebung ausdaueruebung : iterator) {
            ausdaueruebungen.add(ausdaueruebung);
        }
        return ausdaueruebungen;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Ausdaueruebung update(Long id, Ausdaueruebung updatedAusdaueruebung) {
        Ausdaueruebung existingAusdaueruebung = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingAusdaueruebung.setName(updatedAusdaueruebung.getName());
        existingAusdaueruebung.setRepeat(updatedAusdaueruebung.getRepeat());
        // Weitere Eigenschaften der Ausdaueruebungen aktualisieren, falls vorhanden

        return repo.save(existingAusdaueruebung);
    }
}
