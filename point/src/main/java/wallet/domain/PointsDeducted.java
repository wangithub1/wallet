package wallet.domain;

import java.util.*;
import lombok.*;
import wallet.domain.*;
import wallet.infra.AbstractEvent;

@Data
@ToString
public class PointsDeducted extends AbstractEvent {

    private Long id;

    public PointsDeducted(Point aggregate) {
        super(aggregate);
    }

    public PointsDeducted() {
        super();
    }
    // keep

}
