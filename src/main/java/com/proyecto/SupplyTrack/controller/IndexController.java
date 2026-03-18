package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.service.CategoriaService;
import com.proyecto.SupplyTrack.service.ProductoService;
import com.proyecto.SupplyTrack.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final ProveedorService proveedorService;
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public IndexController(ProveedorService proveedorService,
                           ProductoService productoService,
                           CategoriaService categoriaService) {
        this.proveedorService = proveedorService;
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalProveedores", proveedorService.getProveedores().size());
        model.addAttribute("totalProductos", productoService.listarProductos().size());
        model.addAttribute("totalPedidos", 0);
        model.addAttribute("totalCategorias", categoriaService.getCategorias().size());

        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("activeMenu", "dashboard");
        return "index";
    }

    @GetMapping("/en-desarrollo")
    public String enDesarrollo(Model model) {
        model.addAttribute("pageTitle", "Módulo en desarrollo");
        model.addAttribute("activeMenu", "");
        return "general/en-desarrollo";
    }
}