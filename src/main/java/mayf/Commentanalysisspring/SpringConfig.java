package mayf.Commentanalysisspring;

import mayf.Commentanalysisspring.repository.JpaWebtoonRepository;
import mayf.Commentanalysisspring.repository.MemoryWebtoonRepository;
import mayf.Commentanalysisspring.repository.WebtoonRepository;
import mayf.Commentanalysisspring.service.CrawlerWebtoon;
import mayf.Commentanalysisspring.service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.swing.*;

@Configuration
public class SpringConfig {
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){this.em=em;}
    @Bean
    public WebtoonRepository webtoonRepository(){
        return new JpaWebtoonRepository(em);
        //return new MemoryWebtoonRepository(); test용
    }

    @Bean
    public WebtoonService webtoonService(){
        return new WebtoonService(webtoonRepository());
    }

    @Bean
    public CrawlerWebtoon crawlerWebtoon() {
        return new CrawlerWebtoon();
    }
}
