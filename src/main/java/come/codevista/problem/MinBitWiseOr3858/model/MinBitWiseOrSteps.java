package come.codevista.problem.MinBitWiseOr3858.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinBitWiseOrSteps {
    private int bit;
    private int permissionSlip;
    private boolean bitForced;
    private List<RowState> rows;

    @Data
    @NoArgsConstructor
    public static class RowState{
        private List<Integer> numbers;
        private List<Integer> validNumbers;
        private boolean candidateFound;
    }
}
