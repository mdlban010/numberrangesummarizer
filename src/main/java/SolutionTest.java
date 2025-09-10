import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution s = new Solution();

    // ---------- collect() tests ----------

    @Test
    @DisplayName("collect: null input -> empty collection")
    void collect_nullInput() {
        Collection<Integer> result = s.collect(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("collect: blank input -> empty collection")
    void collect_blankInput() {
        Collection<Integer> result = s.collect("   ");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("collect: trims tokens and keeps order of valid integers")
    void collect_trimsAndKeepsOrder() {
        Collection<Integer> result = s.collect(" 1 ,  2,   3 ");
        assertIterableEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    @DisplayName("collect: skips invalid tokens (letters, empty tokens)")
    void collect_skipsInvalidTokens() {
        Collection<Integer> result = s.collect("1, Mike, , 2, , x, 3");
        assertIterableEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    @DisplayName("collect: allows negatives and duplicates")
    void collect_negativesAndDuplicates() {
        Collection<Integer> result = s.collect("-2, -1, -1, 0, 1, 1, 2");
        assertIterableEquals(Arrays.asList(-2, -1, -1, 0, 1, 1, 2), result);
    }

    // ---------- summarizeCollection() tests ----------

    @Test
    @DisplayName("summarizeCollection: empty collection -> empty string")
    void summarize_emptyCollection() {
        String out = s.summarizeCollection(Collections.emptyList());
        assertEquals("", out);
    }

    @Test
    @DisplayName("summarizeCollection: single element")
    void summarize_singleElement() {
        String out = s.summarizeCollection(Collections.singletonList(42));
        assertEquals("42", out);
    }

    @Test
    @DisplayName("summarizeCollection: non-consecutive numbers emit individually")
    void summarize_nonConsecutive() {
        Collection<Integer> coll = s.collect("1,3,5");
        String out = s.summarizeCollection(coll);
        assertEquals("1, 3, 5", out);
    }

    @Test
    @DisplayName("summarizeCollection: merges consecutive ranges")
    void summarize_consecutiveRange() {
        Collection<Integer> coll = s.collect("1,2,3,4,5");
        String out = s.summarizeCollection(coll);
        assertEquals("1-5", out);
    }

    @Test
    @DisplayName("summarizeCollection: handles duplicates after sort")
    void summarize_handlesDuplicates() {
        Collection<Integer> coll = s.collect("1,2,2,3");
        String out = s.summarizeCollection(coll);
        assertEquals("1-3", out);
    }

    @Test
    @DisplayName("summarizeCollection: ignores duplicates scattered in input")
    void summarize_ignoresScatteredDuplicates() {
        Collection<Integer> coll = s.collect("1,1,1,7,8,12,13,Mike,15,21,22,23,Mike,10000000");
        String out = s.summarizeCollection(coll);
        assertEquals("1, 7-8, 12-13, 15, 21-23, 10000000", out);
    }

    @Test
    @DisplayName("summarizeCollection: unsorted input is sorted before summarizing")
    void summarize_unsortedInput() {
        Collection<Integer> coll = s.collect("3,2,2,1");
        String out = s.summarizeCollection(coll);
        assertEquals("1-3", out);
    }

    @Test
    @DisplayName("summarizeCollection: negative numbers spanning a range")
    void summarize_negativeRange() {
        Collection<Integer> coll = s.collect("-2,-1,0,1,2");
        String out = s.summarizeCollection(coll);
        // Entire run from -2 to 2 should be one range
        assertEquals("-2-2", out);
    }

    @Test
    @DisplayName("summarizeCollection: large integers close to Integer.MAX_VALUE")
    void summarize_largeIntegers() {
        Collection<Integer> coll = s.collect("2147483646,2147483647");
        String out = s.summarizeCollection(coll);
        assertEquals("2147483646-2147483647", out);
    }

    @Test
    @DisplayName("summarizeCollection: accepts non-List collections (e.g., Set) without ClassCastException")
    void summarize_fromSetInput() {
        Set<Integer> set = new HashSet<>(Arrays.asList(21, 23, 22, 23, 24));
        String out = s.summarizeCollection(set);
        assertEquals("21-24", out);
    }

    @Test
    @DisplayName("summarizeCollection: mixed isolated and ranged values")
    void summarize_mixed() {
        Collection<Integer> coll = s.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String out = s.summarizeCollection(coll);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", out);
    }
}


