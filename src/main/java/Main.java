import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateLocatari app = new HibernateLocatari();

        Contor ap1c1 = new Contor("Baie", 0, Contor.ContorType.GAZ);
        Contor ap1c2 = new Contor("Bucatarie", 0, Contor.ContorType.APA_CALDA);
        Contor ap1c3 = new Contor("Tancodrom", 0, Contor.ContorType.APA_RECE);

        Contor ap2c1 = new Contor("Baie", 1, Contor.ContorType.GAZ);
        Contor ap2c2 = new Contor("Bucatarie", 1, Contor.ContorType.APA_CALDA);
        Contor ap2c3 = new Contor("Tancodrom", 1, Contor.ContorType.APA_RECE);

        List<Contor> listContoareAp1 = new ArrayList<>();
        List<Contor> listContoareAp2 = new ArrayList<>();

        listContoareAp1.add(ap1c1);
        listContoareAp1.add(ap1c2);
        listContoareAp1.add(ap1c3);

        listContoareAp2.add(ap2c1);
        listContoareAp2.add(ap2c2);
        listContoareAp2.add(ap2c3);

        Apartament apartament1 = new Apartament(1, listContoareAp1);
        Apartament apartament2 = new Apartament(2, listContoareAp2);

        List<Apartament> apartamentList = new ArrayList<Apartament>();

        apartamentList.add(apartament1);
        apartamentList.add(apartament2);

        Locatar locatar1 = new Locatar("1234567891234", "Iliescu", "iliescu@mail.com");
        Locatar locatar2 = new Locatar("9874561237895", "Dragnea", "dragnea@mail.com");

        AsociatiaDeProprietari asocProp = AsociatiaDeProprietari.getAsociatiaDeProprietari(apartamentList, "ROBNRIBAN");

        app.insert(asocProp.registerLocatar(apartament1, locatar1));
        app.insert(asocProp.registerLocatar(apartament2, locatar2));

        app.insert(asocProp.unregisterLocatar(apartament1, locatar1));




//        List<Locatar> locatarList = new ArrayList<Locatar>();

        //locatarList este goala. Dovada:
//        System.out.println("Nr de locatari din lista este" + locatarList.size());
        //se poate sterge tot forul asta pentru ca nu vrem sa adaugam locatari in apartament decat prin intermediul
        //metodei register

        //locatarul care se insereaza aici nu are un apartament asociat
        //ar fi mai simplu daca l-am insera odata cu inregistrarea lui in asociatie
        //se poate sterge insertul asta
//        app.insert(locatar1);
//        app.insert(locatar2);
//        app.getAll(Locatar.class);
//        System.out.println(app.getAll(Locatar.class));

        //deocamdata locatarList este nefolosita; dar pare o idee buna si cred ca o vei folosi in viitor
//        locatarList.add(locatar1);
        //Linia asta de cod este cam lunga. O poti scurta?


    }

}
