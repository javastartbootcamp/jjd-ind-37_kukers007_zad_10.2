package pl.javastart.task.phonecontract;

public class FixedPriceContract extends PhoneContract {

    double accountBalance;

    public FixedPriceContract(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void sendSms() {
        smsSent++;
        System.out.println("You have sent a SMS");
    }

    @Override
    public void call(int seconds) {
        callSecond += seconds;
    }

    @Override
    public void sendMms() {
        mmsSent++;
        System.out.println("You have sent a MMS");
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.printf("Account Balance: %.2f\n", accountBalance);
    }
}