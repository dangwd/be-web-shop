package com.example.nmd.service.product;

import com.example.nmd.dto.request.CreateProductRequest;
import com.example.nmd.dto.request.FilterProduct;
import com.example.nmd.model.Product;
import com.example.nmd.repository.CustomProductRepository;
import com.example.nmd.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class ProductServiceImplm implements ProductService{
    private final ProductRepository productRepository ;

    @Override
    public Product createProduct(CreateProductRequest request) {
        Product product = Product.builder().productName(request.getProductName())
                .createTime(new Date())
                .price(request.getPrice())
                .description(request.getDescription())
                .type(request.getType())
                .image(request.getImage())
                .quantityInStore(request.getQuantityInStore())
                .build();
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(CreateProductRequest request) {
        Optional<Product> product = productRepository.findById(request.getId());
        if(!product.isPresent()){
            throw new RuntimeException("KHông tìm thấy id của sản phẩm");
        }
        product.get().setProductName(request.getProductName());
        product.get().setType(request.getType());
        product.get().setImage(request.getImage());
        product.get().setDescription(request.getDescription());
        product.get().setPrice(request.getPrice());
        product.get().setQuantityInStore(request.getQuantityInStore());
        productRepository.save(product.get());
        return product.get();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new RuntimeException("KHông tìm thấy id của sản phẩm");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product deleteProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new RuntimeException("KHông tìm thấy id của sản phẩm");
        }
        productRepository.delete(product.get());
        return product.get();
    }



    @Override
    public Page<Product> filterProduct(FilterProduct request) {
        Specification<Product> productSpecification = CustomProductRepository.filterSpecification(request);
        return productRepository.findAll(productSpecification , PageRequest.of(request.getStart(), request.getLimit()));
    }
}
