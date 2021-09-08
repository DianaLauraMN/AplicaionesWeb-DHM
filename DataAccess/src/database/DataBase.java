package database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Hector Zapata
 */
public enum DataBase {
       INSTACE;
    String SERVER = "mongodb://localhost";
    String DATABASE = "AplicacionesWeb-DHM";

    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    ConnectionString stringConnection = new ConnectionString(SERVER);
    MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(stringConnection).codecRegistry(codecRegistry).build();
    com.mongodb.client.MongoClient serverDB = MongoClients.create(clientSettings);
    MongoDatabase dataBase = serverDB.getDatabase(DATABASE);

    public MongoDatabase getConnection() {
        return this.dataBase;
    }
}
