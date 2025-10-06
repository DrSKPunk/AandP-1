import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Arrays{
    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введите ваши числа");
            String numbers = scanner.nextLine() + " ";

            String x = "";
            boolean Error = false;

            for (int i = 0; i < numbers.length(); i++) {
                if (numbers.charAt(i) != ' ') {
                    x += numbers.charAt(i);
                } else {
                    if (!x.isEmpty()) {
                        try {
                            list1.add(Integer.parseInt(x));
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: '" + x + "' не является числом! Попробуйте снова.");
                            list1.clear();
                            Error = true;
                            break;
                        }
                    }
                    while (i < numbers.length() - 1 && numbers.charAt(i + 1) == ' ') {
                        i++;
                    }
                    x = "";
                }
            }

            if (!Error) {
                validInput = true;
            }
        }

        System.out.println("Введите число K (больше 0, меньше " + list1.size() + ")");
        int K = scanner.nextInt() - 2;
        System.out.println("Введите число L (больше " + K + ", меньше " + list1.size() + ")");
        int L = scanner.nextInt() - 1;

        for (int i = L; i > K; i--) {
            list2.add(list1.get(i));
        }
        System.out.println(list2);
        scanner.close();

    }
}