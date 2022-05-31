package br.com.letscode.sales.client;

import br.com.letscode.sales.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/products", name = "sales")
public interface ProductClient {

    @PutMapping(path = "/update-stock")
    String updateStock(List<Product> products);
}
