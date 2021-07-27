public class Person {

    private String name;
    private int account;

    Person(String name) {
        this.name = name;
        this.account = 0;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void addToAccount(int amount) {
        this.account += amount;
    }

    public String getName() {
        return this.name;
    }

    public int getAccount() {
        return this.account;
    }
}
