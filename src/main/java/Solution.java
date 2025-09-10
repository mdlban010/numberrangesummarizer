import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
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

        if (input == null || input.isEmpty()) return "";

        // Remove duplicates and sort
        TreeSet<Integer> sortedSet = new TreeSet<>(input);
        List<Integer> numbers = new ArrayList<>(sortedSet);

        StringBuilder sb = new StringBuilder();
        
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.summarizeCollection(sol.collect("1,3,6,7,8,12,13,15,21,22,23,24,31")));
    }

}