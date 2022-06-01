package br.com.letscode.sales.service;

import br.com.letscode.sales.client.ProductClient;
import br.com.letscode.sales.entity.Sale;
import br.com.letscode.sales.exception.SaleNotFoundException;
import br.com.letscode.sales.repository.SaleRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService {

    private final SaleRepositoy saleRepositoy;
    private final ProductClient productClient;

    @Override
    @Transactional
    public Sale saveSale(Sale sale) {
        sale.setSaleToProduct();
        BigDecimal saleValue = sale.getProducts().stream()
                .map((product) -> product.getPrice().multiply(new BigDecimal(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setSaleValue(saleValue);
        productClient.updateStock(sale.getProducts());
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
    public List<Sale> getAllSalesByUserCode(UUID userCode) {
        return saleRepositoy.findByUser_UserCode(userCode);
    }
}
