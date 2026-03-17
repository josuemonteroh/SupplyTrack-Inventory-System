package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.domain.Tienda;
import com.proyecto.SupplyTrack.service.TiendaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    private final TiendaService tiendaService;

    public TiendaController(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var tiendas = tiendaService.getTiendas();
        model.addAttribute("tiendas", tiendas);
        model.addAttribute("totalTiendas", tiendas.size());
        model.addAttribute("tienda", new Tienda());
        model.addAttribute("pageTitle", "Tiendas");
        model.addAttribute("activeMenu", "tiendas");
        return "tienda/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Tienda tienda,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Complete correctamente los campos de la tienda.");
            return "redirect:/tienda/listado";
        }

        try {
            tiendaService.save(tienda);
            redirectAttributes.addFlashAttribute("todoOk", "La tienda fue guardada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Se produjo un error al intentar guardar la tienda.");
        }
        return "redirect:/tienda/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idTienda,
                           RedirectAttributes redirectAttributes) {
        try {
            tiendaService.delete(idTienda);
            redirectAttributes.addFlashAttribute("todoOk", "La tienda fue eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "La tienda no existe.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar la tienda. Asegúrese de que no tenga inventario asociado.");
        }
        return "redirect:/tienda/listado";
    }

}