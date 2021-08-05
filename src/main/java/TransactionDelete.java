import java.util.Scanner;

public class TransactionDelete {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Usuwanie");
        System.out.println("Podaj Id tansakcji");
        Long id = scanner.nextLong();
        scanner.nextLine();

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.deleteById(id);
        System.out.println("Usunięto!");

    }
}
