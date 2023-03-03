package pl.javastart.task.phoneContract;

public class Mix extends PhoneContract{

    private double accountBalance;
    private double oneMinuteCallCost;
    private int smsAmount;
    private int mmsAmount;
    private int freeCallMinutes;
    private double smsPrice;
    private double mmsPrice;

    public Mix(double accountBalance, int smsAmount, int mmsAmount, int freeCallMinutes) {
        this.accountBalance = accountBalance;
        this.smsAmount = smsAmount;
        this.mmsAmount = mmsAmount;
        this.freeCallMinutes = freeCallMinutes;
    }


    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getOneMinuteCallCost() {
        return oneMinuteCallCost;
    }

    public void setOneMinuteCallCost(double oneMinuteCallCost) {
        this.oneMinuteCallCost = oneMinuteCallCost;
    }

    public int getSmsAmount() {
        return smsAmount;
    }

    public void setSmsAmount(int smsAmount) {
        this.smsAmount = smsAmount;
    }

    public int getMmsAmount() {
        return mmsAmount;
    }

    public void setMmsAmount(int mmsAmount) {
        this.mmsAmount = mmsAmount;
    }

    public int getFreeCallMinutes() {
        return freeCallMinutes;
    }

    public void setFreeCallMinutes(int freeCallMinutes) {
        this.freeCallMinutes = freeCallMinutes;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public double getMmsPrice() {
        return mmsPrice;
    }

    public void setMmsPrice(double mmsPrice) {
        this.mmsPrice = mmsPrice;
    }

    @Override
    public int sendSms() {
        int index = 0;
        if (smsAmount > 0) {
            smsAmount -= 1;
            System.out.println("SMS sent");
            index++;
        } else if (smsAmount == 0) {
            accountBalance -= smsPrice;
            System.out.println("SMS sent");
            index++;
        } else if (accountBalance == 0) System.out.println("No more funds Dude. You cant send a SMS, sorry.");
        return index;
    }

    @Override
    public void call(int seconds) {
        int oneMinute = 60;
        if (freeCallMinutes >= seconds / oneMinute) {
            freeCallMinutes -= seconds / oneMinute;
            System.out.println(seconds);
        } else if (freeCallMinutes < seconds / oneMinute) {
            accountBalance -= ((double) seconds / oneMinute * oneMinuteCallCost);
            System.out.println(seconds);
        } else
            System.out.println("You cant call dude, sorry :( ");
    }

    @Override
    public int sendMms() {
        int index = 0;
        if (mmsAmount > 0) {
            mmsAmount -= 1;
            System.out.println("SMS sent");
            index++;
        } else if (mmsAmount == 0) {
            accountBalance -= mmsPrice;
            System.out.println("SMS sent");
            index++;
        } else if (accountBalance == 0) {
            System.out.println("No more funds, Dude. You cant send a MMS, sorry.");
        }
        return index;
    }

    @Override
    public void printAccountState() {
        System.out.printf("SMS left: %.2d\n", smsAmount);
        System.out.printf("MMS left: %.2d\n", mmsAmount);
        System.out.printf("Minutes left : %.2d\n", freeCallMinutes);
        System.out.printf("Amount left: %.2f \n", accountBalance);

    }
}