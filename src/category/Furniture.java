package category;

import java.time.LocalDate;
import java.util.UUID;

public class Furniture extends Category {
    public Furniture(UUID id, String name) {
        super(id, name);
    }

    public LocalDate findDeliveryDueDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.plusDays(1L);
    }
}