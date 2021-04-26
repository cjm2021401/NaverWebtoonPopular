package mayf.Commentanalysisspring.scheduling;

import mayf.Commentanalysisspring.domain.Webtoon;
import mayf.Commentanalysisspring.service.CrawlerWebtoon;
import mayf.Commentanalysisspring.service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
import java.io.IOException;

@EnableScheduling
@Configuration
public class WebtoonScheduler {
    private final WebtoonService webtoonService;

    @Autowired
    public WebtoonScheduler(WebtoonService webtoonService){
        this.webtoonService=webtoonService;
    }

   @Scheduled(cron = "0 13 8 * * *")
    public void test(){
       webtoonService.firstSetting();
       for(Webtoon data :webtoonService.findWebtoons()){
           System.out.println(data.getId());
           System.out.println(data.getName());
           System.out.println(data.getStar());
           System.out.println(data.getPeople());
       }
   }
}
