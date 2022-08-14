

package category;

import java.time.LocalDate;
import java.util.UUID;

public class Electronic extends Category {
    public Electronic(UUID id, String name) {
        super(id, name);
    }

    public LocalDate findDeliveryDueDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.plusDays(4L);
    }

    public String generateCategoryCode() {
        String var10000 = this.getId().toString();
        return "EL-" + var10000.substring(0, 8);
    }
}
