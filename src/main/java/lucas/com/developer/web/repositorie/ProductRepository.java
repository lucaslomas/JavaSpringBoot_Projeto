package lucas.com.developer.web.repositorie;

import lucas.com.developer.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
