package mensajeria.controlador;

import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mensajeria.modelo.Empresa;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Álvaro
 */
public class EmpresaControlador extends Conexion{
    
    private List<Empresa> listaEmpresas;

    public EmpresaControlador() {
        listaEmpresas = new ArrayList<>();
    }
    
    public void leerEmpresa() {
        this.conectar();
        FindIterable findIterable = this.db.getCollection("Empresa").find();
        
        Empresa empresa = null;
        Iterator<Document> it = findIterable.iterator();
        while (it.hasNext()) {
            Document documento = it.next();
            String id_empresa = documento.getObjectId("_id").toString();
            String nombre_empresa = documento.getString("nombre_empresa");
            String cif = documento.getString("cif");
            String director = documento.getString("director");
            String web = documento.getString("web");
            Boolean activo = documento.getBoolean("activo");
            
            empresa = new Empresa(id_empresa, nombre_empresa, cif, director, web, activo);
            listaEmpresas.add(empresa);
        }
        this.desconectar();
    }
        
    public void insertarEmpresa(String nombre_empresa, String cif, String director, String web){
        Document documento = new Document()
                .append("nombre_empresa", nombre_empresa)
                .append("cif", cif)
                .append("director", director)
                .append("web", web)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Empresa").insertOne(documento);
        this.desconectar();
    }
    
    public void modificarEmpresa(String id_empresa, String nombre_empresa, String cif, String director, String web){
        ObjectId id = new ObjectId(id_empresa);
        Document documento = new Document()
                .append("nombre_empresa", nombre_empresa)
                .append("cif", cif)
                .append("director", director)
                .append("web", web)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Empresa").replaceOne(new Document("_id", id), documento);
        this.desconectar();
    }
    
    public void eliminarEmpresa(String id_empresa){
        ObjectId id = new ObjectId(id_empresa);
        
        this.conectar();
        this.db.getCollection("Empresa").updateOne(new Document("_id", id), 
                new Document("$set", new Document("activo", false)));
        this.desconectar();
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
    
}
