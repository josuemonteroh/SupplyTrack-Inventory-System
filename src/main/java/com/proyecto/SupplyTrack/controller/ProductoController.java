package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.domain.Producto;
import com.proyecto.SupplyTrack.service.CategoriaService;
import com.proyecto.SupplyTrack.service.ProductoService;
import com.proyecto.SupplyTrack.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("proveedores", proveedorService.getProveedores());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("producto", new Producto());
        model.addAttribute("totalProductos", productoService.listarProductos().size());
        model.addAttribute("activeMenu", "productos");
        model.addAttribute("pageTitle", "Productos");
        return "productos/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        if (producto.getProveedor() != null && producto.getProveedor().getIdProveedor() == null) {
            producto.setProveedor(null);
        }
        if (producto.getCategoria() != null && producto.getCategoria().getIdCategoria() == null) {
            producto.setCategoria(null);
        }
        productoService.guardarProducto(producto);
        return "redirect:/producto/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(Integer idProducto) {
        productoService.eliminarProducto(idProducto);
        return "redirect:/producto/listado";
    }
}