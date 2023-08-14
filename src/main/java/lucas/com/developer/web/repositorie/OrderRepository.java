package lucas.com.developer.web.repositorie;

import lucas.com.developer.web.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
