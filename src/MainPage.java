import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainPage {

    private List<User> users;
    Customer customer = new Customer();
    Employee employee = new Employee();
    private List<Product> products;
    Store store = new Store();
    Cart cart = new Cart();
    private List<Cart> carts;

    public MainPage () {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.store.productNumber = new HashMap<>();
        this.carts = new ArrayList<>();
    }




    public void createUserDetails() {

        Scanner scanner = new Scanner(System.in);

        String firstName = null;
        do {
            System.out.println("Enter your first name: ( DIGITS NOT ALLOWED ) ");
            firstName = scanner.nextLine();
        } while (!this.validNames(firstName));
        String lastName = null;
        do {
            System.out.println("Enter your last name: ( DIGITS NOT ALLOWED ) ");
            lastName = scanner.nextLine();
        } while (!this.validNames(lastName));
        String username = null;
        do {
            System.out.println("Enter a username:");
            username = scanner.nextLine();
        } while (this.usernameExists(username));
        System.out.println("User name accepted");
        String password = null;
        do {
            System.out.println(username + ", Enter a password:");
            password = scanner.nextLine();
        } while (!this.isStrongPassword(password));
        System.out.println("Password saved!");

        boolean clubMember = true;
        if (!this.userType()) { // Check if the customer is a club member
            clubMember = customer.checkIfClubMember();
            Customer newUser = new Customer(firstName,lastName,username,password,clubMember,false, customer.countPurchase); // for customer
            this.users.add(newUser);

        } else {
            Employee newUser = new Employee(firstName,lastName,username,password, clubMember, employee.workerType(),true, employee.countPurchase); // for employee
            this.users.add(newUser);

        }

    }

    public boolean isWorker (User currentUser) {
        return currentUser.worker;
    }

    public boolean userType () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What account do you want to create? ");
        System.out.println("1. Employee account ");
        System.out.println("2. Customer account ");
        boolean isEmployee = false;
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                isEmployee = true;
                break;
            case 2:
                isEmployee = false;
                break;
        }
        return isEmployee;
    }

    public boolean usernameExists (String username) {
        boolean exists = false;
        for (int i = 0; i < this.users.size(); i++ ) {
            User currentUser = this.users.get(i);
            if (currentUser != null) {
                if (currentUser.username.equals(username)) {
                    exists = true;
                    break;
                }
            }
        }
        return exists;
    }


    public boolean isStrongPassword (String password) {
        boolean strong = false;
        boolean passwordLong = false;
        if (password.length() >= 6) {
            strong = true;
        }
        return strong;
    }

    public boolean validNames(String name) {
        boolean valid = true;
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (Character.isDigit(currentChar)) {
                valid = false;
            }
        }
        return valid;
    }



    public User login() {
        Scanner scanner = new Scanner(System.in);
        User found = null;
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User currentUser : this.users) {
            if (currentUser.username.equals(username) && currentUser.password.equals(password)) {
                found = currentUser;
                System.out.println("WELCOME");
                if (isWorker(found)) {                                          // Message and menu for employee
                    System.out.println(found);
                    menuForEmployee();
                } else {                                                        // Message and menu for customer
                    System.out.println(found);
                    store.purchaseForClients();

                }
                break;
            } else {
                System.out.println("There is no such a user");
            }
        }
        return found;
    }

    public void menuForEmployee () {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What would you like to do? ");
            System.out.println("1. Print all customers ");
            System.out.println("2. Print all club members ");
            System.out.println("3. Print all customers who have purchased at least once ");
            System.out.println("4. Print the customer with the highest purchase amount ");
            System.out.println("5. Adding a new product to the store ");
            System.out.println("6. Change inventory status for product ");
            System.out.println("7.  Make a purchase ");
            System.out.println("8. Exit ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printAllCustomers();
                    break;
                case 2:
                    printAllClubMembers();
                    break;
                case 3:
                    madePurchase();
                    break;
                case 4:
                    clientWhoMadeTheMostPurchases ();
                    break;
                case 5:
                    this.store.addProduct();
                    break;
                case 6:
                    store.changeAvailabilityToOutOfStock();
                    break;
                case 7:
                    store.purchaseForClients();
                    break;
                case 8:
                    System.out.println("EXIT");
                    break;

            }
        } while (choice != 8);


    }



    public void printAllCustomers () {
        for (User user : this.users) {
            System.out.println(user);
        }
    }

    public void printAllClubMembers () {
        for (User user : this.users) {
            if (user.isClubMember()) {
                System.out.println(user);
            }
        }
    }

    public void madePurchase () {
        for (User user : users) {
            if (customer.getCountPurchase() > 0) {
                System.out.println(user);
            }
        }
    }

    public void clientWhoMadeTheMostPurchases () {
        int number = 0;
        for (User user : users) {
            if (customer.getCountPurchase() >0 && customer.getCountPurchase() > number) {
                number = customer.getCountPurchase();
            }
            System.out.println(user.firstName +  " " + number);
        }
    }



}
