package lucas.com.developer.web.repositorie;

import lucas.com.developer.web.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
