package come.codevista.dsa.response;

import come.codevista.model.Step;
import lombok.Data;

import java.util.List;

@Data
public class AlgorithmResponse {
    private final List<Step> steps;
    private final String code;
    private final String explanation;
    private final String timeComplexity;
    private final String spaceComplexity;
}
