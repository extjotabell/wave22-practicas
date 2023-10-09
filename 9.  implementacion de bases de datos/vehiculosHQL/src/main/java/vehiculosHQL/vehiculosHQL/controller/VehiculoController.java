package vehiculosHQL.vehiculosHQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehiculosHQL.vehiculosHQL.dto.VehiculoDto;
import vehiculosHQL.vehiculosHQL.service.IVehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    IVehiculoService service;

    @GetMapping("/patentes")
    public ResponseEntity<?> patentes(){
        return ResponseEntity.ok(service.todasPatentes());
    }

    @GetMapping("/patentesAño")
    public ResponseEntity<?> patentesAño(){
        return ResponseEntity.ok(service.patentesPorAño());
    }

    @GetMapping("/patentesRuedas")
    public ResponseEntity<?> patentesRuedas(){
        return ResponseEntity.ok(service.patentesPorRuedas());
    }

    @GetMapping("/patenteSiniestro")
    public ResponseEntity<?> patenteSiniestro(){
        return ResponseEntity.ok(service.patentePorSiniestro());
    }

    @GetMapping("/patentePerdida")
    public ResponseEntity<?> patentePerdida(){
        return ResponseEntity.ok(service.patentePerdidaTotal());
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarVehiculo(@RequestBody VehiculoDto vehiculo){
        return ResponseEntity.ok(service.guardar(vehiculo));
    }
}
