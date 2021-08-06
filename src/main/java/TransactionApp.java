import java.util.Scanner;

public class TransactionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Dodawanie transakcji");
            System.out.println("2. Modyfikowanie transakcji");
            System.out.println("3. Usuwanie transakcji");
            System.out.println("4. Wyświetl transakcje");
            System.out.println("0. Koniec");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    TransactionAdd.add();
                    break;
                case "2":
                    TransactionUpdate.update();
                    break;
                case "3":
                    TransactionDelete.delete();
                    break;
                case "4":
                    TransactionRead.read();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Błędny wybór!");
            }
        }
    }
}
