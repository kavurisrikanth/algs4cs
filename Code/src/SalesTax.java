import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOrders = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numOrders; i++) {
            int numItems = Integer.parseInt(sc.nextLine());
            Order currentOrder = new Order(numItems);

            for (int j = 0; j < numItems; j++) {
                String line = sc.nextLine();
                currentOrder.parse(line);
            }
            System.out.println(currentOrder);
        }
        sc.close();
    }
}

enum ProductCategory {
    BOOKS,
    FOOD,
    MEDICAL,
    OTHERS
}

class Product {
    private ProductCategory category;
    private String name;
    private double price;
    private boolean imported;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;

        String lname = name.toLowerCase();

        if (lname.contains("book"))
            category = ProductCategory.BOOKS;
        else if (lname.contains("pill") || lname.contains("medicine"))
            category = ProductCategory.MEDICAL;
        else if (lname.contains("bar") || lname.contains("chocolate"))
            category = ProductCategory.FOOD;
        else
            category = ProductCategory.OTHERS;

        imported = lname.contains("imported");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public boolean isImported() {
        return imported;
    }
}

class OrderItem {
    private Product p;
    private double tax, total;
    private int quantity;

    public OrderItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
        tax = 0;

        calculateTax();
        tax = Math.round(tax * 20.0) / 20.0;
        total = (p.getPrice() * quantity) + tax;
    }

    private void calculateTax() {
        calculateBasicSalesTax();
        calculateImportTax();
    }

    private void calculateBasicSalesTax() {
        if (p.getCategory() != ProductCategory.OTHERS)
            return;

        tax += (p.getPrice() * quantity * 10.0/100);
    }

    private void calculateImportTax() {
        if (!p.isImported())
            return;

        tax += (p.getPrice() * quantity * 5.0/100);
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return quantity + " " + p.getName() + ": " + df.format(total);
    }
}

class Order {
    private OrderItem[] items;
    private int currentItem;
    private double taxTotal, total;

    public Order(int n) {
        items = new OrderItem[n];
        currentItem = 0;
    }

    public void parse(String orderLine) {
        String[] pieces = orderLine.split(" ");
        int qty = Integer.parseInt(pieces[0]);
        double price = Double.parseDouble(pieces[2]);

        items[currentItem++] = new OrderItem(new Product(pieces[1], price), qty);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (OrderItem oi: items) {
            sb.append(oi).append("\n");
            taxTotal += oi.getTax();
            total += oi.getTotal();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        sb.append("Sales Tax: ").append(df.format(taxTotal)).append("\n");
        sb.append("Total: ").append(df.format(total)).append("\n");
        return sb.toString();
    }
}