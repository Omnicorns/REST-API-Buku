package com.aloysius.rest.controller;


import com.aloysius.rest.constant.ApiUrlConstant;
import com.aloysius.rest.entity.Buku;
import com.aloysius.rest.service.BukuService;
import com.aloysius.rest.util.PageResponseWrapper;
import com.aloysius.rest.util.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.PRODUCT_PATH)

public class ProductController {
    BukuService productService;

    @Autowired
    public ProductController(BukuService productService) {
        this.productService = productService;
    }

  @PostMapping()

  public ResponseEntity<Response<Buku>> saveProduct(@RequestBody Buku product){

     String message ="Date has been inserted";
     Response<Buku> productResponse = new Response<>();
     productResponse.setMessage(message);
     productResponse.setData(productService.saveProduct(product));
      return  ResponseEntity.status(HttpStatus.OK)
              .contentType(MediaType.APPLICATION_JSON).body(productResponse);


  }

    @PostMapping("/bulk")
    public void saveProduct(@RequestBody List <Buku> products){
         productService.saveBulkProduct(products);

    }

   @GetMapping("/getAll")
   public List<Buku> findProduct(){
        return  productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public  Buku findProductById(@PathVariable  String id) {
        return  productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Buku>> deleteProduct(@PathVariable String id){
        String message ="Data has been deleted";
       Response<Buku>productResponse = new Response<>();
       productResponse.setMessage(message);
       productResponse.setData(productService.getProductById(id));
       productService.deleteProduct(id);
       return  ResponseEntity.status(HttpStatus.OK)
               .contentType(MediaType.APPLICATION_JSON).body(productResponse);
    }

    @PutMapping("/update")
    public Buku updateProduct(@RequestBody Buku product){
        return productService.updateProduct(product);
    }

    @GetMapping("/pagination")
    public PageResponseWrapper<Buku> findProduct(@RequestParam (defaultValue = "0") Integer page,
                                                 @RequestParam (defaultValue = "5")Integer size){
        Pageable pageable = PageRequest.of(page,size);
     Page<Buku> products   =  productService.getProductPage(pageable);
      return  new PageResponseWrapper<>(products);
    }

}
