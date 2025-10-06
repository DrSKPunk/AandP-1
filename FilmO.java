import java.util.Scanner;

class Kinofilm {
    private int traty;
    private int dohod;

    public Kinofilm() {
        this.dohod = 0;
        this.traty = 0;
    }

    public Kinofilm(int traty, int dohod) {
        this.traty = traty;
        this.dohod = dohod;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите траты: ");
        this.traty = scanner.nextInt();
        System.out.print("Введите доход: ");
        this.dohod = scanner.nextInt();
    }

    public double Okup() {
        if (traty == 0) return 0;
        return ((double) dohod / traty) * 100;
    }

    public void display() {
        System.out.println("Траты = " + traty + " Доходы = " + dohod + " Окупаемость = " + String.format("%.2f", Okup()) + "%");
    }

    public int getTraty() {
        return traty;
    }

    public int getDohod() {
        return dohod;
    }
}

class Studio {
    private String name;
    private Kinofilm[] films;
    private int[] sbory;

    public Studio() {
        this.name = "";
        this.films = new Kinofilm[3];
        this.sbory = new int[3];
        for (int i = 0; i < 3; i++) {
            films[i] = new Kinofilm();
        }
    }

    public Studio(String name, Kinofilm[] films, int[] sbory) {
        this.name = name;
        this.films = films;
        this.sbory = sbory;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название киностудии: ");
        this.name = scanner.nextLine();

        System.out.println("Введите данные о 3 фильмах:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Фильм " + (i + 1) + ":");
            films[i].read();
        }

        System.out.println("Введите доход от проката в других странах для 3 фильмов:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Доход для фильма " + (i + 1) + ": ");
            sbory[i] = scanner.nextInt();
        }
    }

    public void display() {
        System.out.println("Киностудия: " + name);
        System.out.println("Фильмы:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Фильм " + (i + 1) + ": ");
            films[i].display();
            System.out.println("Доход от проката в других странах: " + sbory[i]);
        }
        System.out.println("Суммарный доход киностудии: " + calculate());

        Kinofilm mostProfitable = coolfilm();
        System.out.print("Самый окупаемый фильм: ");
        mostProfitable.display();
    }

    public int calculate() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += films[i].getDohod() + sbory[i];
        }
        return total;
    }

    public Kinofilm coolfilm() {
        double maxF = 0;
        int mostF = 0;

        for (int i = 0; i < 3; i++) {
            int totalRevenue = films[i].getDohod() + sbory[i];
            double profitability = ((double) totalRevenue / films[i].getTraty()) * 100;

            if (profitability > maxF) {
                maxF = profitability;
                mostF = i;
            }
        }
        return films[mostF];
    }
}

public class FilmO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kinofilm film1 = new Kinofilm();
        film1.read();
        film1.display();

        Kinofilm film2 = new Kinofilm(5000000, 7500000);
        film2.display();

        Studio studio = new Studio();
        studio.read();
        studio.display();

        Kinofilm[] films = {
                new Kinofilm(1000000, 1500000),
                new Kinofilm(2000000, 3500000),
                new Kinofilm(3000000, 2500000)
        };

        int[] foreignRevenue = {500000, 1000000, 2000000};

        Studio studio2 = new Studio("20ВЕКФОКС", films, foreignRevenue);
        studio2.display();

        scanner.close();
    }
}