package com.iqbal.poin_of_sale.service;

import com.iqbal.poin_of_sale.model.product.Unit;
import com.iqbal.poin_of_sale.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService {

    private final UnitRepository unitRepository;

    public List<Unit> getUnits() {
        return unitRepository.findAll();
    }
}
