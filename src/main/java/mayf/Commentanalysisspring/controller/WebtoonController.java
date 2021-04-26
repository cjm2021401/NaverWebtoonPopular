package mayf.Commentanalysisspring.controller;

import mayf.Commentanalysisspring.service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WebtoonController {
    private final WebtoonService webtoonservice;

    public WebtoonController(WebtoonService webtoonservice){
        this.webtoonservice=webtoonservice;
    }
}
