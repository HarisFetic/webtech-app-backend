package htwberlin.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KraftuebungService {

    @Autowired
    KraftuebungRepository repo;

    public Kraftuebung save(Kraftuebung kraftuebung) {
        return repo.save(kraftuebung);
    }

    public Kraftuebung get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Kraftuebung> getAll() {
        Iterable<Kraftuebung> iterator = repo.findAll();
        List<Kraftuebung> kraftuebungen = new ArrayList<>();
        for (Kraftuebung kraftuebung : iterator) {
            kraftuebungen.add(kraftuebung);
        }
        return kraftuebungen;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Kraftuebung update(Long id, Kraftuebung updatedKraftuebung) {
        Kraftuebung existingKraftuebung = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingKraftuebung.setName(updatedKraftuebung.getName());
        existingKraftuebung.setRepeat(updatedKraftuebung.getRepeat());
        // Weitere Eigenschaften der Kraftuebung aktualisieren, falls vorhanden

        return repo.save(existingKraftuebung);
    }
}
