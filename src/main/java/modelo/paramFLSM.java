package modelo;

import java.net.InetAddress;

/* @author Nelson */
public class paramFLSM {
    //Parametros Iniciales
    String direccionIP;
    int prefijo;
    int nSubred;
    int hostxSubred;
    
    //Parametros Auxiliares
    InetAddress Mascara;
    
    
    //Calculo del prefijo (por defecto) a partir de la direccion ip
    public int calcPrefijo(){
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
    //Calculo del prefijo que las subredes tendran
    public int calcPrefSub(){
        int bitstomadosHost = bitsTomadosDelHost(nSubred);
        prefijo += bitstomadosHost;
        System.out.println("Prefijo real: "+prefijo);
        return prefijo;
    }
    
    //Funcion para determinar el número de bits que hay que tomar de la parte de host
    public int bitsTomadosDelHost(int nsubredes) {
        // Calcula n usando la fórmula 2^n >= nsubredes
        double resultadoLogaritmo = Math.log(nsubredes) / Math.log(2);
        int nbitstomados = (int) Math.ceil(resultadoLogaritmo);
        return nbitstomados;
    }
    
    //Calculo de host por subred, de acuerdo a n subredes
    public int hostxSubred(int numeroSubredes) {
        // Calcula H usando la fórmula H = 2^n - 2
        int host = (int) Math.pow(2, numeroSubredes) - 2;
        return host;
    }
    
    
    //Se calculan la cantidad de host a partir de nsubredes y el prefijo
    public int calcHost(){
        int bitsTomadosHost = bitsTomadosDelHost(nSubred);
        
        int hostxsubred = hostxSubred((32 - prefijo) - bitsTomadosHost);
                    
        return hostxsubred;
    }
    
}
