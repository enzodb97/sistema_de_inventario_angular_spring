package com.enzobd.SistemaInventario.Service;

import com.enzobd.SistemaInventario.model.Product;

import java.util.List;

public interface IProductsService {
    public List <Product> listProducts();

    public Product findProductsById(Long idProducts);

    public void saveProducts(Product products);

    public void deleteProductsById(Long idProducts);


}
