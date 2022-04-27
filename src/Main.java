import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userChoice;
        MainPage mainPage = new MainPage();

        do {
            System.out.println("Hello, choose what you want to do:");
            System.out.println("1: Create new account.");
            System.out.println("2: Login.");
            System.out.println("3: Exit.");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                mainPage.createUserDetails();
                    break;
                case 2:
                mainPage.login();
                    break;
                case 3:

                    break;
            }
        } while (userChoice != 3);
    }

}
