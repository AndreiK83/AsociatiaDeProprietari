import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AsociatiaDeProprietari {
    private static volatile AsociatiaDeProprietari asociatiaDeProprietari;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asc")
    private List<Apartament> apartamentList = new ArrayList<>();
    @Column
    private final String IBAN;

    public AsociatiaDeProprietari() {
        IBAN = "";
    }

    public AsociatiaDeProprietari(List<Apartament> apartamentList, String IBAN) {
        this.apartamentList = apartamentList;
        for (Apartament ap: apartamentList){
            ap.setAsc(this);
        }
        this.IBAN = IBAN;
    }



//    public static AsociatiaDeProprietari getAsociatiaDeProprietari(List<Apartament> apartamentList, String IBAN) {
//        if (asociatiaDeProprietari == null) {
//            synchronized (AsociatiaDeProprietari.class) {
//                if (asociatiaDeProprietari == null) {
//                    asociatiaDeProprietari = new AsociatiaDeProprietari(apartamentList, IBAN);
//                }
//            }
//        }
//        return asociatiaDeProprietari;
//    }

    public Apartament registerLocatar(Apartament ap, Locatar loc) {
        ap.addLoc(loc);
        return ap;
    }


    public Apartament unregisterLocatar(Locatar loc) {

        // pentru fiecare apartament din bloc
        for (Apartament ap : apartamentList) {
            //caut locatarul in fiecare apartament
            if (ap.containsLoc(loc)) {
                //si cand il gasesc: il sterg si opresc cautarea
                ap.removeLoc(loc);
                System.out.println("Locatar gasit si sters");
                return ap;
            }
        }
        System.out.println("Nu s-a gasit locatarul");
        return null;
    }

    public Apartament findApartamentByNr(int nr) {
        Apartament aux = null;
        System.out.println(apartamentList);
        for (Apartament a : apartamentList) {
            if (a.isThisNRMine(nr)) {
                aux = a;
            }
        }
        return aux;
    }

    public void setApartamentList(List<Apartament> apartamentList) {
        this.apartamentList = apartamentList;
    }
}
