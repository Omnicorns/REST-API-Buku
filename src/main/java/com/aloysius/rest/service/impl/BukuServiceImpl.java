package com.aloysius.rest.service.impl;

import com.aloysius.rest.constant.ResponseMessage;
import com.aloysius.rest.entity.Buku;
import com.aloysius.rest.repository.BukuRepository;
import com.aloysius.rest.service.BukuService;
import com.aloysius.rest.util.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class BukuServiceImpl implements BukuService {

    BukuRepository bukuRepository;

    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    public BukuServiceImpl(BukuRepository productRepository) {
        this.bukuRepository = productRepository;
    }

    @Override
    public Buku saveProduct(Buku product) {

        return bukuRepository.save(product);
    }

    @Override
    public void saveBulkProduct(List<Buku> products){

        if(products.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"DATA IS EMPTY");
        }

        threadPoolTaskExecutor.execute(() ->

                bukuRepository.saveAll(products));


    }

    @Override
    public Page<Buku> getProductPage(Pageable pageable) {

        return bukuRepository.findAll(pageable);
    }

    @Override
    public void checkStock(Buku product, Integer qty) {
        if (product.getStock()<qty){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ResponseMessage.TRANSACTION_NOT_VALID);
        }
        product.setStock(product.getStock()-qty);
        bukuRepository.save(product);
    }




    @Override
    public Buku updateProduct(Buku product) {

        return bukuRepository.save(product);

    }

    @Override
    public List<Buku> getAllProduct() {
        List<Buku> products = bukuRepository.findAll();
        if(products.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product is not found");
        }
        return products;
    }

    @Override
    public Buku getProductById(String productId) {
        Optional<Buku> test = bukuRepository.findById(productId);
        if (test.isEmpty()){
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND_MESSAGE, ResponseMessage.PRODUCT,productId));
        }
        return test.get();
    }

    @Override
    public void deleteProduct(String id) {

        bukuRepository.deleteById(id);
    }



}

