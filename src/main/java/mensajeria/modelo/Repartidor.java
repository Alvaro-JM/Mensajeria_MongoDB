package mensajeria.modelo;

/**
 *
 * @author Álvaro
 */
public class Repartidor{
    private final String id_repartidor;
    private String dni;
    private String nombre_repartidor;
    private String telefono_repartidor;
    private int antiguedad;
    private String oficina;
    private boolean activo;

    public Repartidor(String id_repartidor, String dni, String nombre_repartidor, String telefono_repartidor, int antiguedad, String oficina, boolean activo) {
        this.id_repartidor = id_repartidor;
        this.dni = dni;
        this.nombre_repartidor = nombre_repartidor;
        this.telefono_repartidor = telefono_repartidor;
        this.antiguedad = antiguedad;
        this.oficina = oficina;
        this.activo = activo;
    }

    public String getId_repartidor() {
        return id_repartidor;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_repartidor() {
        return nombre_repartidor;
    }

    public void setNombre_repartidor(String nombre_repartidor) {
        this.nombre_repartidor = nombre_repartidor;
    }

    public String getTelefono_repartidor() {
        return telefono_repartidor;
    }

    public void setTelefono_repartidor(String telefono_repartidor) {
        this.telefono_repartidor = telefono_repartidor;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
}
