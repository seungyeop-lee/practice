package chap06.replaceTempWithQuery;

public class Product {

    int _quantity;
    int _itemPrice;

    public Product(int quantity, int itemPrice) {
        this._quantity = quantity;
        this._itemPrice = itemPrice;
    }

    Double getPrice() {
        return basePrice() * discountFactor();
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }

    private double discountFactor() {
        if (basePrice() > 1000) {
            return 0.95;
        } else {
            return 0.98;
        }
    }
}
