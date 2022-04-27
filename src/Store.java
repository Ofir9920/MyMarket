import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Store {

    Customer customer = new Customer();
    private List<Product> products;
   // private List<String> cart;
    HashMap<Integer, Product> productNumber = new HashMap();
    private float purchaseAmount;
    HashMap <Integer, String> shopCart = new HashMap();


    public Store() {
        this.products = new ArrayList<>();
       // this.cart = new ArrayList<>();
        this.productNumber = new HashMap<>();
        this.purchaseAmount = 0;
    }


    public void showStoreProducts() {
        int count = 1;
        for (Product currentProduct : this.products) {
            if (currentProduct.isAvailable() == true) {
                productNumber.put(count++, currentProduct);
            }
        }
        System.out.println(productNumber);
    }


    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter the product price: ");
        float price = scanner.nextFloat();
        System.out.println("Enter Discount percentages for club members: ");
        float discountPercentages = scanner.nextFloat();
        boolean available;
        System.out.println("Product availability?");
        System.out.println("1. Available ");
        System.out.println("2. Not available ");
        int ans = scanner.nextInt();
        if (ans == 1) {
            available = true;
        } else {
            available = false;
        }
        Product newProduct = new Product(productName, price, discountPercentages, available);
        this.products.add(newProduct);

    }


    public void changeAvailabilityToOutOfStock() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        for (Product currentProduct : this.products) {
            if (currentProduct.isAvailable() == true) {
                productNumber.put(count++, currentProduct);
            }
        }
        System.out.println(productNumber);

        System.out.println("Please insert the number of product you want to update: ");
        int number = scanner.nextInt();
        if (productNumber.containsKey(number) && productNumber.get(number).isAvailable() == true) {
            productNumber.get(number).setAvailable(false);
            productNumber.remove(number);
            productNumber.keySet();
        } else {
            System.out.println("============Not Available already================");
        }

    }


    public void purchaseForClients() {

        Scanner scanner = new Scanner(System.in);
        int count = 1;
        for (Product currentProduct : this.products) {
            if (currentProduct.isAvailable() == true) {
                productNumber.put(count++, currentProduct);
            }
        }
        System.out.println(productNumber);
        int howMany;
        this.purchaseAmount = 0;
        int number;
        int end;
        do {
        System.out.println(" Choose product (Press -1 to Exit) ");
        number = scanner.nextInt();

            if (productNumber.containsKey(number)) {
                System.out.println("The product " + productNumber.get(number).getProductName() + " was added");
                System.out.println("How many?");
                howMany = scanner.nextInt();
                shopCart.put(howMany, productNumber.get(number).getProductName());
                this.purchaseAmount += productNumber.get(number).getPrice() * howMany;
                System.out.println("You have " + shopCart + ", your amount for pay: " + this.purchaseAmount);
                customer.getCountPurchase();
            } else if (!productNumber.containsKey(number)){
                System.out.println("PRODUCT DO NO AVAILABLE! ");
            }
        } while (number >= 0);

            System.out.println(shopCart + " your purchase amount: " + this.purchaseAmount);

    }

    public float getPurchaseAmount() {
        return purchaseAmount;
    }
}

