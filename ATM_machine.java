import java.util.*;

class ATM{
    private double balance;
    private double depositeAmount;
    private double withdrawAmount;
    ATM(){

    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getDepositeAmount() {
        return depositeAmount;
    }
    public void setDepositeAmount(double depositeAmount) {
        this.depositeAmount = depositeAmount;
    }
    public double getWithdrawAmount() {
        return withdrawAmount;
    }
    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
interface AtmOperationInter{
     public void viewBalance();
     public void withdrawAmount(double withdrawAmount);
     public void depositAmount(double depositAmount);
     public void viewMinistatement();
}
class AtmOperationImpl implements AtmOperationInter{
    ATM atm = new ATM();
    Map<Double,String> ministmt = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balanceis : "+atm.getBalance());
    }
    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount%500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministmt.put(withdrawAmount, " Amount withdrawn");
                System.out.println("Collect the cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance...");
            }
        }
        else{
            System.out.println("Please enter the amount in multiple of 500");
        }
    }
    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount," Amount deposited");
        System.out.println(depositAmount+ " Deposited Successfully!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }
    @Override
    public void viewMinistatement(){
        for (Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+ ""+ m.getValue());
        }
    }
}

public class ATM_machine {
    public static void main(String[] args) {
        AtmOperationInter op = new AtmOperationImpl();
        int atmnumber = 12345;
        int atmpin = 123;
        System.out.println("Welcome to ATM machine!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ATM number : ");
        int atmNumber = sc.nextInt();
        System.out.print("Enter your ATM pin : ");
        int atmPin = sc.nextInt();
        if((atmnumber == atmNumber) && (atmpin == atmPin)){
            while (true){
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Ministetment\n5.Exit");
                System.out.print("Enter choice : ");
                int ch = sc.nextInt();
                if (ch == 1){
                    op.viewBalance();
                } else if (ch == 2) {
                    System.out.print("Enter amount to withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                } else if (ch == 3) {
                    System.out.print("Enter Amount to deposit : ");
                    double depositAmount = sc.nextDouble();
                    op.depositAmount(depositAmount);
                } else if (ch == 4) {
                    op.viewMinistatement();
                } else if (ch == 5) {
                    System.out.println("Collect your ATM card\nThank you for using me!");
                    System.exit(0);
                }else{
                    System.out.println("Please enter correct choice");
                }
            }
        }
        else{
            System.out.println("Incorrect ATM number and ATM pin...");
            System.exit(0);
        } 
    }
}
