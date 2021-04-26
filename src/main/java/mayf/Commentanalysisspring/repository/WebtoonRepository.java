package mayf.Commentanalysisspring.repository;

import mayf.Commentanalysisspring.domain.Webtoon;

import java.lang.reflect.Member;
import java.util.Optional;
import java.util.List;

public interface WebtoonRepository {
    Webtoon save(Webtoon webtoon);
    Optional<Webtoon> findById(Long id);
    Optional<Webtoon> findByDayofWeek(String dayofweek);
    Optional<Webtoon> findByName(String name);
    List<Webtoon> findAll();
}
