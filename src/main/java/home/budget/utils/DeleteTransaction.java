package home.budget.utils;

import home.budget.TransactionDAO;

import java.util.Scanner;

public class DeleteTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji, którą chcesz usunąć:");
        long id = scanner.nextLong();
        scanner.nextLine();

        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.delete(id);
        System.out.println("Usunięto transakcję!");
    }
}
