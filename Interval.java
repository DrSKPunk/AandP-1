import javax.swing.*;
import java.util.Scanner;

public class Interval {


    private int x1;
    private int x2;

    public void init(int x1, int x2) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);

    }

    public Interval(int x1, int x2) {
        init(x1, x2);
    }

    public Interval(){
        this(0, 0);
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x1: ");
        this.x1 = scanner.nextInt();
        System.out.print("Введите х2: ");
        this.x2 = scanner.nextInt();

        scanner.close();
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public void display() {
        System.out.println("Интервал: [" + x1 + "; " + x2 + "]" );
        System.out.println("Длина интервала = " + (x2 - x1));
    }

    public static Interval add(Interval firstInter, Interval lastInter) {
        return new Interval(firstInter.x1, lastInter.x2);
    }

    public static void main(String[] arg) {
        Interval interval1 = new Interval(10, 20);
        Interval interval2 = new Interval(33, 67);

        Interval summInter = Interval.add(interval1, interval2);

        Interval interval = new Interval();
        interval.read();
        System.out.println(interval.getX1() + " " + interval.getX2());

        System.out.println(summInter.getX1() + " " + summInter.getX2());
    }
}