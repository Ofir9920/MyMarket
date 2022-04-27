import java.util.Scanner;

public class Employee extends Customer {

    private EmployeeType type;




    public Employee (String firstName, String lastName, String userName, String password, boolean clubMember, EmployeeType type,boolean worker,int countPurchase) {
        super(firstName, lastName, userName, password, clubMember,worker,countPurchase);
        this.type = type;
        this.worker = true;
    }

    public Employee() {

    }




    public EmployeeType workerType () {
        Scanner scanner = new Scanner (System.in);
        System.out.println("What type of employee are you? ");
        System.out.println("1. REGULAR_WORKER ");
        System.out.println("2. DIRECTOR ");
        System.out.println("3. MANAGEMENT_MEMBER ");
        int worker = scanner.nextInt();
        switch (worker) {
            case 1:
                return EmployeeType.REGULAR_WORKER;
            case 2:
                return EmployeeType.DIRECTOR;
            case 3:
                return EmployeeType.MANAGEMENT_MEMBER;
        }
        return null;
    }




    public String toString () {
        String myString = "Hello " + this.getFirstName() + " " + this.getLastName() + " " + this.type;
        return myString;
    }





}
