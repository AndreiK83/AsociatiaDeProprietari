import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console extends Main {
    HibernateLocatari app = new HibernateLocatari();
    private Scanner sc;
    //    private String prompt;
    AsociatiaDeProprietari asocProp;
    List<Apartament> apartamentList;
    Apartament apartament;

    public Console() {
        sc = new Scanner(System.in);
        mainMenu();
    }

    private void mainMenu() {
        while (true) {
//            System.out.println(prompt);
            switch (drawMainMenu()) {
                case 1:
                    categories();
                    app.insert(asocProp);
                    break;
                case 2:
                    String codBancar;
                    System.out.println("Introduceti codul bancar");
                    codBancar = sc.nextLine();
                    if (asocProp == null) {
                        asocProp = new AsociatiaDeProprietari(apartamentList, codBancar);
                        System.out.println("Asociatia a fost creata cu succes, cu codul bancar " + codBancar);
                    } else {
                        System.out.println("Exista asociatia cu codul bancar " + codBancar);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nu exista o astfel de optiune");
            }
        }
    }

    private void categories() {
        while (true) {
//            prompt = ">";
            switch (drawCategoryMenu()) {
                case 1:
                    addOrRemouveApartments();
                    break;
                case 2:
                    addOrRemouveLocatari();
                    break;
                case 3:
                    addOrRemouveContor();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nu exista o astfel de optiune");
            }
        }
    }

    private void addOrRemouveApartments() {
        while (true) {
            switch (drawAddOrRemouveApartments()) {
                case 1:
                    addApartment();
                    break;
                case 2:
                    remouveApartment();
                case 3:
                    return;
                default:
                    System.out.println("Va rog selectati optiunea corecta.");
            }
        }
    }

    private void addApartment() {
        Integer nrApartament;
        System.out.println("Introduceti numarul apartamentului");
        nrApartament = sc.nextInt();
        List<Contor> contorList = new ArrayList<>();
        apartament = new Apartament(nrApartament, contorList);
        apartamentList.add(apartament);
    }

    private void remouveApartment() {
    }

    public void addOrRemouveLocatari(){
        while (true) {
            switch (drawAddOrRemouveLocatari()) {
                case 1:
                    addLocatar();
                    break;
                case 2:
                    remouveLocatar();
                case 3:
                    return;
                default:
                    System.out.println("Va rog selectati optiunea corecta.");
            }
        }
    }

    private void remouveLocatar() {
    }

    private void addLocatar() {
    }

    public void addOrRemouveContor(){
        while (true) {
            switch (drawAddOrRemouveContor()) {
                case 1:
                    addContor();
                    break;
                case 2:
                    remouveContor();
                case 3:
                    return;
                default:
                    System.out.println("Va rog selectati optiunea corecta.");
            }
        }
    }

    private void addContor() {
    }

    private void remouveContor() {
    }

    public Integer drawMainMenu() {
        System.out.println("\n***********************************");
        System.out.println("Operations: ");
        System.out.println("1. Modificare ASOCIATIE");
        System.out.println("2. Crearea asociatiei");
        System.out.println("3. Exit");
        System.out.println();
        System.out.println("Alegeti optiunile de mai sus.");
//        System.out.print(prompt);
        Integer optiune = sc.nextInt();
        sc.nextLine();
        return optiune;
    }

    private Integer drawCategoryMenu() {
        System.out.println("1. Apartamente");
        System.out.println("2. Locatari");
        System.out.println("3. Contoare");
        System.out.println("4. Return");
//        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAddOrRemouveApartments() {
        System.out.println("1. Adauga apartament");
        System.out.println("2. Sterge apartament");
        System.out.println("3. Return");
//        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAddOrRemouveLocatari() {
        System.out.println("1. Adauga locatar");
        System.out.println("2. Sterge locatar");
        System.out.println("3. Return");
//        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAddOrRemouveContor() {
        System.out.println("1. Adauga contor");
        System.out.println("2. Sterge locatar");
        System.out.println("3. Return");
//        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}
