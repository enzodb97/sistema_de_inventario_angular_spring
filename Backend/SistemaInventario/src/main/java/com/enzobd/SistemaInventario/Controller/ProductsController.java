package com.enzobd.SistemaInventario.Controller;

import com.enzobd.SistemaInventario.Service.ProductsService;
import com.enzobd.SistemaInventario.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public List <Product> getProducts(){
        List<Product> products = this.productsService.listProducts();
        return products;
    }
    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product) {
        this.productsService.saveProducts(product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productsService.deleteProductsById(id);
    }
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {

        Product existingProduct = this.productsService.findProductsById(id);
        if (existingProduct != null) {

            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStockQuantity(product.getStockQuantity());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setCreatedAt(product.getCreatedAt());
            this.productsService.saveProducts(existingProduct);
        }
    }

}
