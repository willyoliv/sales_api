package br.com.letscode.sales.service;

import br.com.letscode.sales.entity.Sale;
import br.com.letscode.sales.exception.SaleNotFoundException;
import br.com.letscode.sales.repository.SaleRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService {

    private final SaleRepositoy saleRepositoy;

    @Override
    public Sale saveSale(Sale sale) {
        sale.setSaleToProduct();
        Double saleValue = sale.getProducts().stream()
                .map((product) -> product.getPrice() * product.getQuantity())
                .reduce(0.0, (a, b) -> a + b);
        sale.setSaleValue(saleValue);
        return saleRepositoy.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepositoy.findAll();
    }

    @Override
    public Sale getSaleById(Long saleId) {
        return saleRepositoy.findById(saleId).orElseThrow(() -> new SaleNotFoundException("Sale " + saleId + " not found!"));
    }

    @Override
    public List<Sale> getAllSalesByUserCode(Long userCode) {
        return saleRepositoy.findByUser_UserCode(userCode);
    }
}
