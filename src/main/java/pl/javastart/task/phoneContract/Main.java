package pl.javastart.task.phoneContract;

public class Main {

    public static void main(String[] args) {
        UsingPhone phone = new Phone(new Contract(450));

        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

    }
}