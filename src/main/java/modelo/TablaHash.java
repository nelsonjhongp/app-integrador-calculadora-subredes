
package modelo;

import modelo.Usuario;

/** @author Nelson **/

public class TablaHash {
    private static final int TAMANO_TABLA = 100; // Tamaño de la tabla hash
    private EntradaHash[] tabla;

    public EntradaHash[] getTabla() {
        return tabla;
    }

    public void setTabla(EntradaHash[] tabla) {
        this.tabla = tabla;
    }

    public class EntradaHash {
        private String clave;
        private Usuario usuario;
        private EntradaHash siguiente;

        public EntradaHash(String clave, Usuario usuario) {
            this.clave = clave;
            this.usuario = usuario;
            this.siguiente = null;
        }

        public EntradaHash getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(EntradaHash siguiente) {
            this.siguiente = siguiente;
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        
    }

    public TablaHash() {
        tabla = new EntradaHash[TAMANO_TABLA];
    }
    
    private int obtenerIndiceTabHash(String clave) {
        final int A = 487; // Constante de multiplicación
        int valorHash = 0;

        for (int i = 0; i < clave.length(); i++) {
            valorHash = (A * valorHash + clave.charAt(i)) % TAMANO_TABLA;
        }

        return valorHash;
    }

    // Insertar una nueva entrada clave-valor en la tabla
    public void insertarTabHash(String clave, Usuario usuario) {
        int indice = obtenerIndiceTabHash(clave);
        EntradaHash nuevaEntrada = new EntradaHash(clave, usuario);

        if (tabla[indice] == null) {
            tabla[indice] = nuevaEntrada;
        } else {
            EntradaHash actual = tabla[indice];
            
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevaEntrada);
        }
    }

    // Obtener el valor asociado a una clave
    public Usuario obtenerValorTabHash(String clave) {
        int indice = obtenerIndiceTabHash(clave);
        EntradaHash actual = tabla[indice];
        
        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                return actual.getUsuario();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Verificar si la tabla contiene una clave determinada
    public boolean contieneClaveTabHash(String clave) {
        int indice = obtenerIndiceTabHash(clave);
        EntradaHash actual = tabla[indice];
        
        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Eliminar una entrada de la tabla según la clave
    public void eliminarTabHash(String clave) {
        int indice = obtenerIndiceTabHash(clave);
        EntradaHash actual = tabla[indice];
        EntradaHash anterior = null;

        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                if (anterior == null) {
                    tabla[indice] = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }
}