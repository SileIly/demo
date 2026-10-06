import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int bestTry = Integer.MAX_VALUE;
        boolean gameRun = true;

        System.out.println("Игра «Кинуть кости» ");
        System.out.println("Компьютером загадано число от 1 до 100");
        System.out.println("Введите число, чтобы попытаться угадать число");
        System.out.println("Введите INFO для просмотра статистики");
        System.out.println("Введите EXIT для того чтобы покинуть игру");

        while (gameRun) {
            int GuessNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            while (!guessed && gameRun) {

                System.out.println("Введите число или команду");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("INFO")) {
                    System.out.println("Текущее количество попыток: " + attempts);

                    if (bestTry == Integer.MAX_VALUE) {
                        System.out.println("Количество попыток в лучшей игре: попыток угадывания чисел не предпринято");
                    } else {
                        System.out.println("Количество попыток в лучшей игре: " + bestTry);
                    }
                    continue;
                }

                if (input.equalsIgnoreCase("EXIT")) {
                    System.out.println("Игра завершена, спасибо за участие!");
                    gameRun = false;
                    continue;
                }

                int userNumber;
                try {
                    userNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Введите число от 1 до 100 или одну из представленных команд.");
                    continue;

                }
                attempts++;
                if (userNumber == GuessNumber) {
                    guessed = true;

                    System.out.println("Поздравляю, ты угадал число");
                    System.out.println("Загаданное компьютером число: " + GuessNumber);
                    System.out.println("Количество попыток: " + attempts);

                    if (attempts < bestTry) {
                        bestTry = attempts;
                        System.out.println("Предыдущий рекорд побит, это новый лучший результат");
                    }
                    System.out.println("Результаты: ");
                    System.out.println("Текущее количество попыток: " + attempts);
                    System.out.println("Количество попыток в лучшей игре: " + bestTry);
                } else if (userNumber < GuessNumber) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                } else {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                }
            }
            if (gameRun) System.out.print("Сыграть ещё раз? (да/нет)");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("да")) {
                gameRun = false;
                System.out.println("Спасибо за игру!");
            }
        }             scanner.close();
    }
}