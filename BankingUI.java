import java.util.Scanner;
import account.IBankAccount;

class BankingUI {

    private Scanner scanner;
    private Bank bank;

    public BankingUI(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean demonstrationIsOn = true;
        while (demonstrationIsOn) {
            clearScreen();
            System.out.println("====== Console App Demonstration of Banking Task ======");
            printGeneralOptionsMenu();
            int generalMenuChoice = scanner.nextInt();
            switch (generalMenuChoice) {
                case 1:
                    clearScreen();
                    printAccounts();
                    awaitUser();
                    break;
                case 2:
                    System.out.print("Please enter account ID: ");
                    IBankAccount chosenAccount = bank.getAccount(scanner.nextInt());
                    if (chosenAccount == null) {
                        System.out.println("Invalid id. Please try again!");
                    } else {
                        clearScreen();
                        openAccountDisplay(chosenAccount);
                    }
                    break;
                case 3:
                    clearScreen();
                    demonstrationIsOn = false;
                    break;
            }
        }
        System.out.println("See you another time!");
        scanner.close();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printGeneralOptionsMenu() {
        System.out.println("== Choose from: ==");
        System.out.println("1) Display all accounts");
        System.out.println("2) Choose an account");
        System.out.println("3) Exit");
        System.out.print("Please enter your choice: ");
    }

    private void printAccountOptionsMenu() {
        System.out.println("== Choose an option: ==");
        System.out.println("1) Check balance");
        System.out.println("2) Deposit amount");
        System.out.println("3) Withdraw amount");
        System.out.println("4) Transfer amount to another account");
        System.out.println("5) Get operation history as .txt");
        System.out.println("6) Exit");
        System.out.print("Please enter your choice: ");
    }

    private void awaitUser() {
        if (scanner.hasNextLine())
            scanner.nextLine(); //// Clear the newline if there is any leftover
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void openAccountDisplay(IBankAccount account) {
        boolean accountDisplay = true;
        while (accountDisplay) {
            clearScreen();
            printAccountOptionsMenu();
            int useOptionChoice = scanner.nextInt();
            switch (useOptionChoice) {
                case 1:
                    account.printBalance();
                    awaitUser();
                    break;
                case 2:
                    System.out.println("Enter the amount for deposit in range (0, 1000]");
                    int amountDeposit = scanner.nextInt();
                    try {
                        account.deposit(amountDeposit);
                        System.out.println("Amount deposited");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    awaitUser();
                    break;
                case 3:
                    System.out.println("Enter the amount for withdrawal (> 0)");
                    int amountWithdraw = scanner.nextInt();
                    try {
                        account.withdraw(amountWithdraw);
                        System.out.println("Amount witdrawed");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    awaitUser();
                    break;
                case 4:
                    System.out.print("Please enter the id of another account: ");
                    IBankAccount toAccount = bank.getAccount(scanner.nextInt());
                    if (toAccount == null) {
                        System.out.println("Invalid toAccount id");
                    } else {
                        System.out.print("Please enter the amount for transfer: ");
                        try {
                            account.transferToAnotherAccount(toAccount, scanner.nextInt());
                            System.out.println("Funds transferred succefully");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    awaitUser();
                    break;
                case 5:
                    try {
                        account.getTxtRecordOfOperations();
                        System.out.println("output_txt_reports have successfully been updated!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    awaitUser();
                    break;
                case 6:
                    accountDisplay = false;
                    break;
                default:
                    System.out.println("Invalid option of " + account + " provided. Try again.");
            }

        }
    }

    private void printAccounts() {
        for (IBankAccount account : bank.getAccounts())
            System.out.println(account);
    }
}