package br.com.mentorama.product.Message.Receive;

import br.com.mentorama.product.Convert.Convert;
import br.com.mentorama.product.Dto.ProductDto;
import br.com.mentorama.product.Entity.Product;
import br.com.mentorama.product.RabbitConfig.ProductQueuesConfig;
import br.com.mentorama.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductReceiveMessage {

    @Autowired
    private final ProductService productService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = ProductQueuesConfig.QUEUE_PRODUCTS)
    public void receiveMessage(@Payload ProductDto productDto){
        log.info(productDto.toString());
        Product product = convert.convertProductDtoToClass(productDto);
        productService.insertProduct(product);
    }
}
