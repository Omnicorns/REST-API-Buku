package com.aloysius.rest.service;

import com.aloysius.rest.entity.Buku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BukuService {
    Buku saveProduct (Buku product);
    Buku updateProduct (Buku product);
    List<Buku> getAllProduct();
    Buku getProductById (String productId);
    void deleteProduct(String id);
    void saveBulkProduct (List<Buku>products);
    Page<Buku> getProductPage (Pageable pageable);
    void checkStock (Buku product, Integer qty);
}
