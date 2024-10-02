package com.example.intecap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.intecap.models.productosModel;
import com.example.intecap.service.productosService;


@RestController
@RequestMapping("/productos")
@CrossOrigin

public class productosController {
    
    @Autowired
    private productosService productosService;

     @GetMapping("/listar")
    public Iterable<productosModel> getProductos() {
        return this.productosService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveProductos(@RequestBody productosModel entity) {       
        try{
            this.productosService.save(entity);
            return ResponseEntity.ok("Producto guardado correctamente");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }
    @DeleteMapping("/eliminar/{idProductos}")
    public ResponseEntity<String> deleteProductos(@PathVariable int idProductos) {       
        try{
            this.productosService.deleteById(idProductos);
            return ResponseEntity.ok("Producto eliminado correctamente");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> updateProductos(@RequestBody productosModel entity) {
        try {
            this.productosService.save(entity);
            return ResponseEntity.ok("Producto actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @DeleteMapping("/eliminar-todos")
public ResponseEntity<String> deleteAllProductos() {
    try {
        this.productosService.deleteAll(); // Implementar en el servicio
        return ResponseEntity.ok("Todos los productos han sido eliminados");
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error al eliminar productos");
    }
}

}