package pl.javastart.task.phonecontract;

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
        int callDuration = 0;
        while (accountBalance > 0 && seconds > 0) {
            accountBalance -= oneSecondCallCost;
            seconds--;
            callDuration++;
        }
        callSecond += callDuration;
        if (seconds > 0) {
            System.out.println("!!!Call ended!!!");
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