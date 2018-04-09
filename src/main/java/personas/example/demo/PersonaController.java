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


import personas.example.demo.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private Map<Integer,Persona> mapPersonas = new HashMap<Integer,Persona>();
    private List<Persona>PersonaList = new ArrayList<Persona>();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity persona() {
        PersonaList  =  new ArrayList<Persona>(mapPersonas.values());
        return new ResponseEntity<List<Persona>>(PersonaList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPersona(@PathVariable Integer id){
        Persona persona = (new Persona()).findPersonaById(PersonaList,id);
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = new Persona();
        nuevaPersona.setId(persona.getId());
        nuevaPersona.setNombre(persona.getNombre());
        nuevaPersona.setApellido(persona.getApellido());
        nuevaPersona.setDireccion(persona.getDireccion());
        nuevaPersona.setNacionalidad(persona.getNacionalidad());
        this.mapPersonas.put(nuevaPersona.getId(),nuevaPersona);
        return new ResponseEntity<Persona>(nuevaPersona, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity actualizarPeronsa (@RequestBody Persona persona){

        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

}


