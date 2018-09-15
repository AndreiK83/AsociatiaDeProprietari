import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console extends Main {
    private HibernateLocatari app;
    private Scanner sc;
    private AsociatiaDeProprietari asocProp;


    public Console() {
        this.app = new HibernateLocatari();
        sc = new Scanner(System.in);
        List<Object> list = app.getAll(AsociatiaDeProprietari.class);
        if (!list.isEmpty()) {
            asocProp = (AsociatiaDeProprietari) list.get(0);
        }
        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            switch (drawMainMenu()) {
                case 1:
                    categories();
                    app.insert(asocProp);
                    break;
                case 2:
                    if (asocProp == null) {
                        int howMany;
                        String codBancar;
                        System.out.println("Introduceti codul bancar");
                        codBancar = sc.nextLine();
                        System.out.println("Introduceti numarul apartamentelor");
                        howMany = sc.nextInt();
                        sc.nextLine();
                        List<Apartament> apartamentList = creteListApartment(howMany);
                        asocProp = new AsociatiaDeProprietari(apartamentList, codBancar);
                        System.out.println("Asociatia a fost creata cu succes, cu codul bancar " + codBancar);
                        app.insert(asocProp);
                    }
                    break;
                case 3:
                    app.exit();
                    return;
                default:
                    System.out.println("Nu exista o astfel de optiune");
            }
        }
    }

    private void categories() {
        while (true) {
            switch (drawCategoryMenu()) {
                case 1:
                    addLocatar();
                    break;
                case 2:
                    remouveLocatar();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nu exista o astfel de optiune");
            }
        }
    }

    private List<Apartament> creteListApartment(int howMany) {

        List<Apartament> apList = new ArrayList<>();

        for (int k = 0; k < howMany; ++k) {
            Integer nrApartament;
            Integer nrContoare;
            System.out.println("Introduceti numarul apartamentului");
            nrApartament = sc.nextInt();
            List<Contor> contorList = new ArrayList<>();
            Apartament apartament = new Apartament(nrApartament, contorList);
            System.out.println("Introduceti numarul contoarelor");
            nrContoare = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= nrContoare; i++) {
                contorList.add(createContor());
            }

            apList.add(apartament);
        }
        return apList;
    }


    private void remouveLocatar() {
        String cnpLocatar;

        System.out.println("Introduceti CNP-ul locatarului");
        cnpLocatar = sc.nextLine();

        Locatar locatar = new Locatar(cnpLocatar);
        asocProp.unregisterLocatar(locatar);
    }

    private void addLocatar() {
        Integer nrApartament;
        String cnpLocatar;
        String numeLocatar;
        String emailLocatar;

        System.out.println("Introduceti CNP-ul locatarului");
        cnpLocatar = sc.nextLine();
        System.out.println("Introduceti numele locatarului");
        numeLocatar = sc.nextLine();
        System.out.println("Introduceti mail-ul locatarului");
        emailLocatar = sc.nextLine();
        Locatar locatar = new Locatar(cnpLocatar, numeLocatar, emailLocatar);

        System.out.println("Introduceti numarul apartamentului");
        nrApartament = sc.nextInt();
        Apartament apartamentByNr = asocProp.findApartamentByNr(nrApartament);

        if (apartamentByNr != null) {
            app.insert(asocProp.registerLocatar(apartamentByNr, locatar));
        } else {
            System.out.println("Nu exista apartament cu acest numar");
        }

    }


    private Contor createContor() {
        String locatie;
        Integer contorIndex;
        System.out.println("Introduceti locatia contorului:");
        locatie = sc.nextLine();
        System.out.println("Introduceti indexul contorului:");
        contorIndex = sc.nextInt();
        sc.nextLine();
        Contor contor = new Contor(locatie, contorIndex, enumConorType());
        return contor;
    }

    private Contor.ContorType enumConorType() {
        System.out.println("Introduceti tipul contorului:");
        while (true) {
            switch (drawAlegeTipContor()) {
                case 1:
                    return Contor.ContorType.GAZ;
                case 2:
                    return Contor.ContorType.APA_CALDA;
                case 3:
                    return Contor.ContorType.APA_RECE;
                default:
                    System.out.println("Alegeti optiunea corecta.");
            }
        }
    }

    public Integer drawMainMenu() {
        System.out.println("\n***********************************");
        System.out.println("Operations: ");
        System.out.println("1. Adaugare sau stergere locatari");
        System.out.println("2. Crearea asociatiei");
        System.out.println("3. Exit");
        System.out.println();
        System.out.println("Alegeti optiunile de mai sus.");
        Integer optiune = sc.nextInt();
        sc.nextLine();
        return optiune;
    }

    private Integer drawCategoryMenu() {
        System.out.println("1. Inregistrare locatar");
        System.out.println("2. Stergere locatar");
        System.out.println("3. Return");
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAlegeTipContor() {
        System.out.println("1. GAZ");
        System.out.println("2. APA_CALDA");
        System.out.println("3. APA_RECE");
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}
