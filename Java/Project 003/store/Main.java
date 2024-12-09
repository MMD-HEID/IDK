import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        while (true){

        }
    }

    public static void getOrder(Scanner input, Products products, Cart cart) {
        int order, prId;

        System.out.println("What Can I Do For You?");
        System.out.println("1: Add To Your Cart.");
        System.out.println("2: Show Products.");
        System.out.println("3: Show Prices.");
        System.out.println("4: Show Your Cart.");
        System.out.println("5: Show Offers.");
        System.out.println("0: Exit.");
        order = input.nextInt();
        if (order == 1) {
            System.out.println("Which Product Do You Want?");
            System.out.println(Products.products);

        }

    }
}

class Cart extends Products {
    ArrayList<String> cart = new ArrayList<>();

}

class Offer {

}

class Factor {

}

class Products {
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<String> price = new ArrayList<>();


    //تعریف محصول
    public void setProducts() {
        products.add("Milk");
        products.add("Chocolate Milk");
        products.add("Yoghurt");
        products.add("Cheese");
        products.add("Cream");
        products.add("Dough");
        products.add("Honey");
        products.add("Butter");
    }

    //قیمتگذاری
    public void setPrice() {
        price.add("10000");
        price.add("20000");
        price.add("35000");
        price.add("25000");
        price.add("15000");
        price.add("56000");
        price.add("100000");
        price.add("5000");
    }

    public List<String> getProducts() {
        return products;
    }

    public List<String> getPrice() {
        return price;
    }
}