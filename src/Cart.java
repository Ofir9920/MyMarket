import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Cart {

    Store store = new Store();
    private List<Product> products;
    private List<Product> cart;
    private float purchaseAmount;
    HashMap<Integer,Product> productNumber = new HashMap();

    public Cart () {
        this.purchaseAmount = 0;
        this.productNumber = new HashMap<>();
        this.products = new ArrayList<>();
        this.cart = new ArrayList<>();
    }




    public String toString() {
        String myString = "Whats in your cart: " + products + " \n";
        return myString;
    }




}
