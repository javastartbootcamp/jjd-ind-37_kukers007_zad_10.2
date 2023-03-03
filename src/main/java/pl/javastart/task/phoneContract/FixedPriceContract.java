package pl.javastart.task.phoneContract;

public class FixedPriceContract extends PhoneContract {

    double fixedPrice;


    public FixedPriceContract(double fixedPrice) {
        this.fixedPrice = fixedPrice;
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
        System.out.printf("Account Balance: %.2f\n", fixedPrice);
    }
}