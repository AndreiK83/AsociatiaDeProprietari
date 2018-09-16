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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap", orphanRemoval = true)
    private List<Locatar> locatari;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap")
    private List<Contor> contoare;
    @ManyToOne
    private AsociatiaDeProprietari asc;

    public Apartament() {

    }

    public Apartament(Integer nr, List<Contor> contoare) {
        this.nr = nr;
        this.contoare = contoare;
        //Rezolvare null pointer exception (creare lista goala):
        for (Contor c : contoare) {
            c.setAp(this);
        }
        this.locatari = new ArrayList<Locatar>();
    }

    public void setAsc(AsociatiaDeProprietari asc) {
        this.asc = asc;
    }


    public void addLoc(Locatar loc) {
        locatari.add(loc);
        loc.setAp(this);
        System.out.println("Lista de locatari este " + locatari);
    }

    public void removeLoc(Locatar loc) {

        if (locatari.remove(loc) == true) {
            loc.setAp(null);
            System.out.println("Locatar sters");
        } else {
            System.out.println("Locatar necunoscut");
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

    public boolean containsLoc(Locatar loc) {

        if (locatari.contains(loc)) {
            return true;
        } else
            return false;
    }

    public boolean isThisNRMine(int nr){
        System.out.println(this.nr +", " +nr);
       return this.nr.equals(nr);
    }

}
