import org.andestech.learning.rfb19.g4.homework2.Account;
import org.andestech.learning.rfb19.g4.homework2.Customer;

public class CreditAccount extends Account {

    private CreditAccount() {
    }

    private CreditAccount(int accountId, double balance, Customer customer) {
        super(accountId, balance, customer);
    }



    //фабричный метод
    public static CreditAccount createAccount(int id, double balance, Customer customer) {
        if(customer.getAge() <= 18 && customer.getAge() >= 70) {
            System.out.println("Возраст не подходит!");
            return null;
        } else if (balance < 0) {
            System.out.println("Отрицательный баланс!");
            return null;
        } else {
            System.out.println("Создание кредитного счета.");
            return new CreditAccount(id, balance, customer);
        }
    }




    @Override
    public void withdrawal(double money) {
        System.out.println("Снимаем деньги с кредитного счета.");
        if(isDeltaValid(money)) {
            double balance = getBalance() - money;
            setBalance(balance);
            System.out.println("На счету " + balance);
        }
    }

    @Override
    public void putMoney(double money) {
        System.out.println("Кладем деньги на кредитный счет.");
        if(isDeltaValid(money)) {
            double balance = getBalance() + money;
            setBalance(balance);
            System.out.println("На счету " + balance);
        }
    }
}
