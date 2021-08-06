import java.util.Scanner;

public class TransactionRead {

    public static void read() {

        Scanner scanner = new Scanner(System.in);
        TransactionDao transactionDao = new TransactionDao();
        Transaction transaction = null;

        System.out.println("Wybierz co chcesz wyświetlić");
        System.out.println("1. Wypłaty");
        System.out.println("2. Wpłaty");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1" -> transaction = transactionDao.findByType(Transaction.type.WPŁATA);
            case "2" -> transaction = transactionDao.findByType(Transaction.type.WYPŁATA);
            default -> System.out.println("Błędny wybór!");
        }
        System.out.println(transaction);

    }
}
