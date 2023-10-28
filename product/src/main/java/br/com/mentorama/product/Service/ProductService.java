package br.com.mentorama.product.Service;

import br.com.mentorama.product.Dto.StockDto;
import br.com.mentorama.product.Entity.Product;
import br.com.mentorama.product.Message.Send.ProductSendMessageToStock;
import br.com.mentorama.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductSendMessageToStock productSendMessageToStock;


    public Product insertProduct(Product product){
        productRepository.save(product);
        var stockDto = new StockDto(product.getId(),product.getDescription(),product.getQuantity());
        log.info(stockDto.toString());
        productSendMessageToStock.sendMessage(stockDto);
        return product;

    }
    public Product updateProduct(Product product){
        Optional<Product> productOptional = productRepository.findById(product.getId());

        return productOptional.isPresent()?
                productRepository.save(product):
                null;
    }
    public boolean deleteProduct(UUID id){
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()){
            productRepository.delete(product.get());
            return true;
        }else{
            return false;
        }
    }
    public Optional<Product> findByIdProduct(UUID id){
        return productRepository.findById(id);
    }
}
