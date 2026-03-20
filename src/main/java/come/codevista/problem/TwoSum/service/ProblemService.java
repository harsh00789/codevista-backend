package come.codevista.problem.TwoSum.service;

import come.codevista.dsa.response.AlgorithmResponse;
import come.codevista.model.Step;
import come.codevista.problem.TwoSum.request.TwoSumRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProblemService {

    public List<Step> solveTwoSum(TwoSumRequest twoSumRequest){
        List<Step> steps = new ArrayList<>();
        List<Integer> nums = twoSumRequest.getNums();
        int target = twoSumRequest.getTarget();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            int second = target - nums.get(i);
            steps.add(new Step(new ArrayList<>(nums),i,-1,false));
            if(map.containsKey(second)){
                steps.add(new Step(new ArrayList<>(nums),i,map.get(second),true));
                break;
            }
            map.put(nums.get(i),i);
        }
        return steps;
    }

    public AlgorithmResponse getAlgorithmResponse(TwoSumRequest twoSumRequest){
List<Step> steps = solveTwoSum(twoSumRequest);
        String code = """
                 public int[] twoSum(int[] nums, int target) {
                         HashMap<Integer, Integer> map = new HashMap<>();
                
                         for (int i = 0; i < nums.length; i++) {
                             int complement = target - nums[i];
                
                             if (map.containsKey(complement)) {
                                 return new int[] { map.get(complement), i };
                             }
                
                             map.put(nums[i], i);
                         }
                
                         return new int[] {}; // fallback (problem guarantees a solution)
                     }
        """;

        String time = "O(n)";
        String space = "O(n)";
        String explanation = """
                Iterate through the array once.
                For each element num, calculate its complement: complement = target - num.
                Check if the complement already exists in the hash map.
                If yes, return the indices of the complement and the current number.
                If no, insert the current number and its index into the hash map and move to the next.
                """;
        return new AlgorithmResponse(steps,code,explanation,time,space);

    }
}
