package home.budget;

import home.budget.utils.AddTransaction;
import home.budget.utils.DeleteTransaction;
import home.budget.utils.FindTransaction;
import home.budget.utils.UpdateTransaction;

import java.util.Scanner;

public class TransactionApp {
    public static void main(String[] args) {
        System.out.println("Co chcesz zrobic?");
        System.out.println("1.Dodawanie");
        System.out.println("2.Wyszukiwanie");
        System.out.println("3.Aktualizacja");
        System.out.println("4.Usuwanie");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                AddTransaction.main(new String[0]);
                break;
            case "2":
                FindTransaction.main(new String[0]);
                break;
            case "3":
                UpdateTransaction.main(new String[0]);
                break;
            case "4":
                DeleteTransaction.main(new String[0]);
                break;
            default:
                System.out.println("Błędny wybór");
        }
    }
}
