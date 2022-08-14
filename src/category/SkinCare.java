package category;

import java.time.LocalDate;
import java.util.UUID;

public class SkinCare extends Category {
    public SkinCare(UUID id, String name) {
        super(id, name);
    }

    public LocalDate findDeliveryDueDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.plusDays(0L);
    }
}

