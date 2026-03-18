package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.domain.Categoria;
import com.proyecto.SupplyTrack.service.CategoriaService;
import jakarta.validation.Valid;
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
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("pageTitle", "Categorías");
        model.addAttribute("activeMenu", "categorias");
        return "categoria/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Categoria categoria,
                          RedirectAttributes redirectAttributes) {
        categoriaService.save(categoria);
        redirectAttributes.addFlashAttribute("todoOk", "La categoría fue guardada correctamente.");
        return "redirect:/categoria/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idCategoria,
                           RedirectAttributes redirectAttributes) {
        try {
            categoriaService.delete(idCategoria);
            redirectAttributes.addFlashAttribute("todoOk", "La categoría fue eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "La categoría no existe.");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar la categoría. Tiene productos asociados.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Se produjo un error inesperado al intentar eliminar la categoría.");
        }
        return "redirect:/categoria/listado";
    }

}
