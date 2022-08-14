
package category;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Category {
    private UUID id;
    private String name;

    public Category(UUID id, String name) {
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public abstract LocalDate findDeliveryDueDate();

    public String generateCategoryCode() {
        return this.id.toString().substring(0, 8).concat("-").concat(this.name.substring(0, 2));
    }

}
