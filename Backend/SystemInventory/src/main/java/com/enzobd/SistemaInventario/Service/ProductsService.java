package com.enzobd.SistemaInventario.Service;

import com.enzobd.SistemaInventario.Repository.IProductRepository;
import com.enzobd.SistemaInventario.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsService implements IProductsService{

   @Autowired
   private IProductRepository IProductRepository;

    @Override
    public List<Product> listProducts() {
     return this.IProductRepository.findAll();
    }

    @Override
    public Product findProductsById(Long idProducts) {
        Product products = this.IProductRepository.findById(idProducts).orElse(null);
        return products;
    }

    @Override
    public void saveProducts(Product products) {
        this.IProductRepository.save(products);

    }

    @Override
    public void deleteProductsById(Long idProducts) {
        this.IProductRepository.deleteById(idProducts);

    }
}
