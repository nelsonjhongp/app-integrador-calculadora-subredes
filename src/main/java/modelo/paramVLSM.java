
package modelo;

import java.util.ArrayList;

public class paramVLSM {
    //Parametros Iniciales
    private String direccionIP;
    private int prefijo;
    private int nSubred;
    private ArrayList<String> varioshost;

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public int getnSubred() {
        return nSubred;
    }

    public void setnSubred(int nSubred) {
        this.nSubred = nSubred;
    }

    public ArrayList<String> getVarioshost() {
        return varioshost;
    }

    public void setVarioshost(ArrayList<String> varioshost) {
        this.varioshost = varioshost;
    }

    
}
