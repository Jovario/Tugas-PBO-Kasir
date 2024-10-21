import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        items.removeIf(item -> item.getCode().equals(code));
        System.out.println("Barang dihapus.");
    }

    public void displayItems() {
        System.out.println("Daftar Item:");
        for (Item item : items) {
            System.out.printf("%s - %s: %.2f x %d = %.2f\n", item.getCode(), item.getName(), item.getPrice(), item.getQuantity(), item.getSubtotal());
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void displayTotal() {
        double total = calculateTotal();
        displayItems();
        System.out.println("Total harga: " + total);
    }

    public double processPayment(double payment) {
        double total = calculateTotal();
        return payment - total;
    }
}
