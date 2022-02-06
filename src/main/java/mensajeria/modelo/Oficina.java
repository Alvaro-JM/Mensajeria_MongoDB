package mensajeria.modelo;

/**
 *
 * @author Álvaro
 */
public class Oficina{
    private final String id_oficina;
    private String direccion_oficina;
    private String telefono_oficina;
    private String email;
    private String encargado;
    private String empresa;
    private boolean activo;

    public Oficina(String id_oficina, String direccion_oficina, String telefono_oficina,
            String email, String encargado, String empresa, boolean activo) {
        this.id_oficina = id_oficina;
        this.direccion_oficina = direccion_oficina;
        this.telefono_oficina = telefono_oficina;
        this.email = email;
        this.encargado = encargado;
        this.empresa = empresa;
        this.activo = activo;
    }

    public String getId_oficina() {
        return id_oficina;
    }

    public String getDireccion_oficina() {
        return direccion_oficina;
    }

    public void setDireccion_oficina(String direccion_oficina) {
        this.direccion_oficina = direccion_oficina;
    }

    public String getTelefono_oficina() {
        return telefono_oficina;
    }

    public void setTelefono_oficina(String telefono_oficina) {
        this.telefono_oficina = telefono_oficina;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
}
