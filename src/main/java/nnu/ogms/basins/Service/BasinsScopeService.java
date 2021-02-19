package nnu.ogms.basins.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import nnu.ogms.basins.Entity.BasinsScopeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class BasinsScopeService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public BasinsScopeService(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public Object queryScopeByLoc(double lon, double lat){
        try {
            double[] point = new double[]{lon, lat};

            DBObject queryCmd = new BasicDBObject();
            queryCmd.put("geometry", new BasicDBObject("$geoIntersects",
                    new BasicDBObject("$geometry",
                            new BasicDBObject("type", "Point")
                                    .append("coordinates", point))));
            Query query = new BasicQuery(queryCmd.toString());
            return mongoTemplate.findOne(query, BasinsScopeEntity.class);

        }catch (Exception e){
            return 0;
        }
    }
}
