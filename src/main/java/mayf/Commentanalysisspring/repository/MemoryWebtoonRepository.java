package mayf.Commentanalysisspring.repository;

import mayf.Commentanalysisspring.domain.Webtoon;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryWebtoonRepository implements WebtoonRepository{

    private  static Map<Long, Webtoon> store = new HashMap<>();
    private  static long sequence = 0L;
    @Override
    public Webtoon save(Webtoon webtoon) {
        webtoon.setId(++sequence);
        store.put(webtoon.getId(), webtoon);
        return null;
    }

    @Override
    public Optional<Webtoon> findById(Long id) {
         return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Webtoon> findByDayofWeek(String dayofweek) {
        return store.values().stream()
                .filter(webtoon -> webtoon.getDayofweek().equals(dayofweek))
                .findAny();
    }

    @Override
    public Optional<Webtoon> findByName(String name) {
        return store.values().stream()
                .filter(webtoon -> webtoon.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Webtoon> findAll() {
        return new ArrayList<>(store.values());
    }
}
