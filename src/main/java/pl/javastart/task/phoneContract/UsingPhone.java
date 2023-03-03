package pl.javastart.task.phoneContract;

public interface UsingPhone {
    void call(int seconds);

    int sendSms();

    int sendMms();

    void printAccountState();
}