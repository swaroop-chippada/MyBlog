package mypage.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Component
public class DataStoreTemplate {

	private Datastore dataStore;

	public DataStoreTemplate() {
		Morphia morphia = new Morphia();
		String dbName = "myproject";
		String host;
		if (!StringUtils.isEmpty(System.getenv("MONGODB_URI"))) {
			host = System.getenv("MONGODB_URI");
		} else {
			host = "mongodb://localhost";
		}

		MongoClient mongoClient = new MongoClient(new MongoClientURI(host));

		dataStore = morphia.createDatastore(mongoClient, dbName);
		morphia.mapPackage("mypage.domain");
		dataStore.ensureIndexes();
	}

	public Datastore getDataStore() {
		return dataStore;
	}

}
