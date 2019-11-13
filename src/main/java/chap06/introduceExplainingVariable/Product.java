package chap06.introduceExplainingVariable;

public class Product {

    int _quantity;
    int _itemPrice;

    public Product(int quantity, int itemPrice) {
        this._quantity = quantity;
        this._itemPrice = itemPrice;
    }

    double price() {
        // 결제액(price) = 총 구매액(base price) -
        // 대량 구매 할인(quantity discount) +
        // 배송비(shipping)
        return _quantity * _itemPrice -
                Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
                Math.min(_quantity * _itemPrice * 0.1, 100.0);
    }
}
