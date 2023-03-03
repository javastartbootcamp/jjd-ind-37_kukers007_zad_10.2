package pl.javastart.task.phoneContract;

public class Contract extends PhoneContract{

    private double fixedPrice;

    public Contract(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    @Override
    public int sendSms() {
        int index = 0;
        System.out.println("SMS sent");
        return index++;
    }

    @Override
    public void call(int seconds) {
        System.out.println("Call " + seconds);
    }

    @Override
    public int sendMms() {
        int index = 0;
        System.out.println("MMS sent");
        return index++;
    }

    @Override
    public void printAccountState() {
        System.out.printf("Account Balance: %.2f", fixedPrice);
    }
}