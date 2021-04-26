package mayf.Commentanalysisspring.service;

import mayf.Commentanalysisspring.domain.Webtoon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.IOException;
import java.util.Calendar;

public class CrawlerWebtoon {
    private static String NaverWebtoon_Url= "https://comic.naver.com/webtoon/weekdayList.nhn?week=";
    private static String NaverWebtoonRoot="https://comic.naver.com";
    //어노테이션을 사용해시작하자마자 메소드실

    public void getData(Webtoon newData) throws IOException {
        getBestWebtoonData(newData);
    }
    public String getToday(){
        String[] weekDay= {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
        Calendar cal= Calendar.getInstance();
        String today=weekDay[cal.get(Calendar.DAY_OF_WEEK)-1];
        return today;
    }
    public void getBestWebtoonData(Webtoon newData) throws IOException{
       String today=getToday();

        newData.setDayofweek(today);
        Document doc = Jsoup.connect(NaverWebtoon_Url+today).get();
        Elements contents=doc.select("ul.img_list dl dt a");
        newData.setName(contents.get(0).attr("title"));
        String src=contents.get(0).attr("href").toString();
        doc=Jsoup.connect(NaverWebtoonRoot+src).get();
        contents=doc.select("tbody tr td.title a");
        String webtoon_url=contents.get(0).attr("href");
        doc=Jsoup.connect(NaverWebtoonRoot+webtoon_url).get();
        newData.setStar(Float.parseFloat(doc.select("span#bottomPointTotalNumber strong").text()));
        newData.setPeople(Long.parseLong(doc.select("span.pointTotalPerson em").get(0).text()));
    }
}
