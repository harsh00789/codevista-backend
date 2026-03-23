package come.codevista.problem.MaxProductPath1594.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaxProductPathSteps {
    private final String step;
    private final int i;
    private final int j;
    public long downMin;
    public long downMax;
    public long upMin;
    public long upMax;

    public long dpMin;
    public long dpMax;

    public MaxProductPathSteps(String step,int i,int j,long dpMin,long dpMax){
        this.step = step;
        this.i = i;
        this.j = j;
        this.dpMin = dpMin;
        this.dpMax = dpMax;
    }

}
