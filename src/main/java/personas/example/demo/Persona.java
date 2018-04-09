package personas.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String nacionalidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Persona findPersonaById (List<Persona> listPersona, Integer id) {
        Persona persona = new Persona();
        for (int i = 0; i < listPersona.size(); i++) {
          Persona p = (new Persona());
          p = listPersona.get(i);
          if (p.getId() == id) {
              return p;
          }
        }
        return null;

    }

}
