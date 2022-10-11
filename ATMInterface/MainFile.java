package ATMInterface;
import java.io.*;
//public class MainFile {
//    package AtmInterface;




    public class MainFile  {


        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Account account = new Account();
            System.out.println("Press 1 to Register");
            System.out.println("Press 2 to Exit");
            System.out.print("Please Select an Option from :- 1 and 2 ");
            int choice = Integer.parseInt(br.readLine());

            if(choice == 1) {
                account.register();
                while(true) {
                    System.out.println("\nPress 1 for Login");
                    System.out.println("Press 2 for Exit");
                    System.out.print("Please Select an Option from :- 1 and 2 ");
                    int op = Integer.parseInt(br.readLine());
                    if(op == 1) {
                        if(account.login()) {
                            System.out.println("Welcome "+account.name);
                            boolean flag = false;
                            while(!flag) {
                                System.out.println("\n1.Deposit");
                                System.out.println("2.Withdraw");
                                System.out.println("3.Transfer Amount");
                                System.out.println("4.Transaction History");
                                System.out.println("5.Check Balance");
                                System.out.println("6.Exit");
                                System.out.print("\nPlease Select an Option from :- 1 to 6 ");
                                int ch = Integer.parseInt(br.readLine());
                                switch (ch) {
                                    case 1 -> account.deposit();
                                    case 2 -> account.withDraw();
                                    case 3 -> account.transferAmount();
                                    case 4 -> account.printTransactionHistory();
                                    case 5 -> account.checkBalance();
                                    case 6 -> flag = true;
                                }
                            }
                        }
                    }else {
                        System.exit(0);
                    }
                }
            }
            else {
                System.out.println("\nThank You"+account.name);
                System.exit(0);
            }
        }


}
