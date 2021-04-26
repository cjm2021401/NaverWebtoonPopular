package mayf.Commentanalysisspring.domain;
import javax.persistence.*;

@Entity
public class Webtoon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dayofweek;
    private String name;
    private float star;
    private Long people;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public Long getPeople() {
        return people;
    }

    public void setPeople(Long people) {
        this.people = people;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

}
