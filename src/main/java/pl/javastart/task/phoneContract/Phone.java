package pl.javastart.task.phoneContract;

public class Phone implements UsingPhone{

    public Phone(Contract contract) {

    }

    public void call(int seconds) {
    }

    public int sendSms() {
        return 0;
    }


    public int sendMms() {
        return 0;
    }

    public void printAccountState() {
        System.out.printf("SMS sent: %d \n", sendSms());
        System.out.printf("MMS sent: %d \n", sendMms());
    }
}