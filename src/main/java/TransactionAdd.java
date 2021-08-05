import java.util.Scanner;

public class TransactionAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dodawanie");
        System.out.println("Podaj typ");
        String type = scanner.nextLine();

        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();

        System.out.println("Podaj wartość");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj datę transakcji w formacie RRRR-MM-DD");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.insert(transaction);

    }
}
