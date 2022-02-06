package mensajeria.controlador;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Álvaro
 */
public class Conexion {

    public MongoClient mongoClient;
    public MongoDatabase db;

    
    public void conectar(){
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("mensajeria");
    }
    
    public void desconectar(){
        mongoClient.close();
    }
    
}
