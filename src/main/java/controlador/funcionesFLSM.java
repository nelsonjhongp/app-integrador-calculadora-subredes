
package controlador;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

/** @author Nelson **/

public class funcionesFLSM {
    InetAddress dirIP;
    
    //Calculo de la posicion (octeto donde cae el prefijo)
    public int posicionOcteto(int prefijoFinal) {
        int posicion = (int) Math.ceil(prefijoFinal / 8.0);
        System.out.println("Posicion = " + posicion);
        return posicion;
    }
    
    //Es el prefijo verdadero de acuerdo a los datos brindados
    public int prefijoNuevo(int prefijo, int nsubredes) {
        int bitstomadosHost = (int) Math.ceil(Math.log(nsubredes) / Math.log(2));
        prefijo += bitstomadosHost;
        System.out.println("Prefijo nuevo: " + prefijo);
        return prefijo;
    }
    
    //La cantidad de bits de una dirIp, una funcion simple en realidad
    /*---*---*---*---- FIN ----*---*---*---*/
    /*=====================================*/
    
    
    /*=================================================*/
    //Valor decimal del octeto donde se toman los bits
    public int calcDecimalOcteto(int prefijoFinal, int posicion) {
        int nbitsOcteto = 0;
        
        nbitsOcteto = prefijoFinal - 8 * (posicion - 1);
        int bitsEnDecimal = 0, max = 7;
        do {
            
            bitsEnDecimal += Math.pow(2, max);
            System.out.println("bitendecimal: "+bitsEnDecimal);
            max--; nbitsOcteto--;
        } while (nbitsOcteto>=1);
        
        return bitsEnDecimal;
    }
    
    /*---*---*---*---- FIN ----*---*---*---*/
    /*=====================================*/
    
    
    /*=================================================*/
    
    /*---- Funciones Aritmeticas para direccion IP ----*/
    //En un principio agregar la funcion de resta, pero con la suma es suficiente
    //Suma usando recursividad
    public InetAddress sumarOcteto(InetAddress direccionIP, int octeto, int valorASumar) throws UnknownHostException {
        byte[] direccionBytes = direccionIP.getAddress();

        if (octeto >= 0 && octeto < direccionBytes.length) {
            int valorActual = direccionBytes[octeto] & 0xFF; // Usar máscara para obtener el valor sin signo
            int suma = valorActual + valorASumar;

            direccionBytes[octeto] = (byte)(suma & 0xFF); // Establecer el nuevo valor en el octeto

            // Manejar el desbordamiento hacia octetos anteriores
            int carry = suma >> 8;
            for (int i = octeto - 1; i >= 0 && carry > 0; i--) {
                valorActual = direccionBytes[i] & 0xFF;
                suma = valorActual + carry;
                direccionBytes[i] = (byte)(suma & 0xFF);
                carry = suma >> 8;
            }

            return InetAddress.getByAddress(direccionBytes);
        } else {
            throw new IllegalArgumentException("El octeto especificado está fuera de rango.");
        }
    }
    
    /*---- Funciones Otras para direccion IP ----*/
    public InetAddress calcularDireccionDeRed(InetAddress ip, int prefijo) {
        try {
            InetAddress direccionIP = ip;
            byte[] bytesDireccionIP = direccionIP.getAddress();

            // Calcular la máscara de subred
            int mascara = 0xFFFFFFFF << (32 - prefijo);
            byte[] bytesMascara = new byte[]{
                    (byte) ((mascara >> 24) & 0xFF),
                    (byte) ((mascara >> 16) & 0xFF),
                    (byte) ((mascara >> 8) & 0xFF),
                    (byte) (mascara & 0xFF)
            };

            // Calcular la dirección de red
            byte[] bytesDireccionDeRed = new byte[4];
            for (int i = 0; i < 4; i++) {
                bytesDireccionDeRed[i] = (byte) (bytesDireccionIP[i] & bytesMascara[i]);
            }

            InetAddress direccionDeRed = InetAddress.getByAddress(bytesDireccionDeRed);
            return direccionDeRed;
        } catch (UnknownHostException e) {
            return null;
        }
    }
    
    
    public int[] separacionOcho(int valor) {
        int maxMultiploDeOcho = (valor / 8) * 8;
        int resto = valor % 8; // Calcula el resto.

        int[] resultado = {maxMultiploDeOcho, resto};
        return resultado;
    }
    
    public String calculoMascara (int decimalOcteto, int posicion){
        int[] valmascara = {255,255,255,255};
        //if (posicion==0) {valmascara[0]=0;valmascara[1]=0;valmascara[2]=0;valmascara[3]=0;}
        if (posicion==1) {valmascara[1]=0;valmascara[2]=0;valmascara[3]=0;}
        if (posicion==2) {valmascara[2]=0;valmascara[3]=0;}
        if (posicion==3) {valmascara[3]=0;}
        if (posicion!=4) {valmascara[posicion] = decimalOcteto;}
        else{valmascara[posicion-1] = decimalOcteto;}
        return valmascara[0]+"."+valmascara[1]+"."+valmascara[2]+"."+valmascara[3];
    }
    
    
    
    public static int calcularN(int H) {
        int n = 0;
        while (Math.pow(2, n) - 2 < H) {
            n++;
        }
        return n;
    }
    public static int calcHostxSubred(int H) {
        int n = calcularN(H);
        return (int) (Math.pow(2, n) - 2);
    }
    
    public static String calcularMascara(int prefijo) {
        if (prefijo < 0 || prefijo > 32) {
            return "Prefijo inválido";
        }

        int mascara = 0xFFFFFFFF << (32 - prefijo);
        int octeto1 = (mascara >> 24) & 0xFF;
        int octeto2 = (mascara >> 16) & 0xFF;
        int octeto3 = (mascara >> 8) & 0xFF;
        int octeto4 = mascara & 0xFF;

        return octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4;
    }
    
    public List<tablaFLSM> calcularFLSM(InetAddress dirIP, int nsubredes, int prefijo, int nhost) throws UnknownHostException{
        List<tablaFLSM> tblFLSM = new ArrayList();
        
        int prefFinal = prefijoNuevo(prefijo, nsubredes);
        int posicion = posicionOcteto(prefFinal);

        int decimalOcteto = calcDecimalOcteto(prefFinal, posicion);
        
        int incrementoip = 256-decimalOcteto;
        
        String mascara = calcularMascara(prefFinal);
        
        InetAddress DireccionRed = calcularDireccionDeRed(dirIP, prefijo);


        for (int i = 0; i < nsubredes; i++) {
            String subred = "Subred "+(i+1);
            //Listo, siempre de la parte del host se suma uno, que es el extremo ultimo octeto del host
            InetAddress PrimerHost = sumarOcteto(DireccionRed, 3, 1);
            //primeraIP = flsm.sumarOcteto(primeraIP, posicion, incrementoip);
            InetAddress UltimoHost = sumarOcteto(DireccionRed, 3, nhost);
            InetAddress Broadcast = sumarOcteto(DireccionRed, 3, nhost+1);
            tblFLSM.add(new tablaFLSM(subred, nhost, DireccionRed, mascara, PrimerHost, UltimoHost, Broadcast));
            DireccionRed = sumarOcteto(DireccionRed, posicion-1, incrementoip);
        }

        return tblFLSM;
    }
    
    public List<tablaVLSM> calcularVLSM(InetAddress dirIP, int nsubredes, int prefijo, ArrayList<String> varioshost) throws UnknownHostException{
        List<tablaVLSM> tblVLSM = new ArrayList();
        String mascara;
        
        InetAddress DireccionRed = calcularDireccionDeRed(dirIP, prefijo);
        int prefRed;

        
        for (int i = 0; i < nsubredes; i++) {
            String subred = "Subred "+(i+1);
            int host = Integer.parseInt(varioshost.get(i));
            host = calcHostxSubred(host);
            
            prefRed = 32-(prefijo+calcularN(host))+prefijo;
            mascara = calcularMascara(prefRed);
            
            //Listo, siempre de la parte del host se suma uno, que es el extremo ultimo octeto del host
            InetAddress PrimerHost = sumarOcteto(DireccionRed, 3, 1);
            //primeraIP = flsm.sumarOcteto(primeraIP, posicion, incrementoip);
            InetAddress UltimoHost = sumarOcteto(DireccionRed, 3, host);
            InetAddress Broadcast = sumarOcteto(DireccionRed, 3, host+1);
            tblVLSM.add(new tablaVLSM(subred, host, DireccionRed, prefRed, mascara, PrimerHost, UltimoHost, Broadcast));
            DireccionRed = sumarOcteto(DireccionRed, 3, host+2);
        }

        return tblVLSM;
    }
    
    /*---*---*---*---- FIN ----*---*---*---*/
    /*=====================================*/
}
