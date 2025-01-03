package com.iqbal.poin_of_sale.controller;

import com.iqbal.poin_of_sale.dto.ClientResponse;
import com.iqbal.poin_of_sale.dto.SupplierDTO;
import com.iqbal.poin_of_sale.model.supplier.Supplier;
import com.iqbal.poin_of_sale.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("search")
    public ResponseEntity<Page<Supplier>> searchSuppliers(@RequestParam int page, @RequestParam int size, @RequestParam String text) {
        return ResponseEntity.ok(supplierService.searchSuppliers(page, size, text));
    }

    @GetMapping("{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplier(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientResponse> registerSupplier(@RequestBody SupplierDTO supplier) {
        return ResponseEntity.ok(supplierService.registerSupplier(supplier));
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientResponse> updateSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.updateSupplier(supplier));
    }

}
