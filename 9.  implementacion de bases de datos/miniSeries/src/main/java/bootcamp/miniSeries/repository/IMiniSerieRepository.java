package bootcamp.miniSeries.repository;

import bootcamp.miniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
