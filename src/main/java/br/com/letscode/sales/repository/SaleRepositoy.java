package br.com.letscode.sales.repository;

import br.com.letscode.sales.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SaleRepositoy extends JpaRepository<Sale, Long> {
    List<Sale> findByUser_UserCode(UUID userCode);
}

