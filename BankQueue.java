/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankqueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    private static int counter = 1; // Auto-increment number
    private int number;
    private String name;

    public Customer(String name) {
        this.name = name;
        this.number = counter++;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[" + number + "] " + name;
    }
}

public class BankQueue {
    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bank Queue System ---");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer customer = new Customer(name);
                    queue.add(customer);
                    System.out.println("Customer added: " + customer);
                    displayQueue(queue);
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No customers in the queue.");
                    } else {
                        Customer served = queue.poll();
                        System.out.println("Serving customer: " + served);
                    }
                    displayQueue(queue);
                    break;

                case 3:
                    displayQueue(queue);
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Helper method to display queue
    private static void displayQueue(Queue<Customer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Current queue: " + queue);
        }
    }
}

