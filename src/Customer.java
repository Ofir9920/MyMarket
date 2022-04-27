import java.util.List;
import java.util.Scanner;

public class Customer extends User{

    protected boolean clubMember;
    protected List<User> customers;



    public Customer () {

    }

    public Customer(String firstName, String lastName, String userName, String password, boolean clubMember,boolean worker, int countPurchase) {
        super(firstName, lastName, userName, password,worker, countPurchase);
        this.clubMember = clubMember;
        this.worker = false;
    }



    public boolean isClubMember() {
        return clubMember;
    }









    public boolean checkIfClubMember() {
        boolean member = false;
        String answer = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a club member?");
        answer = scanner.nextLine();
        if (answer.equals("Yes")) {
            member = true;
        }
        return member;
    }




    public String toString () {
        String myString = "Hello " + this.getFirstName() + " " + this.getLastName() + " ";
        if (this.isClubMember()) {
            myString = myString + " VIP";
        }
        return myString;
    }




}
