package home.budget.utils;

import home.budget.Transaction;
import home.budget.TransactionDAO;

import java.util.Scanner;

public class FindTransaction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz rodzaj transakcji aby wyświetlić przychody lub wydatki:");
        String type = scanner.nextLine();

        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction transaction = transactionDAO.findByType(type);
        System.out.println(transaction);
    }
}
