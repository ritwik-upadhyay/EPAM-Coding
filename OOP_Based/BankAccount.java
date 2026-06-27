public class BankAccount {
    //Private Attributes (Encapsulation) 
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    //Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        //Prevent negative initial balance
        if(balance>=0) {
            this.balance = balance;
        }
        else {
            this.balance = 0;
        }
    }
    //Deposit method
    public void deposit(double amount) {
        if(amount<=0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += amount;
        System.out.println("Deposited amount: "+amount);
    }
    //Withdraw method
    public void withdraw(double amount) {
        if(amount<=0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }
        if(amount>balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn amount: "+amount);
    }
    //Display Balance method
    public void displayBalance() {
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolderName);
        System.out.println("Current Balance: "+balance);
    }
    //Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    //Main method
    public static void main(String[] args) {
        //Create Bank Account Object
        BankAccount account = new BankAccount("ACC101", "Ritwik", 5000);
        System.out.println("Initial Account Details");
        account.displayBalance();
        //Deposit money
        System.out.println("\nAfter Deposit");
        account.deposit(2000);
        account.displayBalance();
        //Withdraw money
        System.out.println("\nAfter Withdrawal");
        account.withdraw(1500);
        account.displayBalance();
        //Invalid withdrawal
        System.out.println("\nAttempt Large Withdrawal");
        account.withdraw(10000);
        //Invalid deposit
        System.out.println("\nAttempt Invalid Deposit");
        account.deposit(-500);
        //Invalid withdrawal amount
        System.out.println("\nAttempt Invalid Withdrawal");
        account.withdraw(-200);
    }
}