package come.codevista.dsa.bubblesort.service;

import come.codevista.dsa.response.AlgorithmResponse;
import come.codevista.model.Step;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BubbleSortService {

    public List<Step> generateSteps(List<Integer> array) {

        List<Step> steps = new ArrayList<>();
        List<Integer> a = new ArrayList<>(array);
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.size()-i-1;j++){
                steps.add(new Step(new ArrayList<>(a),j,j+1,false));
                if(a.get(j)>a.get(j+1)){
                    Collections.swap(a, j, j+1);
                    steps.add(new Step(new ArrayList<>(a),j,j+1,true));
                }

            }
        }

        return steps;
    }


    public AlgorithmResponse getAlgorithmResponse(List<Integer> array) {
        List<Step> steps = generateSteps(array);
        String code = """
        public void bubbleSort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        """;
        return new AlgorithmResponse(steps, code, "Bubble Sort is a simple comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.", "O(n^2)", "O(1)");
    }
}
