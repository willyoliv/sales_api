package br.com.letscode.sales.controller;

import br.com.letscode.sales.dto.SaleRequestDTO;
import br.com.letscode.sales.entity.Sale;
import br.com.letscode.sales.mapper.SaleMapper;
import br.com.letscode.sales.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("sales")
public class SalesController {
    private final SaleService saleService;

    private final SaleMapper saleMapper;

    @PostMapping
    private ResponseEntity<Sale> saveSale(@Valid @RequestBody SaleRequestDTO saleRequestDTO) {
        Sale sale = saleMapper.saleRequestDTOToSale(saleRequestDTO);
        return new ResponseEntity(saleService.saveSale(sale), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping(path = "/{saleId}")
    private ResponseEntity<Sale> getSaleById(@PathVariable("saleId") Long saleId) {
        return ResponseEntity.ok(saleService.getSaleById(saleId));
    }

    @GetMapping(path = "/find-sales-by-user-code/{userCode}")
    private ResponseEntity<List<Sale>> getAllSalesByUserCode(@PathVariable("userCode") Long userCode) {
        return ResponseEntity.ok(saleService.getAllSalesByUserCode(userCode));
    }
}
