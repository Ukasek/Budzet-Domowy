package home.budget.utils;

import home.budget.Transaction;
import home.budget.TransactionDao;

import java.util.Scanner;

public class UpdateTransaction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz edytować:");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Podaj tytuł transakcji:");
        String type = scanner.nextLine();

        System.out.println("Podaj opis:");
        String description = scanner.nextLine();

        System.out.println("Wartość transakcji:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Data transakcji:");
        String date = scanner.nextLine();


        Transaction transaction = new Transaction(id, type, description, amount, date);

        TransactionDao transactionDAO = new TransactionDao();
        transactionDAO.update(transaction);
    }
}
