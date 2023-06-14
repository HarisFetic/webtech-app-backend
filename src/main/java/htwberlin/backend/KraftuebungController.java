package htwberlin.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class KraftuebungController {

    @Autowired
    KraftuebungService service;

    Logger logger = LoggerFactory.getLogger(KraftuebungController.class);

    @PostMapping("/kraftuebungen")
    public Kraftuebung createKraftuebung(@RequestBody Kraftuebung kraftuebung) {
        return service.save(kraftuebung);
    }

    @GetMapping("/kraftuebungen/{id}")
    public Kraftuebung getKraftuebung(@PathVariable String id) {
        logger.info("GET request on route kraftuebungen with {}", id);
        Long kraftuebungId = Long.parseLong(id);
        return service.get(kraftuebungId);
    }

    @GetMapping("/kraftuebungen")
    public List<Kraftuebung> getAllKraftuebungen() {
        return service.getAll();
    }

    @DeleteMapping("/kraftuebungen/{id}")
    public void deleteKraftuebung(@PathVariable String id) {
        logger.info("DELETE request on route kraftuebungen with {}", id);
        Long kraftuebungId = Long.parseLong(id);
        service.delete(kraftuebungId);
    }

    @PutMapping("/kraftuebungen/{id}")
    public Kraftuebung updateKraftuebung(@PathVariable String id, @RequestBody Kraftuebung updatedKraftuebung) {
        logger.info("PUT request on route kraftuebungen with {}", id);
        Long kraftuebungId = Long.parseLong(id);
        return service.update(kraftuebungId, updatedKraftuebung);
    }
}
