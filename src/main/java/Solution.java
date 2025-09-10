import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import numberrangesummarizer.NumberRangeSummarizer;

public class Solution implements NumberRangeSummarizer{


    @Override
    public Collection<Integer> collect(String input){
        Collection<Integer> coll = new ArrayList<>();
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Input cannot be empty.");
            return coll;
        }

        String[] items = input.split(",");
        
        for (String str : items) {
            // check if the collection has numbers only, if a non-digit appears skip and check next elements
            try {
                coll.add(Integer.valueOf(str.trim()));
            }
            catch (NumberFormatException e) {
                System.out.println("The value \""+str+"\" was skipped because it's not a digit.");
            }
        }
        return coll;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input){
        StringBuilder output = new StringBuilder();

        if (input == null || input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return output.toString();
        }
        List<Integer> list = new ArrayList<>(input);

        Collections.sort(list);

        if (list.size() == 1) {
            output.append(list.get(0));
            return output.toString();
        }
        
        int start = list.get(0);
        int end = start;
        boolean isSeq = false;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == end + 1) {
                end = list.get(i);
                isSeq = true;
            }
            else{
                if (isSeq) {
                    output.append(start).append("-").append(", ");
                    isSeq = false;
                }
                else{output.append(start).append(", ");}
                start = end = list.get(i);
            }
        }
        if(isSeq){
            output.append(start).append("-").append(end);
        }
        else{
            output.append(start);
        }

        return output.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.summarizeCollection(sol.collect("1,3,6,7,8,12,13,15,21,22,23,24,31")));
    }

}