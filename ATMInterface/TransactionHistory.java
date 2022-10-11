package ATMInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransactionHistory {






//    class TransactionHistory{
        String transaction;
        TransactionHistory next;

        public TransactionHistory(String transaction) {
            this.transaction = transaction;
            next = null;
        }

    }

    class Account {
        String name;
        String userName;
        String password;
        String accountNo;
        int balance = 10000;
        //        int Saving root=null;
        static TransactionHistory head = null;

        public void insertTransaction(String transaction) {
            if (head == null) {
                head = new TransactionHistory(transaction);
                return;
            }
            TransactionHistory cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new TransactionHistory(transaction);
        }


        public void register() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter Your Name: ");
            this.name = br.readLine();

            System.out.print("\nEnter Your UserName: ");
            this.userName =br.readLine();

            System.out.print("\nEnter Your Password: ");
            this.password =br.readLine();

            System.out.print("\nEnter Your Account Number: ");
            this.accountNo =br.readLine();



            System.out.print("\nYour Registration completed");

        }

        public boolean login() throws IOException{
            boolean flag = false;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(!flag) {
                System.out.print("\nEnter Your UserName: ");
                String UserName = br.readLine();

                if(UserName.equals(userName)) {
                    while(!flag) {
                        System.out.print("\nEnter Your Password: ");
                        String Password = br.readLine();
                        if(Password.equals(password)) {
                            System.out.print("\nSuccessfully Logged In");
                            flag = true;
                        }else {
                            System.out.print("\nPlease Enter Correct Password");
                        }
                    }
                }else {
                    System.out.println("\nUserName Not Found");
                }
            }
            return flag;
        }

        public void deposit() throws IOException{
            System.out.print("\nEnter the amount to deposit less than Rs. 10 Lakh: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int amount = Integer.parseInt(br.readLine());

            if(amount <= 1000000) {
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String amountDeposit = amount + " Rs. Deposited";
                insertTransaction(amountDeposit);
            }
        }

        public void withDraw() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter the amount to withdraw: ");
            int amount = Integer.parseInt(br.readLine());

            if(balance >= amount) {
                balance -= amount;
                System.out.println("\nWithdrawal Completed Successfully");
                String amountWithDraw = amount+" Rs. Withdrawal";
                insertTransaction(amountWithDraw);
            }else {
                System.out.println("Insufficient Account Balance");
            }
        }

        public void transferAmount() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nEnter the Account Number: ");
            String accountNumber = br.readLine();
            System.out.print("\nEnter the amount to transfer less than 50 thousand: ");
            int amount = Integer.parseInt(br.readLine());

            if(balance >= amount) {
                if (amount <= 50000) {
                    balance -= amount;
                    System.out.println("\nAmount Transfered Successfully");
                    String transfer = "Rs." + amount + " is transfered to Account Number " + accountNumber;
                    insertTransaction(transfer);
                } else {
                    System.out.println("Sorry the amount will not transferd");
                }
            }
            else {
                System.out.println("\nInsufficient Account Balance");
            }
        }

        public void checkBalance() {
            System.out.println("\nRs."+balance+":- is your current balance");
        }

        public void printTransactionHistory() {
            System.out.println();
            TransactionHistory cur = head;
            if(head == null) {
                System.out.println("No Transaction Occured");
            }else {
                while(cur != null) {
                    System.out.println(cur.transaction);
                    cur = cur.next;
                }
            }
        }
}
