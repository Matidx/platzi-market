package com.platzimarket.persistence.entity;

import javax.persistence.*;

@Entity //indica a una clase de java que va a representar una tabla de la BD (en este caso la tabla productos)
@Table (name = "productos") //recibe el nombre de la tabla a la cual esta mapeando la clase
public class Producto {

    @Id //es el atributo como clave primaria de la tabla dentro de la clase
    @GeneratedValue (strategy = GenerationType.IDENTITY) //permite generar automaticamente valores para las clases primarias de nuestra clase
    @Column (name = "id_producto") //se le pone a los atributos de la clase, no es obligatoria, se indica solo cuando el nombre de la columna es diferente al nombre del atributo de la tabla
    private Integer idProducto;

    private String nombre; //aca no necesito el @Column porque el nombre del atributo es igual al nombre de la columna en la BD

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne //relación de muchos a uno
    @JoinColumn (name = "id_categoria", insertable = false, updatable = false)//especifica una columna para unir una asociación de entidades o una colección de elementos.
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
