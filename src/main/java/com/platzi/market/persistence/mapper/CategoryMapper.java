package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);
    //voy a obtener una category, mappeando la categoria que viene dentro de los argumentos
    //source(categoria) es el codigo fuente y a donde quiero llevar ese valor(category)


    @InheritInverseConfiguration //hace el mapeo inverso
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}


