package com.iqbal.poin_of_sale.controller;

import com.iqbal.poin_of_sale.dto.ClientResponse;
import com.iqbal.poin_of_sale.dto.ProductDTO;
import com.iqbal.poin_of_sale.model.product.Product;
import com.iqbal.poin_of_sale.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchProducts(@RequestParam int page, @RequestParam int size, @RequestParam String text) {
        return ResponseEntity.ok(productService.searchProducts(page, size, text));
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientResponse> registerProduct(@Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(this.productService.registerProduct(productDTO));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientResponse> updateProduct(@Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(this.productService.updateProduct(productDTO));
    }

}
