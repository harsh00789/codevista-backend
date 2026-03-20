package come.codevista.problem.MinBitWiseOr3858.service;

import come.codevista.problem.MinBitWiseOr3858.model.MinBitWiseOrSteps;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class MinBitWiseOr3858Service {

        public Map<String,Object> minimumOR(int[][] grid) {
            // final ans initialize
            int finalAns = 0;

           List<MinBitWiseOrSteps> steps = new ArrayList<>();

            for(int i=17;i>=0;i--){
                int permissionSlip = finalAns | ((1<<i)-1 );

                boolean bitForced = false;

                MinBitWiseOrSteps step = new MinBitWiseOrSteps();
                step.setBit(i);
                step.setPermissionSlip(permissionSlip);
                step.setBitForced(bitForced);
                step.setRows(new ArrayList<>());

                for(int[] row : grid){
                    boolean candidateFound = false;


                    List<Integer> validNumbers = new ArrayList<>();
                    for(int num : row){

                        if((num | permissionSlip) == permissionSlip){
                            candidateFound = true;
                            validNumbers.add(num);
                        }
                    }

                    MinBitWiseOrSteps.RowState rowState = new MinBitWiseOrSteps.RowState();
                    rowState.setNumbers(Arrays.stream(row).boxed().toList());
                    rowState.setValidNumbers(validNumbers);
                    rowState.setCandidateFound(candidateFound);
                    step.getRows().add(rowState);

                    if(!candidateFound){
                        // System.out.println(" candidate not found for ");
                        finalAns|=(1<<i);
                       bitForced = true;
                        break;
                    }
                }
                step.setBitForced(bitForced);
               steps.add(step);
            }


            return Map.of("finalAns",finalAns,"steps",steps);
        }
    }
