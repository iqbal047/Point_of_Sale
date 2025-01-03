package com.iqbal.poin_of_sale.dto;

import lombok.Builder;

@Builder
public record StockSearchDTO(
        String productName,
        String brandId,
        String categoryId,
        Double sellingPriceFrom,
        Double sellingPriceTo,
        String manufactureDateFrom,
        String manufactureDateTo,
        String expireDateFrom,
        String expireDateTo
) {
}
