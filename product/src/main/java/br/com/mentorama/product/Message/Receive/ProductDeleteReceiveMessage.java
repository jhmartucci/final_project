package br.com.mentorama.product.Message.Receive;

import br.com.mentorama.product.Dto.IdDto;
import br.com.mentorama.product.RabbitConfig.ProductDeleteQueuesConfig;
import br.com.mentorama.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ProductDeleteReceiveMessage {

    @Autowired
    private final ProductService productService;

    @RabbitListener(queues = ProductDeleteQueuesConfig.QUEUE_DELETE_PRODUCTS)
    public void receiveMessage(IdDto idDto){
        log.info(idDto.toString());
        productService.deleteProduct(idDto.getId());
    }
}
