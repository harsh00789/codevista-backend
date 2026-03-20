package come.codevista.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Step {
    private final List<Integer> array;
    private final int i;
    private final int j;
    private final boolean isSwapped;
}
