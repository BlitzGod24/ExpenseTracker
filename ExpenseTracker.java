import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;
    String date;

    Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return "Category: " + category + " | Amount: ₹" + amount + " | Date: " + date;
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Search Expense by Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: totalExpense(); break;
                case 4: searchExpense(); break;
                case 5: System.out.println("Exiting... Thank you!"); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    static void addExpense() {
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        expenses.add(new Expense(category, amount, date));
        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
        } else {
            System.out.println("\nYour Expenses:");
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    static void totalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expense: ₹" + total);
    }

    static void searchExpense() {
        System.out.print("Enter category to search: ");
        String cat = sc.nextLine();
        boolean found = false;
        for (Expense e : expenses) {
            if (e.category.equalsIgnoreCase(cat)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("No expenses found for this category!");
    }
}
