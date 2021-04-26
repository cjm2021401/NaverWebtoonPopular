package mayf.Commentanalysisspring.repository;

import mayf.Commentanalysisspring.domain.Webtoon;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaWebtoonRepository implements WebtoonRepository{
    private final EntityManager em; //자동개꿀

    public JpaWebtoonRepository(EntityManager em){this.em=em;}
    @Override
    public Webtoon save(Webtoon webtoon) {
        em.persist(webtoon);
        return null;
    }

    @Override
    public Optional<Webtoon> findById(Long id) {
        Webtoon webtoon=em.find(Webtoon.class, id);
        return Optional.ofNullable(webtoon);
    }

    @Override
    public Optional<Webtoon> findByDayofWeek(String dayofweek) {
        List<Webtoon> result=em.createQuery("select w from Webtoon w where w.dayofweek = :dayofweek", Webtoon.class)
                .setParameter("dayofweek",dayofweek)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Webtoon> findByName(String name) {
        List<Webtoon> result=em.createQuery("select w from Webtoon w where w.name = :name", Webtoon.class)
                .setParameter("name",name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Webtoon> findAll() {
        return em.createQuery("select  w from Webtoon w", Webtoon.class)
                .getResultList();
    }
}
