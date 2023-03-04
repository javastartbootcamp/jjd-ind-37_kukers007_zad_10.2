package phone;

import pl.javastart.task.phonecontract.PhoneContract;

public class Phone {

    PhoneContract contract;

    public Phone(PhoneContract contract) {
        this.contract = contract;
    }

    public void call(int seconds) {
        contract.call(seconds);
    }

    public void sendSms() {
        contract.sendSms();
    }

    public void sendMms() {
        contract.sendMms();
    }

    public void printAccountState() {
        contract.printAccountState();
    }
}