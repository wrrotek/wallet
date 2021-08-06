import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class TransactionAdd {
    public static void add() {
        Scanner scanner = new Scanner(System.in);

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

        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.insert(transaction);
        System.out.println("Dodano do bazy danych!");

    }
}
