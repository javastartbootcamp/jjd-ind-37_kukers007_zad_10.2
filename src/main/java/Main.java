import phone.Phone;

import pl.javastart.task.phonecontract.Mix;
import pl.javastart.task.phonecontract.Prepaid;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new Mix(5, 1, 1, 1, 2, 2, 2));

        phone.call(60);

        phone.sendSms();

        phone.printAccountState();

        phone.call(60);

        phone.printAccountState();

        phone.call(60);

        phone.printAccountState();

        phone.call(60);

        phone.printAccountState();

        phone.call(70);

        phone.printAccountState();
    }
}