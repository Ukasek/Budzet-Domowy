package home.budget.utils;

import home.budget.Transaction;
import home.budget.TransactionDao;

import java.util.Optional;
import java.util.Scanner;

public class FindTransaction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz rodzaj transakcji aby wyświetlić przychody lub wydatki:");
        String type = scanner.nextLine();

        TransactionDao transactionDao = new TransactionDao();
        Optional<Transaction> transaction = transactionDao.findByType(type);
        System.out.println(transaction);
    }
}
