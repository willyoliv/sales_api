package br.com.letscode.sales.mapper;

import br.com.letscode.sales.dto.SaleRequestDTO;
import br.com.letscode.sales.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale saleRequestDTOToSale(SaleRequestDTO saleRequestDTO);
}
