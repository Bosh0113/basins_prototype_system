package nnu.ogms.basins.Controller;

import nnu.ogms.basins.Service.BasinsScopeService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequestMapping("/basins")
public class BasinsScopeController {
    @Resource
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/queryScope",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public Object queryScope(@RequestParam("lon") double lon, @RequestParam("lat") double lat){
        BasinsScopeService scopeService = new BasinsScopeService(mongoTemplate);
        return scopeService.queryScopeByLoc(lon, lat);
    }
}
