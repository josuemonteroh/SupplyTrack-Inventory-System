package com.proyecto.SupplyTrack.controller;

import com.proyecto.SupplyTrack.domain.Proveedor;
import com.proyecto.SupplyTrack.service.EmpresaProveedoraService;
import com.proyecto.SupplyTrack.service.ProveedorService;
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
@RequestMapping("/proveedor")
public class ProveedorController {

    private final ProveedorService proveedorService;
    private final EmpresaProveedoraService empresaProveedoraService;

    public ProveedorController(ProveedorService proveedorService,
                               EmpresaProveedoraService empresaProveedoraService) {
        this.proveedorService = proveedorService;
        this.empresaProveedoraService = empresaProveedoraService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var proveedores = proveedorService.getProveedores();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("totalProveedores", proveedores.size());
        model.addAttribute("empresas", empresaProveedoraService.getEmpresas());
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("pageTitle", "Proveedores");
        model.addAttribute("activeMenu", "proveedores");
        return "proveedor/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Proveedor proveedor,
                          RedirectAttributes redirectAttributes) {
        proveedorService.save(proveedor);
        redirectAttributes.addFlashAttribute("todoOk", "El proveedor fue guardado correctamente.");
        return "redirect:/proveedor/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idProveedor,
                           RedirectAttributes redirectAttributes) {
        String titulo = "todoOk";
        String mensaje = "El proveedor fue eliminado correctamente.";

        try {
            proveedorService.delete(idProveedor);
        } catch (IllegalArgumentException e) {
            titulo = "error";
            mensaje = "El proveedor no existe.";
        } catch (IllegalStateException e) {
            titulo = "error";
            mensaje = "No se puede eliminar el proveedor. Tiene datos asociados.";
        } catch (Exception e) {
            titulo = "error";
            mensaje = "Se produjo un error inesperado al intentar eliminar el proveedor.";
        }

        redirectAttributes.addFlashAttribute(titulo, mensaje);
        return "redirect:/proveedor/listado";
    }

    @GetMapping("/modificar/{idProveedor}")
    public String modificar(@PathVariable Integer idProveedor,
                            Model model,
                            RedirectAttributes redirectAttributes) {

        Optional<Proveedor> proveedorOpt = proveedorService.getProveedor(idProveedor);

        if (proveedorOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "El proveedor no existe.");
            return "redirect:/proveedor/listado";
        }

        model.addAttribute("proveedor", proveedorOpt.get());
        model.addAttribute("empresas", empresaProveedoraService.getEmpresas());
        model.addAttribute("pageTitle", "Modificar Proveedor");
        model.addAttribute("activeMenu", "proveedores");
        return "proveedor/modificar";
    }
}
