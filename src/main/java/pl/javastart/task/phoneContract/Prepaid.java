package pl.javastart.task.phoneContract;

public class Prepaid extends PhoneContract {

    double accountBalance;
    double smsPrice;
    double mmsPrice;
    double costOneMinuteCall;

    public Prepaid(double accountBalance, double smsPrice, double mmsPrice, double costOneMinuteCall) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.costOneMinuteCall = costOneMinuteCall;
    }

    public Prepaid() {
    }

    @Override
    public void sendSms() {
        if (accountBalance >= smsPrice) {
            accountBalance -= smsPrice;
            System.out.println("You have sent a SMS");
            smsSent++;
        } else {
            System.out.println("Not enough funds on account.");
        }
    }

    @Override
    public void call(int seconds) {
        double oneSecondCallCost = costOneMinuteCall / 60;
        callSecond = seconds;
        int callDuration = 0;
        while (accountBalance > 0) {
            accountBalance -= oneSecondCallCost;
            callDuration++;
            if (accountBalance <= 0) {
                System.out.println("!!!Call ended!!!");
                callSecond = seconds - callDuration;
                break;
            }
            if (callDuration == seconds) {
                break;
            }
        }
    }

    @Override
    public void sendMms() {
        if (accountBalance >= mmsPrice) {
            accountBalance -= mmsPrice;
            System.out.println("You have sent a MMS");
            mmsSent++;
        } else {
            System.out.println("Not enough funds on account.");
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.printf("Account Balance: %.1f \n", accountBalance);
    }
}