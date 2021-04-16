package objetosTransferencia;

import java.util.List;

/**
 *
 * @author José/Oswaldo
 */
public class Lista<E> {

    private String tituloTabla;
    private List<E> lista;

    
    public Lista() {
    }

    /**
     * Regresa el titulo de la tabla
     *
     * @return Titulo de la tabla
     */
    public String getTituloTabla() {
        return tituloTabla;
    }

    /**
     * Establece el titulo de la tabla
     *
     * @param tituloTabla Titulo de la tabla
     */
    public void setTituloTabla(String tituloTabla) {
        this.tituloTabla = tituloTabla;
    }

    /**
     * Regresa la lista con los valores de la tabla
     *
     * @return Lista con los valores de la tabla
     */
    public List<E> getLista() {
        return lista;
    }

    /**
     * Establece el atributo lista con la lista con los valores de la tabla
     *
     * @param lista Lista con los valores de la tabla
     */
    public void setLista(List<E> lista) {
        this.lista = lista;
    }
}
