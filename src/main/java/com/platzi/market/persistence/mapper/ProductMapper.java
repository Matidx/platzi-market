package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) //spring usa CategoryMapper para hacer el mapeo de category
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto); //mapeador de producto A product
    List<Product> toProducts(List<Producto> productos); //mapeador de Lista de productos A list of products

    @InheritInverseConfiguration //mapeo inverso e ignora el codigo de barras para no mostrarlo en el json
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product); //mapeador de product A producto
}