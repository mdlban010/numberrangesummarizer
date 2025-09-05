
import java.util.ArrayList;
import java.util.Collection;
import numberrangesummarizer.NumberRangeSummarizer;

public class Solution implements NumberRangeSummarizer{
    public Collection<Integer> collect(String input){
        String[] items = input.split(",");
        Collection<Integer> coll = new ArrayList<>();
        for (String str : items) {
            try {
                coll.add(Integer.parseInt(str));
            }
            catch (Exception e) {
                System.err.println("Invalid Input. Please make sure you entered correct input.");
            }
        }
        return coll;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input){
        return "Hello";
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
    }

}