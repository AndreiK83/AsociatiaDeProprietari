import java.util.List;
import java.util.Scanner;

public class Console extends Main {
    private Scanner sc;
    private String prompt;
    AsociatiaDeProprietari asocProp;
    List<Apartament> apartamentList;

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

    private Integer addOrRemouveApartments() {
        System.out.println("1. Adauga apartament");
        System.out.println("2. Sterge apartament");
        System.out.println("3. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer addOrRemouveLocatari() {
        System.out.println("1. Adauga locatar");
        System.out.println("2. Sterge locatar");
        System.out.println("3. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    private Integer addOrRemouveContor() {
        System.out.println("1. Adauga contor");
        System.out.println("2. Sterge locatar");
        System.out.println("3. Return");
        System.out.print(prompt);
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}
