
package category;


import java.time.LocalDateTime;
import java.util.UUID;

public abstract class   Category {

    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract LocalDateTime findDeliveryDueDate();

    public String generateCategoryCode(){
        return id.toString().substring(0,8).concat("-").concat(name.substring(0,2));
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'+"\n";
    }

    public String getName() {
        return name;
    }


}

