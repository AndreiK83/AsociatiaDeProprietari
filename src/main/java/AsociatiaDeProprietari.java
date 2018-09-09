import javax.persistence.*;
import java.util.List;

@Entity
public class AsociatiaDeProprietari {
    private static volatile AsociatiaDeProprietari asociatiaDeProprietari;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @OneToMany
    private List<Apartament> apartamentList;
    @Column
    private final String IBAN;

    public AsociatiaDeProprietari()
    {
        IBAN = "";
    }

    public AsociatiaDeProprietari(List<Apartament> apartamentList, String IBAN) {
        this.apartamentList = apartamentList;
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
        for(Apartament ap:apartamentList)
        {
            //caut locatarul in fiecare apartament
            if(ap.containsLoc(loc)) {
                //si cand il gasesc: il sterg si opresc cautarea
                ap.removeLoc(loc);
                System.out.println("Locatar gasit si sters");
                return ap;
            }
        }
        System.out.println("Nu s-a gasit locatarul");
        return null;
    }

    public void setApartamentList(List<Apartament> apartamentList) {
        this.apartamentList = apartamentList;
    }
}
