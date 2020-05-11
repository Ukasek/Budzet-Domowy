package home.budget.utils;

import home.budget.Transaction;
import home.budget.TransactionDAO;

import java.util.Scanner;

public class AddTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj typ transakcji:");
        String type = scanner.nextLine();

        System.out.println("Podaj opis:");
        String description = scanner.nextLine();

        System.out.println("Wartość transakcji:");
        double amount = scanner.nextDouble();

        System.out.println("Data transakcji:");
        int date = scanner.nextInt();


        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.save(transaction);
    }
}
