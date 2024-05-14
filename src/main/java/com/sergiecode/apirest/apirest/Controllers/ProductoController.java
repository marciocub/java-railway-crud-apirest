package com.sergiecode.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiecode.apirest.apirest.Entities.Producto;
import com.sergiecode.apirest.apirest.Repositories.ProductoRespository;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoRespository productoRepository;
	
	@GetMapping
	public  List<Producto> obtenerProductos(){
		return productoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public  Producto obtenerProductoPorId(@PathVariable Long id){
		Producto producto = productoRepository.findById(id)
		.orElseThrow(()-> new RuntimeException("no se encontro el producto"));
		
		return producto;
	}
	
	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	@PutMapping("/{id}")
	public Producto actualizarProducto(@PathVariable Long id , @RequestBody Producto detalleProducto ) {
		
		Producto producto = productoRepository.findById(id)
		.orElseThrow(()-> new RuntimeException("no se encontro el producto"));
		
		producto.setNombre(detalleProducto.getNombre());
		producto.setPrecio(detalleProducto.getPrecio());
		
		return productoRepository.save(producto);
	}
	
	@DeleteMapping("/{id}")
	public  String borrarProductoPorId(@PathVariable Long id){
		Producto producto = productoRepository.findById(id)
		.orElseThrow(()-> new RuntimeException("no se encontro el producto"));
		
		productoRepository.delete(producto);
		
		return "El productoo con el ID: " + id + " fue eliminado";
	}

}
