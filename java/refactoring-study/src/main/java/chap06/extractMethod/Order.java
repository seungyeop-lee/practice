package chap06.extractMethod;

public class Order {
    private double _amount;

    public Order(double _amount) {
        this._amount = _amount;
    }

    public double getAmount() {
        return _amount;
    }
}
