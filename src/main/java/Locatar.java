import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Locatar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nume;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, unique = true, length = 13)
    private String cnp;
    @ManyToOne
    private Apartament ap;


    public Locatar(String cnp, String nume, String email) {
        this.cnp = cnp;
        this.nume = nume;
        this.email = email;
    }

    public void setAp(Apartament ap) {
        this.ap = ap;
    }

    @Override
    public String toString() {
        return "Locatar{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
