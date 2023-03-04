package pl.javastart.task.phonecontract;

public class Mix extends Prepaid {

    private int smsPackage;
    private int mmsPackage;
    private double freeMinutesPackage;

    public Mix(double accountBalance, double smsPrice, double mmsPrice, double costOneMinuteCall, int smsPackage, int mmsPackage, double freeMinutesPackage) {
        super(accountBalance, smsPrice, mmsPrice, costOneMinuteCall);
        this.smsPackage = smsPackage;
        this.mmsPackage = mmsPackage;
        this.freeMinutesPackage = freeMinutesPackage;
    }

    @Override
    public void sendSms() {
        if (smsPackage > 0) {
            smsPackage -= 1;
            System.out.println("You have sent a SMS");
            smsSent++;
        } else {
            super.sendSms();
        }
    }

    @Override
    public void call(int seconds) {
        double callTime = 0;
        double freeCallSeconds = freeMinutesPackage * 60;
        while (freeCallSeconds > 0 && seconds > 0) {
            freeCallSeconds--;
            seconds--;
            callTime++;
        }
        freeMinutesPackage -= callTime / 60;
        callSecond += callTime;
        if (seconds > 0) {
            super.call(seconds);
        }
    }

    @Override
    public void sendMms() {
        if (mmsPackage > 0) {
            mmsPackage -= 1;
            System.out.println("You have sent a MMS");
            mmsSent++;
        } else {
            super.sendMms();
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.printf("SMS Package: %d\n", mmsPackage);
        System.out.printf("MMS Package: %d\n", mmsPackage);
        System.out.printf("Free minutes package: %.2f\n", freeMinutesPackage);

    }
}