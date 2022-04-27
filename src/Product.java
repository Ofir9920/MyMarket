public class Product {

    private String productName;
    private float price;
    private float discountPercentages;
    private boolean isAvailable;


    public Product (String productName, float price, float discountPercentages, boolean isAvailable) {
        this.productName = productName;
        this.price = price;
        this.discountPercentages = discountPercentages;
        this.isAvailable = isAvailable;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscountPercentages() {
        return discountPercentages;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString () {
        String myString = "Product name " + productName + " price: " + price +
                " discount for club members " + discountPercentages + " % off\n";
        return myString;
    }

}
