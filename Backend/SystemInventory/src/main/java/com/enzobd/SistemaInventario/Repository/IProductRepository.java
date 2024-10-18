package com.enzobd.SistemaInventario.Repository;

import com.enzobd.SistemaInventario.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository <Product, Long> {
}
