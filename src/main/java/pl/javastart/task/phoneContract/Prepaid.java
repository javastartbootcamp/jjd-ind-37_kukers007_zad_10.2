package pl.javastart.task.phoneContract;

public class Prepaid extends PhoneContract{

    private double accountBalance;
    private double smsPrice;
    private double mmsPrice;
    private double costOneMinuteCall;


    public Prepaid (double accountBalance, double smsPrice, double mmsPrice, double costOneMinuteCall) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.costOneMinuteCall = costOneMinuteCall;
    }

    @Override
    public int sendSms() {
        int index = 0;
        if (accountBalance >= smsPrice) {
            accountBalance -= smsPrice;
            System.out.println("SMS sent");
            index++;
        } else
            System.out.println("Not enough funds on account.");
        return index;
    }

    @Override
    public void call(int seconds) {
        int oneMinute = 60;
        if (accountBalance > ((double)seconds/oneMinute * costOneMinuteCall)) {
           System.out.println("You called for: " + seconds + "seconds");
        } else if (accountBalance < ((double) seconds/oneMinute * costOneMinuteCall))
            System.out.println("You cant call now, not enought funds :( ");
    }

    @Override
    public int sendMms() {
        int index = 0;
        if (accountBalance >= mmsPrice) {
            accountBalance -= mmsPrice;
            System.out.println("MMS sent");
            index++;
        } else
            System.out.println("Not enough funds on account.");
        return index;
    }

    @Override
    public void printAccountState() {
        System.out.printf("Account Balance: %.2f €", accountBalance);
    }
}