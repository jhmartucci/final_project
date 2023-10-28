package br.com.mentorama.Order.Controller;

import br.com.mentorama.Order.Convert.Convert;
import br.com.mentorama.Order.Dto.OrderDto;
import br.com.mentorama.Order.Entity.Order;
import br.com.mentorama.Order.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;
    @Autowired
    private final Convert convert;

    @PostMapping("/create")
    public ResponseEntity insertOrder(@RequestBody OrderDto orderDto){
        try {
            Order order = orderService.insertOrder(convert.convertOrderDtoToClass(orderDto));
            return new ResponseEntity<>(order,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable("id")UUID id, @RequestBody OrderDto orderDto){
        Order order = convert.convertOrderDtoToClass(orderDto);
        order.setId(id);
        Order newOrder = orderService.updateOrder(order);

        return Objects.nonNull(newOrder)?
                new ResponseEntity<>(order,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity findByIdOrder(@PathVariable UUID id){
        Optional<Order> order = orderService.findByIdOrder(id);

        return Objects.nonNull(order)?
                new ResponseEntity<>(order, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id")UUID id){
        return orderService.deleteOrder(id)?
                new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
