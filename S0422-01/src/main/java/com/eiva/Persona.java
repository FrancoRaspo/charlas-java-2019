package com.eiva;

import java.util.Arrays;
import java.util.List;

public class Persona {

        private Long id;
        private Long edad;
        String nombre;
        private String apellido;
        
        public Persona() {}
        
        public Persona(Long id, String nombre, String apellido, Long edad) {
            super();
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad=edad;
        }
        
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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

     

        public Long getEdad() {
            return edad;
        }

        public void setEdad(Long edad) {
            this.edad = edad;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Persona other = (Persona) obj;
            if (apellido == null) {
                if (other.apellido != null)
                    return false;
            } else if (!apellido.equals(other.apellido))
                return false;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            if (nombre == null) {
                if (other.nombre != null)
                    return false;
            } else if (!nombre.equals(other.nombre))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
        }
        
        public static List<Persona> personas(){
            return Arrays.asList( 
                    new Persona(1L,"Diego", "Cairone", 1L),
                    new Persona(2L,"Franco","Raspo", 1L),
                    new Persona(3L,"Pablo","Raspo", 1L),
                    new Persona(4L,"Analia","Raspo",1L),
                    new Persona(5L,"Paula","Herrera",1L),
                    new Persona(6L,"Julio","Martinez",1L),
                    new Persona(7L,"Nicolas","Fabucci",1L),
                    new Persona(8L,"Natalia","Lopez",1L),
                    new Persona(9L,"Eduardo","Nazor", 1L),
                    new Persona(10L,"Sergio","Freschi", 1L),
                    new Persona(11L,"Matias","Maini", 1L),
                    new Persona(12L,"Ismael","Ait", 1L)
                    );
                    
        }
        
        
}
