package com.iqbal.poin_of_sale.dto;

import com.iqbal.poin_of_sale.model.product.Product;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GrnItemDTO(
        Product product,
        Integer quantity,
        double buyingPrice,
        double sellingPrice,
        LocalDate manufactureDate,
        LocalDate expireDate
) {
}
