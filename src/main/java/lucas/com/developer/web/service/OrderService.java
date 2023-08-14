package lucas.com.developer.web.service;

import lucas.com.developer.web.entities.Order;
import lucas.com.developer.web.repositorie.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }


}
