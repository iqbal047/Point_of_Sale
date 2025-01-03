package com.iqbal.poin_of_sale.controller;

import com.iqbal.poin_of_sale.dto.GrnDTO;
import com.iqbal.poin_of_sale.dto.GrnResponseDTO;
import com.iqbal.poin_of_sale.dto.SearchGrnInvoiceDTO;
import com.iqbal.poin_of_sale.service.GrnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("api/grn")
@RequiredArgsConstructor
public class GrnController {

    private final GrnService grnService;

    @PostMapping("/search")
    public ResponseEntity<Page<GrnResponseDTO>> getAllGrns(@RequestBody SearchGrnInvoiceDTO searchGrnInvoiceDTO) {
        return ResponseEntity.ok(grnService.getAllGrns(searchGrnInvoiceDTO));
    }

    @PostMapping
    public ResponseEntity<InputStreamResource> addGrn(@Valid @RequestBody GrnDTO grnDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=grn_report.pdf");
        ByteArrayInputStream byteArrayInputStream = grnService.addGrn(grnDTO);
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(byteArrayInputStream));
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<InputStreamResource> getGrnReport(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=grn_report.pdf");
        ByteArrayInputStream byteArrayInputStream = grnService.generateReport(id);
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(byteArrayInputStream));
    }

}
