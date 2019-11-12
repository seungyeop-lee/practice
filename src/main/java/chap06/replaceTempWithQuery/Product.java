package chap06.replaceTempWithQuery;

public class Product {

    int _quantity;
    int _itemPrice;

    public Product(int quantity, int itemPrice) {
        this._quantity = quantity;
        this._itemPrice = itemPrice;
    }

    Double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }
}
