package Carnecol.controller;

import Carnecol.Producto;
import Carnecol.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Controlador encargado de gestionar los productos
@Controller
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

  @GetMapping("/productos")
public String mostrarFormulario(Model model) {
    model.addAttribute("producto", new Producto());

    // Consulta todos los productos registrados
var listaProductos = productoRepository.findAll();
System.out.println("PRODUCTOS ENCONTRADOS: " + listaProductos.size());
model.addAttribute("productos", listaProductos);

    return "productos";
}

    // Guarda un producto en la base de datos
    @PostMapping("/productos")
    public String guardarProducto(Producto producto) {
        productoRepository.save(producto);
        return "redirect:/productos";
    }
}