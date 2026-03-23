package come.codevista.controller;

import come.codevista.dsa.response.AlgorithmResponse;
import come.codevista.problem.MaxProductPath1594.service.MaxProductPath1594Service;
import come.codevista.problem.MinBitWiseOr3858.service.MinBitWiseOr3858Service;
import come.codevista.problem.TwoSum.request.TwoSumRequest;
import come.codevista.problem.TwoSum.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    private final ProblemService problemService;
    private final MinBitWiseOr3858Service minBitWiseOr3858Service;
    private final MaxProductPath1594Service maxProductPath1594Service;

    @Autowired
    public ProblemController(ProblemService problemService, MinBitWiseOr3858Service minBitWiseOr3858Service, MaxProductPath1594Service maxProductPath1594Service) {
        this.problemService = problemService;
        this.minBitWiseOr3858Service = minBitWiseOr3858Service;
        this.maxProductPath1594Service = maxProductPath1594Service;
    }

    @PostMapping("/two-sum")
    public AlgorithmResponse solveTwoSum(@RequestBody TwoSumRequest twoSumRequest) {
        return problemService.getAlgorithmResponse(twoSumRequest);
    }

    @PostMapping("/minimum-or/3858")
    public Map<String,Object> minimumOr(@RequestBody int[][] grid) {
        return minBitWiseOr3858Service.minimumOR(grid);
    }

    @PostMapping("/max-product-path/1594")
    public Map<String,Object> maximumProductPath(@RequestBody int[][] grid) {
        return maxProductPath1594Service.maxProductPath(grid);
    }
}
