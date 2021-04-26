package mayf.Commentanalysisspring;

import mayf.Commentanalysisspring.repository.MemoryWebtoonRepository;
import mayf.Commentanalysisspring.service.WebtoonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public WebtoonService webtoonService(){
        return new WebtoonService();
    }

    @Bean
    public MemoryWebtoonRepository memoryWebtoonRepository() {ys
        return new MemoryWebtoonRepository();
    }
}
