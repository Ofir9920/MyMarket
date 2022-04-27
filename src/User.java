public class User {

    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected boolean worker;
    protected boolean clubMember;
    private EmployeeType type;
    protected int countPurchase;


    public User () {

    }


    public User(String firstName, String lastName, String userName, String password,boolean worker, int countPurchase) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.password = password;
        this.worker = worker;
        this.countPurchase = countPurchase;


    }

    public void setCountPurchase(int countPurchase) {
        this.countPurchase = countPurchase;
    }

    public int getCountPurchase() {
        return countPurchase++;
    }

    public String getUsername () {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isWorker() {
        return worker;
    }

    public void setWorker(boolean worker) {
        this.worker = worker;
    }

    public boolean isClubMember() {
        return clubMember;
    }

    public void setClubMember(boolean clubMember) {
        this.clubMember = clubMember;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }
}
