package htwberlin.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KraftuebungRepository extends CrudRepository<Kraftuebung, Long> {
}