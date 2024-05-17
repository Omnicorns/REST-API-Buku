package com.aloysius.rest.repository;

import com.aloysius.rest.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BukuRepository extends JpaRepository<Buku,String>, JpaSpecificationExecutor<Buku> {
}
