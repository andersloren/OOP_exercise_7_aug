package lexicon;

public class BankAccount {
    // Fields
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;
    private static int counter = 1;

    // Telescope constructor
    public BankAccount() {
    }

    // Constructor
    public BankAccount(double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = counter++;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    // Methods
    public void deposit(double deposit) {
        if (deposit < 0.0) throw new IllegalArgumentException("You cannot deposit a negative amount!");
        this.balance += deposit;
    }

    public void withdraw(double withdraw) {
        if (withdraw < 0.0) throw new IllegalArgumentException("You cannot withdraw a negative amount!");
        if (checkBalance(withdraw)) {
            this.balance -= withdraw;
        } else {
            System.out.println("There is not enough balance to withdraw that amount of money");
        }
    }

    public boolean checkBalance(double withdraw) {
        return (balance - withdraw > 0);
    }

    // Getters & Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("You cannot set the balance to be negative!");
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String bankAccountInfo() {
        return "This bank account belongs to: " + customerName +
                ", BankAccount number: " + accountNumber +
                ", Email: " + email +
                ", Phonenumber: " + phoneNumber;
    }
}
