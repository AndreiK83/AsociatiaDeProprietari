import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contor implements Serializable {
    public enum ContorType {GAZ, APA_CALDA, APA_RECE}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String locatie;
    @Column(nullable = false, name = "contor_index")
    private Integer index;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContorType type;
    @ManyToOne
    private Apartament ap;

    public Contor() {
    }

    public Contor(String locatie, Integer index, ContorType type) {
        this.locatie = locatie;
        this.index = index;
        this.type = type;
    }

    public void setAp(Apartament ap) {
        this.ap = ap;
    }

    @Override
    public String toString() {
        return "Contor{" +
                "id=" + id +
                ", locatie='" + locatie + '\'' +
                ", index=" + index +
                ", type=" + type +
                '}';
    }
}
