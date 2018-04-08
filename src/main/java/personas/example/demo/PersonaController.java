package personas.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import personas.example.demo.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private Map<Integer,Persona> mapPersonas = new HashMap<Integer,Persona>();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Persona> AgregarPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(persona.getNombre());
        nuevaPersona.setApellido(persona.getApellido());
        nuevaPersona.setDireccion(persona.getDireccion());
        nuevaPersona.setNacionalidad(persona.getNacionalidad());
        this.mapPersonas.put(1,nuevaPersona);
        return new ResponseEntity<Persona>(nuevaPersona, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity persona() {

        /*List<Persona> PersonaList = new ArrayList<Persona>();
        for (int i=0;i< 10;i++) {
            Persona persona = new Persona();
            persona.setNombre("Leonardo" + i);
            persona.setApellido("Vaona" + i);
            persona.setDireccion("Pavon " + i);
            persona.setNacionalidad("Argentino");
            PersonaList.add(persona);
        }*/

           List<Persona> PersonaList  = new ArrayList<Persona>(mapPersonas.values());

        return new ResponseEntity<List<Persona>>(PersonaList, HttpStatus.OK);
    }

}


