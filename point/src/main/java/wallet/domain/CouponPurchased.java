package wallet.domain;

import java.util.*;
import lombok.*;
import wallet.domain.*;
import wallet.infra.AbstractEvent;

@Data
@ToString
public class CouponPurchased extends AbstractEvent {

    private Long id;
    private String buyer;
    private String name;
    private String type;
    private Long price;
    // keep

}
