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

   @PostMapping("/productos")
public String guardarProducto(Producto producto) {

    if (producto.getPrecio() == null || producto.getPrecio() < 0 ||
        producto.getStock() == null || producto.getStock() < 0) {

        return "redirect:/productos";
    }

    productoRepository.save(producto);
    return "redirect:/productos";
}
}