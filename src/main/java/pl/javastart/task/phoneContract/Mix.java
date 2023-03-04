package pl.javastart.task.phoneContract;

public class Mix extends Prepaid {

    private int smsAmount;
    private int mmsAmount;
    private int freeCallMinutes;

    public Mix(double accountBalance, int smsAmount, int mmsAmount, int freeCallMinutes) {
        super();
        this.accountBalance = accountBalance;
        this.smsAmount = smsAmount;
        this.mmsAmount = mmsAmount;
        this.freeCallMinutes = freeCallMinutes;
    }

    @Override
    public void sendSms() {
        if (smsAmount > 0) {
            smsAmount -= 1;
            System.out.println("You have sent a SMS");
            smsSent++;
        } else if (smsAmount == 0) {
            accountBalance -= smsPrice;
            System.out.println("You have sent a SMS");
        } else if (accountBalance == 0) {
            super.sendSms();
        }
    }

    @Override
    public void call(int seconds) {
        int freeCallSeconds = freeCallMinutes * 60;
        callSecond = seconds;

        while (freeCallSeconds >= 0) {
            freeCallSeconds--;
            seconds--;
            if (seconds == 0) {
                break;
            }
            if (freeCallSeconds == 0) {
                super.call(seconds);
            }
        }
        freeCallMinutes = freeCallSeconds / 60;
    }

    @Override
    public void sendMms() {
        if (mmsAmount > 0) {
            mmsAmount -= 1;
            System.out.println("You have sent a MMS");
            mmsSent++;
        } else if (mmsAmount == 0) {
            accountBalance -= mmsPrice;
            System.out.println("You have sent a MMS");
        } else {
            super.sendMms();
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.printf("SMS left: %d\n", smsAmount);
        System.out.printf("MMS left: %d\n", mmsAmount);
        System.out.printf("Free call minutes: %d\n", freeCallMinutes);

    }
}