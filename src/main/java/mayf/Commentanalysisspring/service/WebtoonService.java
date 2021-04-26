package mayf.Commentanalysisspring.service;

import mayf.Commentanalysisspring.domain.Webtoon;
import mayf.Commentanalysisspring.repository.MemoryWebtoonRepository;
import mayf.Commentanalysisspring.repository.WebtoonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class WebtoonService {
     private final WebtoonRepository webtoonrepository = new MemoryWebtoonRepository();
    /**
     *DB초기 설정
     */
    public Long firstSetting(Webtoon webtoon){
        //같은 요일존재할시 x
        validateDuplocateWebtoon(webtoon);
        webtoonrepository.save(webtoon);
        return webtoon.getId();
    }

    private void validateDuplocateWebtoon(Webtoon webtoon) {
        webtoonrepository.findByDayofWeek(webtoon.getDayofweek())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 요일 데이터");
                });
    }

    /**
     * 전체 데이터 조회
     */
    public List<Webtoon> findWebtoons() {
        return webtoonrepository.findAll();
    }

    /**
     * 하나씩 조회(요일별)
     */
    public Optional<Webtoon> findOneByDayofWeek(String dayofweek){
        return webtoonrepository.findByDayofWeek(dayofweek);
    }
}
