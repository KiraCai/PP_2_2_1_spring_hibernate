package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="model")
    String model;

    @Column(name="series")
    Integer series;


    public Car() {}
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Integer getId() {return this.series;}

    public void setId(Integer series) {this.series = series;}

    public String getModel() {return this.model;}

    public void setModel(String model){this.model = model;}

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

}
