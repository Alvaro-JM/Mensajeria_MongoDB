package mensajeria.controlador;

import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mensajeria.modelo.Paquete;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Álvaro
 */
public class PaqueteControlador extends Conexion{
    
    private List<Paquete> listaPaquetes;

    public PaqueteControlador(){
        listaPaquetes = new ArrayList<>();
        leerPaquete();
    }
    
    private void leerPaquete(){
        this.conectar();
        FindIterable findIterable = this.db.getCollection("Paquete").find();
        
        Paquete paquete = null;
        Iterator<Document> it = findIterable.iterator();
        while (it.hasNext()) {
            Document documento = it.next();
            String id_paquete = documento.getObjectId("_id").toString();
            Date fecha_entrega = documento.getDate("fecha_entrega");
            String direccion_destino = documento.getString("direccion_destino");
            String telefono_destino = documento.getString("telefono_destino");
            String direccion_origen = documento.getString("direccion_origen");
            String telefono_origen = documento.getString("telefono_origen");
            String repartidor = documento.getString("repartidor");
            Boolean activo = documento.getBoolean("activo");
            
            paquete = new Paquete(id_paquete, fecha_entrega, direccion_destino, telefono_destino, direccion_origen, telefono_origen, repartidor, activo);
            listaPaquetes.add(paquete);
        }
        this.desconectar();
    }
    
    public void insertarPaquete(Date fecha_entrega, String direccion_destino, 
            String telefono_destino, String direccion_origen, String telefono_origen, String repartidor){
        
        Document documento = new Document()
                .append("fecha_entrega", fecha_entrega)
                .append("direccion_destino", direccion_destino)
                .append("telefono_destino", telefono_destino)
                .append("direccion_origen", direccion_origen)
                .append("telefono_origen", telefono_origen)
                .append("repartidor", repartidor)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Paquete").insertOne(documento);
        this.desconectar();
    }
    
    public void modificarPaquete(String id_paquete, Date fecha_entrega, String direccion_destino,
            String telefono_destino, String direccion_origen, String telefono_origen, String repartidor){
        
        ObjectId id = new ObjectId(id_paquete);
        Document documento = new Document()
                .append("fecha_entrega", fecha_entrega)
                .append("direccion_destino", direccion_destino)
                .append("telefono_destino", telefono_destino)
                .append("direccion_origen", direccion_origen)
                .append("telefono_origen", telefono_origen)
                .append("repartidor", repartidor)
                .append("activo", true);
        
        this.conectar();
        this.db.getCollection("Paquete").replaceOne(new Document("_id", id), documento);
        this.desconectar();
    }
    
    public void eliminarPaquete(String id_paquete){
        ObjectId id = new ObjectId(id_paquete);
        
        this.conectar();
        this.db.getCollection("Paquete").updateOne(new Document("_id", id), 
                new Document("$set", new Document("activo", false)));
        this.desconectar();
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }
    
}
