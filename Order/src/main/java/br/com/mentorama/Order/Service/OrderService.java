package br.com.mentorama.Order.Service;

import br.com.mentorama.Order.Entity.Order;
import br.com.mentorama.Order.Repositiry.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public Order insertOrder(Order order){
        return orderRepository.save(order);
    }
    public Order updateOrder(Order order){
        Optional<Order> optionalOrder = orderRepository.findById(order.getId());

        return optionalOrder.isPresent()?
                orderRepository.save(order):
                null;
    }
    public Optional<Order> findByIdOrder(UUID id){
        return orderRepository.findById(id);
    }
    public boolean deleteOrder(UUID id){
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()){
            orderRepository.delete(order.get());
            return true;
        }else {
            return false;
        }
    }
}
