package br.com.letscode.sales.service;

import br.com.letscode.sales.entity.Sale;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    public Sale saveSale(Sale sale);

    public List<Sale> getAllSales();

    public Sale getSaleById(Long saleId);

    public List<Sale> getAllSalesByUserCode(UUID userCode);
}
