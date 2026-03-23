package come.codevista.problem.MaxProductPath1594.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Explanation {
    private List<String> story;
    private List<String> explanation;
    private String code;
    private String timeComplexity;
    private String spaceComplexity;
}
