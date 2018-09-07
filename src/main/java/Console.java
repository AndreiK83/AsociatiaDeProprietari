import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console extends Main {
    private Scanner sc;
    private String prompt;
    AsociatiaDeProprietari asocProp;
    List<Apartament> apartamentList;
    Apartament apartament;

    public Console() {
        sc = new Scanner(System.in);
        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            System.out.println(prompt);
            switch (drawMainMenu()) {
                case 1:
                    categories();
                    break;
                case 2:
                    String codBancar;
                    codBancar = sc.nextLine();
                    if (asocProp == null) {
                        asocProp = AsociatiaDeProprietari.getAsociatiaDeProprietari(apartamentList, codBancar);
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
            prompt = ">";
            switch (drawCategoryMenu()) {
                case 1:
                    drawAddOrRemouveApartments();
                    addOrRemouveApartments();
                    break;
                case 2:
                    drawAddOrRemouveLocatari();
                    break;
                case 3:
                    drawAddOrRemouveContor();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nu exista o astfel de optiune");
            }
        }
    }

    private void addOrRemouveApartments() {
        Integer nrApartament;
        nrApartament = sc.nextInt();
        List<Contor> contorList = new ArrayList<>();
        apartament = new Apartament(nrApartament, contorList);
        apartamentList.add(apartament);
    }

    public Integer drawMainMenu() {
        System.out.println("\n***********************************");
        System.out.println("Operations: ");
        System.out.println("1. Modificare ASOCIATIE");
        System.out.println("2. Crearea asociatiei");
        System.out.println("3. Exit");
        System.out.print(prompt);
        Integer optiune = sc.nextInt();
        sc.nextLine();
        return optiune;
    }

    private Integer drawCategoryMenu() {
        System.out.println("1. Apartamente");
        System.out.println("2. Locatari");
        System.out.println("3. Contoare");
        System.out.println("4. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAddOrRemouveApartments() {
        System.out.println("1. Adauga apartament");
        System.out.println("2. Sterge apartament");
        System.out.println("3. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAddOrRemouveLocatari() {
        System.out.println("1. Adauga locatar");
        System.out.println("2. Sterge locatar");
        System.out.println("3. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer drawAddOrRemouveContor() {
        System.out.println("1. Adauga contor");
        System.out.println("2. Sterge locatar");
        System.out.println("3. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}
