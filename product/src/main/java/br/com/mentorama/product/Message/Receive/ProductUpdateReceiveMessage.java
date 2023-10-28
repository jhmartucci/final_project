package br.com.mentorama.product.Message.Receive;

import br.com.mentorama.product.Convert.Convert;
import br.com.mentorama.product.Dto.ProductUpdateDto;
import br.com.mentorama.product.Entity.Product;
import br.com.mentorama.product.RabbitConfig.ProductUpdateQueuesConfig;
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
public class ProductUpdateReceiveMessage {

    @Autowired
    private final ProductService productService;
    @Autowired
    private final Convert convert;

    @RabbitListener(queues = ProductUpdateQueuesConfig.QUEUE_UPDATE_PRODUCTS)
    public void receiveMessage(@Payload ProductUpdateDto productUpdateDto){
        log.info(productUpdateDto.toString());
        Product product = convert.convertProductUpdateDtotoClass(productUpdateDto);
        productService.updateProduct(product);
    }
}
