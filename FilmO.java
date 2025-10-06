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
    private Kinofilm film1;
    private Kinofilm film2;
    private Kinofilm film3;
    private int sbory1;
    private int sbory2;
    private int sbory3;

    public Studio() {
        this.name = "";
        this.film1 = new Kinofilm();
        this.film2 = new Kinofilm();
        this.film3 = new Kinofilm();
        this.sbory1 = 0;
        this.sbory2 = 0;
        this.sbory3 = 0;
    }

    public Studio(String name, Kinofilm film1, Kinofilm film2, Kinofilm film3, int sbory1, int sbory2, int sbory3) {
        this.name = name;
        this.film1 = film1;
        this.film2 = film2;
        this.film3 = film3;
        this.sbory1 = sbory1;
        this.sbory2 = sbory2;
        this.sbory3 = sbory3;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название киностудии: ");
        this.name = scanner.nextLine();

        System.out.println("Введите данные о 3 фильмах:");

        System.out.println("Фильм 1:");
        this.film1 = new Kinofilm();
        film1.read();

        System.out.println("Фильм 2:");
        this.film2 = new Kinofilm();
        film2.read();

        System.out.println("Фильм 3:");
        this.film3 = new Kinofilm();
        film3.read();

        System.out.println("Введите доход от проката в других странах для 3 фильмов:");
        System.out.print("Доход для фильма 1: ");
        this.sbory1 = scanner.nextInt();
        System.out.print("Доход для фильма 2: ");
        this.sbory2 = scanner.nextInt();
        System.out.print("Доход для фильма 3: ");
        this.sbory3 = scanner.nextInt();
    }

    public void display() {
        System.out.println("Киностудия: " + name);
        System.out.println("Фильмы:");

        System.out.print("Фильм 1: ");
        film1.display();
        System.out.println("Доход от проката в других странах: " + sbory1);

        System.out.print("Фильм 2: ");
        film2.display();
        System.out.println("Доход от проката в других странах: " + sbory2);

        System.out.print("Фильм 3: ");
        film3.display();
        System.out.println("Доход от проката в других странах: " + sbory3);

        System.out.println("Суммарный доход киностудии: " + calculate());

        Kinofilm mostProfitable = coolfilm();
        System.out.print("Самый окупаемый фильм: ");
        mostProfitable.display();
    }

    public int calculate() {
        int total = film1.getDohod() + film2.getDohod() + film3.getDohod() +
                sbory1 + sbory2 + sbory3;
        return total;
    }

    public Kinofilm coolfilm() {
        double profit1 = ((double) (film1.getDohod() + sbory1) / film1.getTraty()) * 100;
        double profit2 = ((double) (film2.getDohod() + sbory2) / film2.getTraty()) * 100;
        double profit3 = ((double) (film3.getDohod() + sbory3) / film3.getTraty()) * 100;

        if (profit1 >= profit2 && profit1 >= profit3) {
            return film1;
        } else if (profit2 >= profit1 && profit2 >= profit3) {
            return film2;
        } else {
            return film3;
        }
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

        Kinofilm f1 = new Kinofilm(1000000, 1500000);
        Kinofilm f2 = new Kinofilm(2000000, 3500000);
        Kinofilm f3 = new Kinofilm(3000000, 2500000);

        Studio studio2 = new Studio("20ВЕКФОКС", f1, f2, f3, 500000, 1000000, 2000000);
        studio2.display();

        scanner.close();
    }
}