package wallet.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import wallet.CouponApplication;
import wallet.domain.CouponCancelled;
import wallet.domain.CouponPurchased;

@Entity
@Table(name = "Coupon_table")
@Data
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long price;

    private String type;

    private String name;

    private String buyer;

    @PostPersist
    public void onPostPersist() {
        CouponPurchased couponPurchased = new CouponPurchased(this);
        couponPurchased.publishAfterCommit();

        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();
    }

    public static CouponRepository repository() {
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(
            CouponRepository.class
        );
        return couponRepository;
    }
}
