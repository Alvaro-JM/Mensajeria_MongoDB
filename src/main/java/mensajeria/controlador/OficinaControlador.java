package mensajeria.controlador;

import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mensajeria.modelo.Oficina;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Álvaro
 */
public class OficinaControlador extends Conexion{
    
    private List<Oficina> listaOficinas;

    public OficinaControlador(){
        listaOficinas = new ArrayList<>();
        leerOficina();
    }
    
    private void leerOficina(){
        this.conectar();
        FindIterable findIterable = this.db.getCollection("Oficina").find();
        
        Oficina oficina = null;
        Iterator<Document> it = findIterable.iterator();
        while (it.hasNext()) {
            Document documento = it.next();
            String id_oficina = documento.getObjectId("_id").toString();
            String direccion_oficina = documento.getString("direccion_oficina");
            String telefono_oficina = documento.getString("telefono_oficina");
            String email = documento.getString("email");
            String encargado = documento.getString("encargado");
            String empresa = documento.getString("empresa");
            Boolean activo = documento.getBoolean("activo");
            
            oficina = new Oficina(id_oficina, direccion_oficina, telefono_oficina, email, encargado, empresa, activo);
            listaOficinas.add(oficina);
        }
        this.desconectar();
    }
    
    public void insertarOficina(String direccion_oficina, String telefono_oficina, String email, String encargado, String empresa){
        Document documento = new Document()
                .append("direccion_oficina", direccion_oficina)
                .append("telefono_oficina", telefono_oficina)
                .append("email", email)
                .append("encargado", encargado)
                .append("empresa", empresa)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Oficina").insertOne(documento);
        this.desconectar();
    }
    
    public void modificarOficina(String id_oficina, String direccion_oficina, String telefono_oficina, String email, String encargado, String empresa){
        ObjectId id = new ObjectId(id_oficina);
        Document documento = new Document()
                .append("direccion_oficina", direccion_oficina)
                .append("telefono_oficina", telefono_oficina)
                .append("email", email)
                .append("encargado", encargado)
                .append("empresa", empresa)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Oficina").replaceOne(new Document("_id", id), documento);
        this.desconectar();
    }
    
    public void eliminarOficina(String id_oficina){
        ObjectId id = new ObjectId(id_oficina);
        
        this.conectar();
        this.db.getCollection("Oficina").updateOne(new Document("_id", id), 
                new Document("$set", new Document("activo", false)));
        this.desconectar();
    }
    
    public List<Oficina> getListaOficinas() {
        return listaOficinas;
    }
    
}
