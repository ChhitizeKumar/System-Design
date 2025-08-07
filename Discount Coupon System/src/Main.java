import coupons.BankCoupon;
import coupons.BulkPurchaseDiscount;
import coupons.LoyaltyDiscount;
import coupons.SeasonalOffer;
import model.Cart;
import model.Product;
import servicemanager.CouponManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        CouponManager mgr = CouponManager.getInstance();
        mgr.registerCoupon(new SeasonalOffer(10, "Clothing"));
        mgr.registerCoupon(new LoyaltyDiscount(5));
        mgr.registerCoupon(new BulkPurchaseDiscount(1000, 100));
        mgr.registerCoupon(new BankCoupon("ABC", 2000, 15, 500));



        Product p1 = new Product("Winter Jacket", "Clothing", 1000);
        Product p2 = new Product("Smartphone", "Electronics", 20000);
        Product p3 = new Product("Jeans", "Clothing", 1000);
        Product p4 = new Product("Headphones", "Electronics", 2000);



        Cart cart = new Cart();
        cart.addProduct(p1, 1);
        cart.addProduct(p2, 2);
        cart.addProduct(p3, 5);
        cart.addProduct(p4, 3);
        cart.setLoyaltyMember(true);
        cart.setPaymentBank("ABC");

        System.out.println("Original Cart Total: " + cart.getOriginalTotal() + " Rs");

        List<String> applicable = mgr.getApplicable(cart);
        System.out.println("Applicable Coupons:");
        for (String name : applicable) {
            System.out.println(" - " + name);
        }

        double discountedTotal = mgr.applyAll(cart);

        System.out.println("Cart Total after all Discount: " + discountedTotal  + " Rs");


    }
}