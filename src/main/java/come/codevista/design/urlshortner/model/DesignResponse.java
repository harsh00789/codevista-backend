package come.codevista.design.urlshortner.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DesignResponse {

    private final List<Node> nodes;
    private final List<Edge> edges;
    private final String title;
    private final String description;
    private final List<String> steps;
    private final List<String> tradeOffs;
    public List<String> complexities;

   @Data
    public static class Node{
        private final String id;
        private final String label;
    }

    @Data
    @AllArgsConstructor
    public static class Edge{
        private String source;
        private String target;
        private String label;

       public Edge(String source,String target){
            this.source = source;
            this.target = target;
        }
    }
}
