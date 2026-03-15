package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.domain.Inventario;
import com.proyecto.SupplyTrack.service.InventarioService;
import com.proyecto.SupplyTrack.service.TiendaService;
import com.proyecto.SupplyTrack.service.ProductoService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService inventarioService;
    private final TiendaService tiendaService;
    private final ProductoService productoService;

    public InventarioController(InventarioService inventarioService, TiendaService tiendaService, ProductoService productoService) {
        this.inventarioService = inventarioService;
        this.tiendaService = tiendaService;
        this.productoService = productoService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var inventarios = inventarioService.getInventarios();
        model.addAttribute("inventarios", inventarios);
        model.addAttribute("totalInventarios", inventarios.size());
        model.addAttribute("inventario", new Inventario());
        model.addAttribute("productos" , productoService.getProductos());
        model.addAttribute("tiendas" , tiendaService.getTiendas());
        model.addAttribute("pageTitle", "Inventario");
        model.addAttribute("activeMenu", "inventario");
        return "inventario/listado";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Inventario inventario, RedirectAttributes redirectAttributes) {
        try{
            inventarioService.save(inventario);
            redirectAttributes.addFlashAttribute("todoOk", "El inventario fue guardado correctamente.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Se produjo un error inesperado al intentar guardar el inventario.");
        }
        return "redirect:/inventario/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idInventario,
                           RedirectAttributes redirectAttributes) {
        try {
            inventarioService.delete(idInventario);
            redirectAttributes.addFlashAttribute("todoOk", "Inventario eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "El inventario no existe.");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ocurrió un error inesperado al eliminar el inventario.");
        }

        return "redirect:/inventario/listado";
    }

    @GetMapping("/modificar/{idInventario}")
    public String modificar(@PathVariable Integer idInventario,
                            Model model,
                            RedirectAttributes redirectAttributes) {

        Optional<Inventario> inventarioOpt = inventarioService.getInventario(idInventario);

        if (inventarioOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "El inventario no existe.");
            return "redirect:/inventario/listado";
        }

        model.addAttribute("inventario", inventarioOpt.get());
        model.addAttribute("productos", productoService.getProductos());
        model.addAttribute("tiendas", tiendaService.getTiendas());
        model.addAttribute("pageTitle", "Modificar Inventario");
        model.addAttribute("activeMenu", "inventario");

        return "inventario/modificar";
    }

}
