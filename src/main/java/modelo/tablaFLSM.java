
package modelo;

import java.net.InetAddress;

/** @author Nelson **/

public class tablaFLSM {
    private String NombreSubred;
    private int Nhosts;
    private InetAddress IPred;
    private String Mascara;
    private InetAddress PrimerHost;
    private InetAddress UltimoHost;
    private InetAddress Broadcast;

    public tablaFLSM(String NombreSubred, int Nhosts, InetAddress IPred, String Mascara, InetAddress PrimerHost, InetAddress UltimoHost, InetAddress Broadcast) {
        this.NombreSubred = NombreSubred;
        this.Nhosts = Nhosts;
        this.IPred = IPred;
        this.Mascara = Mascara;
        this.PrimerHost = PrimerHost;
        this.UltimoHost = UltimoHost;
        this.Broadcast = Broadcast;
    }
    
    public String getNombreSubred() {
        return NombreSubred;
    }

    public void setNombreSubred(String NombreSubred) {
        this.NombreSubred = NombreSubred;
    }

    public int getNhosts() {
        return Nhosts;
    }

    public void setNhosts(int Nhosts) {
        this.Nhosts = Nhosts;
    }

    public InetAddress getIPred() {
        return IPred;
    }

    public void setIPred(InetAddress IPred) {
        this.IPred = IPred;
    }

    public String getMascara() {
        return Mascara;
    }

    public void setMascara(String Mascara) {
        this.Mascara = Mascara;
    }

    public InetAddress getPrimerHost() {
        return PrimerHost;
    }

    public void setPrimerHost(InetAddress PrimerHost) {
        this.PrimerHost = PrimerHost;
    }

    public InetAddress getUltimoHost() {
        return UltimoHost;
    }

    public void setUltimoHost(InetAddress UltimoHost) {
        this.UltimoHost = UltimoHost;
    }

    public InetAddress getBroadcast() {
        return Broadcast;
    }

    public void setBroadcast(InetAddress Broadcast) {
        this.Broadcast = Broadcast;
    }

    
}
