package servicemanager;

import coupons.Coupon;
import model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//singleton
public class CouponManager {

    private static final CouponManager instance = new CouponManager();
    private Coupon head;
    private Lock lock = new ReentrantLock();

    private CouponManager() {
        head = null;
    }

    public static CouponManager getInstance(){
        return instance;
    }

    public void registerCoupon(Coupon coupon)
    {
        lock.lock();

        try{
            if(head == null){
                head = coupon;

            }

            else{
                Coupon temp = head;
                while(temp.getNext() != null)
                {
                    temp = temp.getNext();
                }

                temp.setNext(coupon);
            }
        }
        finally {
            lock.unlock();
        }


    }

    public double applyAll(Cart cart){

        lock.lock();
        try{
            if(head != null){
                head.applyDiscount(cart);
            }

            return cart.getCurrentTotal();
        }
        finally {
            lock.unlock();
        }

    }

    public List<String> getApplicable(Cart cart)
    {
        lock.lock();
        try{
            List<String> list = new ArrayList<>();
            Coupon temp = head;

            while(temp != null)
            {
                if (temp.isApplicable(cart)) {
                    list.add(temp.name());
                }

                temp = temp.getNext();
            }
            return list;
        }
        finally {
            lock.unlock();
        }

    }


}
