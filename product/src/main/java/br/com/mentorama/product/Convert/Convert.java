package br.com.mentorama.product.Convert;

import br.com.mentorama.product.Dto.ProductDto;
import br.com.mentorama.product.Dto.ProductUpdateDto;
import br.com.mentorama.product.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Convert {

    public Product convertProductDtoToClass(ProductDto productDto){
        return new ModelMapper().map(productDto, Product.class);
    }
    public Product convertProductUpdateDtotoClass(ProductUpdateDto productUpdateDto){
        return new ModelMapper().map(productUpdateDto, Product.class);
    }
}
