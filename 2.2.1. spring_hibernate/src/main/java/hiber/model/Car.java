package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="model")
    String model;
    @Column(name="series")
    Integer series;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
