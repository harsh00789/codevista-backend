package come.codevista.design.urlshortner.service;

import come.codevista.design.urlshortner.model.DesignResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShornerDesignService {

    public DesignResponse getDesign() {

        DesignResponse.Node n1 = new DesignResponse.Node("1", "Client");
        DesignResponse.Node n2 = new DesignResponse.Node("2", "Load Balancer");
        DesignResponse.Node n3 = new DesignResponse.Node("3", "API Server");
        DesignResponse.Node n4 = new DesignResponse.Node("4", "APP Service");
        DesignResponse.Node n5 = new DesignResponse.Node("5", "Cache (Redis)");
        DesignResponse.Node n6 = new DesignResponse.Node("6", "Database");
        DesignResponse.Node n7 = new DesignResponse.Node("7", "ID Generator");


        DesignResponse.Edge e1 = new DesignResponse.Edge("1", "2");
        DesignResponse.Edge e2 = new DesignResponse.Edge("2", "3");
        DesignResponse.Edge e3 = new DesignResponse.Edge("3", "4");
        DesignResponse.Edge e4 = new DesignResponse.Edge("4", "5");
        DesignResponse.Edge e5 = new DesignResponse.Edge("4", "6");
        DesignResponse.Edge e6 = new DesignResponse.Edge("4", "7");

        String title = "URL Shortener";
        String description = "A system that converts long URLs into short unique URLs and redirects users efficiently.";

        List<String> steps = List.of(
                "User sends long URL to server",
                "Server generates unique short ID",
                "Mapping stored in database",
                "Short URL returned to user",
                "On access, system checks cache first",
                "If not found, fetch from DB and redirect"
        );

        List<String> tradeOffs = List.of(
                "Cache improves speed but adds complexity",
                "DB scaling required for large traffic",
                "ID generation must be unique and fast"
        );

        List<String> complexities = List.of(
                "Read latency: O(1) with cache",
                "Write latency: O(1)",
                "Scales horizontally with load balancer"
        );

        DesignResponse designResponse = new DesignResponse(List.of(n1, n2, n3,n4,n5,n6,n7), List.of(e1, e2,e3,e4,e5,e6),
        title,description,steps,tradeOffs,complexities);
return designResponse;
    }
}
