package com.example.nmd.controller;

import com.example.nmd.dto.request.CreateProductRequest;
import com.example.nmd.dto.request.FilterProduct;
import com.example.nmd.dto.response.BaseResponse;
import com.example.nmd.model.Product;
import com.example.nmd.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ProductController {
    private final ProductService productService ;
    @PostMapping("create")
    public BaseResponse createProduct (@RequestBody CreateProductRequest request){
        return  BaseResponse.successData( productService.createProduct(request));
    }

    @PostMapping("update")
    public BaseResponse updateProduct (@RequestBody CreateProductRequest request){
        return  BaseResponse.successData( productService.updateProduct(request));
    }

    @GetMapping("{id}")
    public BaseResponse getProductById (@PathVariable long id){
        return BaseResponse.successData(productService.getProductById(id));
    }
    @GetMapping("all")
    public BaseResponse getAll (){
        return BaseResponse.successListData(productService.getAllProduct() , productService.getAllProduct().size() );
    }

    @GetMapping("del/{id}")
    public BaseResponse deleteProduct (@PathVariable long id){
        return BaseResponse.successData(productService.deleteProduct(id));
    }


    @PostMapping("findByKeyWord")
    public BaseResponse findByKeyWord(@RequestBody FilterProduct request ){
        List<Product> products = productService.filterProduct( request).getContent().stream().collect(Collectors.toList());
        return BaseResponse.successListData( products, products.size());
    }
}
