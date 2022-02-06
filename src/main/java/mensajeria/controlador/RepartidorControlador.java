package mensajeria.controlador;

import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mensajeria.modelo.Repartidor;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author Álvaro
 */
public class RepartidorControlador extends Conexion{
    
    private List<Repartidor> listaRepartidores;

    public RepartidorControlador(){
        listaRepartidores = new ArrayList<>();
        leerRepartidor();
    }
    
    private void leerRepartidor(){
        this.conectar();
        FindIterable findIterable = this.db.getCollection("Repartidor").find();
        
        Repartidor repartidor = null;
        Iterator<Document> it = findIterable.iterator();
        while (it.hasNext()) {
            Document documento = it.next();
            String id_repartidor = documento.getObjectId("_id").toString();
            String dni = documento.getString("dni");
            String nombre_repartidor = documento.getString("nombre_repartidor");
            String telefono_repartidor = documento.getString("telefono_repartidor");
            int antiguedad = documento.getInteger("antiguedad");
            String oficina = documento.getString("oficina");
            Boolean activo = documento.getBoolean("activo");
            
            repartidor = new Repartidor(id_repartidor, dni, nombre_repartidor, telefono_repartidor, antiguedad, oficina, activo);
            listaRepartidores.add(repartidor);
        }
        this.desconectar();
    }
    
    public void insertarRepartidor(String dni, String nombre_repartidor, String telefono_repartidor, int antiguedad, String oficina){
        Document documento = new Document()
                .append("dni", dni)
                .append("nombre_repartidor", nombre_repartidor)
                .append("telefono_repartidor", telefono_repartidor)
                .append("antiguedad", antiguedad)
                .append("oficina", oficina)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Repartidor").insertOne(documento);
        this.desconectar();
    }
    
    public void modificarRepartidor(String id_repartidor, String dni, String nombre_repartidor, String telefono_repartidor, int antiguedad, String oficina){
        ObjectId id = new ObjectId(id_repartidor);
        Document documento = new Document()
                .append("dni", dni)
                .append("nombre_repartidor", nombre_repartidor)
                .append("telefono_repartidor", telefono_repartidor)
                .append("antiguedad", antiguedad)
                .append("oficina", oficina)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Repartidor").replaceOne(new Document("_id", id), documento);
        this.desconectar();
    }
    
    public void eliminarRepartidor(String id_repartidor){
        ObjectId id = new ObjectId(id_repartidor);
        
        this.conectar();
        this.db.getCollection("Repartidor").updateOne(new Document("_id", id), 
                new Document("$set", new Document("activo", false)));
        this.desconectar();
    }

    public List<Repartidor> getListaRepartidores() {
        return listaRepartidores;
    }
    
}
