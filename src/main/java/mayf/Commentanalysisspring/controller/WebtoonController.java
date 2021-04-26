package mayf.Commentanalysisspring.controller;

import mayf.Commentanalysisspring.domain.Webtoon;
import mayf.Commentanalysisspring.service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WebtoonController {
    private final WebtoonService webtoonservice;

    @Autowired
    public WebtoonController(WebtoonService webtoonservice){
        this.webtoonservice=webtoonservice;
    }

    @RequestMapping("/webtoons")
    public List<Webtoon> webtoonApi() {
        List<Webtoon> webtoon=webtoonservice.findWebtoons();
        return webtoon;
    }

    @RequestMapping(value = "/webtoons/{dayofweek}", method = RequestMethod.GET)
    public Webtoon webtoonWeekDayofWeekApi(@PathVariable("dayofweek") String dayofweek) {
        Optional<Webtoon> webtoon=webtoonservice.findOneByDayofWeek(dayofweek);
        if(webtoon.isPresent()){
            return webtoon.get();
        }

        return null;
    }
}
