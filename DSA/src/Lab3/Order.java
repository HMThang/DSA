package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
    private OrderItem[] items;

    public double cost() {
        // TODO
        return 0.0;
    }

    // using binary search approach
    public boolean contains(Product p) {
        Arrays.sort(items, new Comparator<OrderItem>() {

            @Override
            public int compare(OrderItem o1, OrderItem o2) {
                return Double.compare(o1.getP().getPrice(), o2.getP().getPrice());
            }
        });
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid].getP().getPrice() == p.getPrice()) {
                return true;
            } else if (items[mid].getP().getPrice() > p.getPrice()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // get all products based on the given type using linear search

    public Product[] filter(String type) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            OrderItem temp = items[i];
            if (temp.getP().getType().equals(type)) {
                count++;
            }
        }
        Product[] result = new Product[count];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            OrderItem temp = items[i];
            if (temp.getP().getType().equals(type)) {
                result[index++] = temp.getP();
            }
        }
        return result;
    }
}