package pl.javastart.task.phoneContract;

public abstract class PhoneContract {
    int smsSent;
    int mmsSent;
    double callSecond;

    public abstract void call(int seconds);

    public abstract void sendSms();

    public abstract void sendMms();

    public void printAccountState() {
        System.out.println("===Account Balance===");
        System.out.printf("SMS sent: %d \n", smsSent);
        System.out.printf("MMS sent: %d \n", mmsSent);
        System.out.printf("You have called for: %.1f seconds \n", callSecond);

    }
}