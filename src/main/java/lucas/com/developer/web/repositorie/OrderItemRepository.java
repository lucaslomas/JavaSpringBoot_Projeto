package lucas.com.developer.web.repositorie;

import lucas.com.developer.web.entities.OrderItem;
import lucas.com.developer.web.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
