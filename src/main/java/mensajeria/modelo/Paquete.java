package mensajeria.modelo;

import java.util.Date;

/**
 *
 * @author Álvaro
 */
public class Paquete{
    private final String id_paquete;
    private Date fecha_entrega;
    private String direccion_destino;
    private String telefono_destino;
    private String direccion_origen;
    private String telefono_origen;
    private String repartidor;
    private boolean activo;

    public Paquete(String id_paquete, Date fecha_entrega, String direccion_destino,
            String telefono_destino, String direccion_origen, String telefono_origen,
            String repartidor, boolean activo) {
        this.id_paquete = id_paquete;
        this.fecha_entrega = fecha_entrega;
        this.direccion_destino = direccion_destino;
        this.telefono_destino = telefono_destino;
        this.direccion_origen = direccion_origen;
        this.telefono_origen = telefono_origen;
        this.repartidor = repartidor;
        this.activo = activo;
    }

    public String getId_paquete() {
        return id_paquete;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDireccion_destino() {
        return direccion_destino;
    }

    public void setDireccion_destino(String direccion_destino) {
        this.direccion_destino = direccion_destino;
    }

    public String getTelefono_destino() {
        return telefono_destino;
    }

    public void setTelefono_destino(String telefono_destino) {
        this.telefono_destino = telefono_destino;
    }

    public String getDireccion_origen() {
        return direccion_origen;
    }

    public void setDireccion_origen(String direccion_origen) {
        this.direccion_origen = direccion_origen;
    }

    public String getTelefono_origen() {
        return telefono_origen;
    }

    public void setTelefono_origen(String telefono_origen) {
        this.telefono_origen = telefono_origen;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
