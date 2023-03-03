import Phone.Phone;
import pl.javastart.task.phoneContract.Mix;


public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new Mix(20, 2, 2, 3));

        phone.printAccountState();

        phone.call(60);
        phone.sendSms();
        phone.printAccountState();

        phone.call(60);

        phone.printAccountState();

        phone.call(60);

        phone.printAccountState();

        phone.call(90);

        phone.printAccountState();
    }
}