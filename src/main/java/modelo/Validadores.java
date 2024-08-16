
package modelo;

/* 🚀 Developed by NelsonJGP */
public class Validadores {
    //Validador de Direccion Ip correcta
    public boolean validacionIP(String ipAddress) {
        // Patron para validar el formato de una dirección IPv4
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
                + "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
                + "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
                + "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        // Comprobar si la dirección IP coincide con el formato y el rango
        return ipAddress.matches(regex);
    }
    
    //Validador de Prefijo
    
    
    //Validador de host
    
    
    //Validador para no sobrepasar Host Posibles
    
    
    //Validador de Interfaz
    
    
}
