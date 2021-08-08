import java.time.LocalDate;
import java.util.Scanner;

public class TransactionUpdate {
    public static void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz zaktualizować");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Podaj typ: wpłata/wypłata");
        String type = scanner.nextLine();

        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();

        System.out.println("Podaj wartość");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj rok transakcji");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj miesiąc transakcji");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj dzień transakcji");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate date = LocalDate.of(year, month, day);

        Transaction transaction = new Transaction(id, type, description, amount, date);
        TransactionDao transactionDao = new TransactionDao();

        transactionDao.update(transaction);
        System.out.println("Zaktualizowano w bazie danych");

    }
}
