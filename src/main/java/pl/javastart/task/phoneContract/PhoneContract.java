package pl.javastart.task.phoneContract;

public class PhoneContract implements UsingPhone{
    @Override
    public void call(int seconds) {

    }

    @Override
    public int sendSms() {
        return 0;
    }

    @Override
    public int sendMms() {
        return 0;
    }

    @Override
    public void printAccountState() {

    }
}