package come.codevista.problem.TwoSum.request;

import lombok.Data;

import java.util.List;

@Data
public class TwoSumRequest {
   private final List<Integer> nums;
   private final int target;
}
