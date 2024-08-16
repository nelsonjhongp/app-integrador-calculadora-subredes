
package vista;

/* 🚀 Developed by NelsonJGP */
public class AutoCompletarManager {
    //Autocompletar Prefijo
    //Calculo del prefijo (por defecto) a partir de la direccion ip
    public int calcPrefijo(String direccionIP){
        int prefijo = 0;
        String[] octetos = direccionIP.split("\\.");

        if (octetos.length != 4) {
            System.out.println("Dirección IP inválida");
        } else {
            int primerOcteto = Integer.parseInt(octetos[0]);

            if (primerOcteto <= 126) prefijo = 8;
            else if (primerOcteto <= 191) prefijo = 16;
            else if (primerOcteto <= 223) prefijo = 24;
            else System.out.println("No se pudo determinar la clase");
        }
        return prefijo;
    }
    
    //Autocompletar Host
    //Se calculan la cantidad de host a partir de nsubredes y el prefijo
    public int calcHost(int nsubredes, int prefijo){
        return (int) Math.pow(2, (32-prefijo) - (int) Math.ceil(Math.log(nsubredes) / Math.log(2))) - 2;
    }
}
