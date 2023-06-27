package htwberlin.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AusdaueruebungController {

    @Autowired
    AusdaueruebungService service;

    Logger logger = LoggerFactory.getLogger(AusdaueruebungController.class);

    @PostMapping("/ausdaueruebungen")
    public Ausdaueruebung createAusdaueruebung(@RequestBody Ausdaueruebung ausdaueruebung) {
        return service.save(ausdaueruebung);
    }

    @GetMapping("/ausdaueruebungen/{id}")
    public Ausdaueruebung getAusdaueruebung(@PathVariable String id) {
        logger.info("GET request on route ausdaueruebungen with {}", id);
        Long ausdaueruebungId = Long.parseLong(id);
        return service.get(ausdaueruebungId);
    }

    @GetMapping("/ausdaueruebungen")
    public List<Ausdaueruebung> getAllAusdaueruebung() {
        return service.getAll();
    }

    @DeleteMapping("/ausdaueruebungen/{id}")
    public void deleteAusdaueruebung(@PathVariable String id) {
        logger.info("DELETE request on route ausdaueruebungen with {}", id);
        Long ausdaueruebungId = Long.parseLong(id);
        service.delete(ausdaueruebungId);
    }

    @PutMapping("/ausdaueruebungen/{id}")
    public Ausdaueruebung updateAusdaueruebung(@PathVariable String id, @RequestBody Ausdaueruebung updatedAusdaueruebung) {
        logger.info("PUT request on route ausdaueruebungen with {}", id);
        Long ausdaueruebungId = Long.parseLong(id);
        return service.update(ausdaueruebungId, updatedAusdaueruebung);
    }
}
