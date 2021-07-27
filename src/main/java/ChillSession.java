import java.util.ArrayList;

public class ChillSession {

    private String nameOfSession;
    private int sharedAccount;
    ArrayList<Person> membersList;

    ChillSession(String name) {
        this.nameOfSession = name;
        this.sharedAccount = 0;
        this.membersList = new ArrayList<>();
    }

    public void changeNameOfSession(String name) {
        this.nameOfSession = name;
    }

    public int getJointAccount() {
        return this.sharedAccount;
    }

    public void addToSharedAccount(int amount) {
        this.sharedAccount += amount;
    }

    public boolean memberExists(String name) {
        for (Person p : this.membersList) {
            if (p.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public int memberIndex(String name) {
        for (int i = 0; i < this.getLengthOfMemberList(); i++) {
            if (this.membersList.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void addToAccountOf(String name, int amount) {
        if (this.memberExists(name)) {
            this.membersList.get(this.memberIndex(name)).addToAccount(amount);
        }
    }

    public int getLengthOfMemberList() {
        return this.membersList.size();
    }

    public void addMember(String name) {
        Person person = new Person(name);
        this.membersList.add(person);
    }

    public int getAccountOf(String name) {
        if (this.memberExists(name)) {
            return this.membersList.get(this.memberIndex(name)).getAccount() +
                    this.sharedAccount / this.getLengthOfMemberList();
        }

        return -1;
    }

    public void deleteMember(String name) {
        if (this.memberExists(name)) {
            this.membersList.remove(this.memberIndex(name));
        }
    }

    public String getNameOfSession() {
        return this.nameOfSession;
    }
}
