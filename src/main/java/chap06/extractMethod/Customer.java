package chap06.extractMethod;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private Vector<Order> _orders;
    private String _name;

    public Customer(Vector<Order> _orders, String _name) {
        this._orders = _orders;
        this._name = _name;
    }

    void printOwing() {
        Enumeration<Order> e = _orders.elements();
        double outstanding = 0.0;

        printBanner();

        // 외상액 계산
        while (e.hasMoreElements()) {
            Order each = e.nextElement();
            outstanding += each.getAmount();
        }

        // 세부 내역 출력
        System.out.println("고객명: " + _name);
        System.out.println("외상액: " + outstanding);
    }

    void printBanner() {
        // 배너 출력
        System.out.println("*****************************");
        System.out.println("********** 고객 외상 **********");
        System.out.println("*****************************");
    }

}
