package salvo.nicolas.jewelry.repository;

import salvo.nicolas.jewelry.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlryRepository extends JpaRepository<Jewel,Long> {

}
