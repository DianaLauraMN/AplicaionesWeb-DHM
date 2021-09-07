/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import businessObjects.Normal;
import businessObjects.User;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Date;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author Hector Zapata
 */
public class Testing {

    public static void main(String[] args) {
        String SERVIDOR = "mongodb://localhost";
        String BASEDATOS = "AplicacionesWeb-DHM";

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        ConnectionString cadenaConexion = new ConnectionString(SERVIDOR);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion).codecRegistry(codecRegistry).build();
        com.mongodb.client.MongoClient servidorBD = MongoClients.create(clientSettings);
        MongoDatabase baseDatos = servidorBD.getDatabase(BASEDATOS);


    }
}
