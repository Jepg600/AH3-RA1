package com.example.intecap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.intecap.models.clientesModel;
import com.example.intecap.service.clientesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/clientes")
@CrossOrigin

public class clientesController {

    @Autowired
    private clientesService clientesService;

    @GetMapping("/listar")
    public Iterable<clientesModel> getClientes() {
        return this.clientesService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveClientes(@RequestBody clientesModel entity) {
        try {
            this.clientesService.save(entity);
            return ResponseEntity.ok("El cliente se guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR del servidor");
        }

    }
    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<String> deleteClientes(@PathVariable int idCliente) {
        try {
            this.clientesService.deleteById(idCliente);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> updateClientes(@RequestBody clientesModel entity) {
        try {
            this.clientesService.save(entity);
            return ResponseEntity.ok("Cliente actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

}