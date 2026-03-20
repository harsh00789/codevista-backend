package come.codevista.controller;

import come.codevista.dsa.response.AlgorithmResponse;
import come.codevista.dsa.bubblesort.service.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sort")
public class SortController {
    private final BubbleSortService bubbleSortService;

    @Autowired
    public SortController(BubbleSortService bubbleSortService) {
        this.bubbleSortService = bubbleSortService;
    }

    @PostMapping("/bubble-sort")
    public AlgorithmResponse bubbleSort(@RequestBody List<Integer> array){
      return  bubbleSortService.getAlgorithmResponse(array);
    }
}
