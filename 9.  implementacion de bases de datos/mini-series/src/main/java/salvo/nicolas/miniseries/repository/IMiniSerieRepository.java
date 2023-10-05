package salvo.nicolas.miniseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvo.nicolas.miniseries.model.MiniSerie;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
