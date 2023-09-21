package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos  = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos); //esta usando el metodo en ProductMapper que recibe una lista de productos y la convierte en una lista de products
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
        //espera una lista de optional, por eso usamos el .of y le devolvemos la lista mapeada de productos a products
    }

    @Override
    public Optional<List<Product>> getScasrseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
        //en el ProductMapper no tengo un metodo que devuelva una lista de optional de products entonces uso lambda para mapearlos
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prods -> mapper.toProduct(prods));
        //findById ya espera que se devuelva un optional por eso no se castea. pero si lo mapeamos porque tiene que devolver un product
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
        //tengo que hacer la conversion inversa porque el save espera un producto
    }

    @Override
    public void delete (int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
