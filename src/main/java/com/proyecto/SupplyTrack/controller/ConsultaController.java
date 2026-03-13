package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.service.ConsultaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/productos")
    public String busquedaProductos(@RequestParam(required = false) String termino,
                                    Model model) {
        model.addAttribute("termino", termino);
        model.addAttribute("productos", consultaService.buscarProductos(termino));
        model.addAttribute("pageTitle", "Búsqueda de productos");
        model.addAttribute("activeMenu", "consultas-productos");
        return "consultas/busqueda-productos";
    }

    @GetMapping("/inventario-por-tienda")
    public String inventarioPorTienda(@RequestParam(required = false) Integer idTienda,
                                      Model model) {
        model.addAttribute("idTienda", idTienda);
        model.addAttribute("tiendas", consultaService.listarTiendas());
        model.addAttribute("inventarios", consultaService.consultarInventarioPorTienda(idTienda));
        model.addAttribute("pageTitle", "Inventario por tienda");
        model.addAttribute("activeMenu", "consultas-inventario");
        return "consultas/inventario-por-tienda";
    }
}