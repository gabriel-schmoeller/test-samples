package gabriel.schmoeller.app.sample.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends CrudRepository<ThingEntity, Long> {
}
