package htwberlin.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AusdaueruebungRepository extends CrudRepository<Ausdaueruebung, Long> {
}