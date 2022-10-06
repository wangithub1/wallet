package wallet.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import wallet.PointApplication;
import wallet.domain.PointsDeducted;

@Entity
@Table(name = "Point_table")
@Data
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String holder;

    @PostPersist
    public void onPostPersist() {
        PointsDeducted pointsDeducted = new PointsDeducted(this);
        pointsDeducted.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    public static void usePoint(CouponPurchased couponPurchased) {
        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponPurchased.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

    }
}
