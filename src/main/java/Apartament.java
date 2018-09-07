import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Apartament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer nr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap")
    private List<Locatar> locatari;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap")
    private List<Contor> contoare;

    public Apartament(){

    }

    public Apartament(Integer nr, List<Contor> contoare) {
        this.nr = nr;
        this.contoare = contoare;
        //Rezolvare null pointer exception (creare lista goala):
        for (Contor c : contoare){
            c.setAp(this);
        }
        this.locatari = new ArrayList<Locatar>();
    }

    public void addLoc(Locatar loc){
        //nullpointer exception apare la linia urmatoare pentru ca lista de locatari este egala cu null. Dovada:

        //Lista cu locatari ar trebui sa fie in acest punct o lista goala
        //Daca am construi lista in constructor atunci problema asta s-ar rezolvat
        locatari.add(loc);
        loc.setAp(this);
        System.out.println("Lista de locatari este "+locatari);
    }

    public void removeLoc(Locatar loc){
        if (locatari.equals(loc)){
            locatari.remove(loc);
            loc.setAp(this);
            System.out.println("Lista de locatari este "+locatari);
        }
    }

    @Override
    public String toString() {
        return "Apartament{" +
                "id=" + id +
                ", nr=" + nr +
                ", locatari=" + locatari +
                ", contoare=" + contoare +
                '}';
    }
}
