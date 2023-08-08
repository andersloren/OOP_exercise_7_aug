package lexicon;

public class App
{
    public static void main( String[] args ) {
        BankAccount bankAccount1 = new BankAccount(100, "Anders", "anders.loren@gmail.com", "0700000000");
        System.out.println(bankAccount1.bankAccountInfo());
        BankAccount bankAccount2 = new BankAccount(200, "Erik", "erik.svensson@gmail.com", "0700000001");
        System.out.println(bankAccount2.bankAccountInfo());


    }
}
