
// 关键：确保 import 的是 jupiter.api
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 针对 Solution11 (threeSum) 的测试类
 * 学号: [此处填写你的学号]
 */
public class L2023111498_11_Test { // <-- 确保这个类名和你的文件名一致

    // 实例化你要测试的类 (Solution11.java 里的类名是 Solution)
    private final Solution s = new Solution();

    /*
     * ================================================================
     * 测试用例设计总体原则... (省略注释)
     * ================================================================
     */

    /**
     * 辅助方法：对结果列表进行标准化排序
     */
    private String normalize(List<List<Integer>> lists) {
        List<String> strList = new ArrayList<>();
        if (lists == null) {
            return "[]";
        }
        for (List<Integer> list : lists) {
            Collections.sort(list); // 内部排序
            strList.add(list.toString());
        }
        Collections.sort(strList); // 外部排序
        return strList.toString();
    }

    /**
     * 辅助方法：用于比较期望结果和实际结果
     */
    private void assertResultEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        String expectedStr = normalize(expected);
        String actualStr = normalize(actual);
        // 关键：这里是 assertEquals (来自 jupiter)，不是 Assert.assertEquals (来自 junit 4)
        assertEquals(expectedStr, actualStr, "测试未通过");
    }

    // --- 开始逐个测试用例 ---
    // 关键：这里的 @Test 是 org.junit.jupiter.api.Test

    @Test
    public void testStandardCase_MultipleSolutions() {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> actual = s.threeSum(nums);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1));
        assertResultEquals(expected, actual);
    }

    @Test
    public void testAllZeros() {
        int[] nums = { 0, 0, 0 };
        List<List<Integer>> actual = s.threeSum(nums);
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(0, 0, 0));
        assertResultEquals(expected, actual);
    }

    @Test
    public void testNoSolution() {
        assertResultEquals(Collections.emptyList(), s.threeSum(new int[] { 1, 2, 3 }));
        assertResultEquals(Collections.emptyList(), s.threeSum(new int[] { 0, 1, 1 }));
    }

    @Test
    public void testBoundary_ExactlyThreeElements() {
        int[] nums = { -1, 0, 1 };
        List<List<Integer>> actual = s.threeSum(nums);
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(-1, 0, 1));
        assertResultEquals(expected, actual);
    }

    @Test
    public void testBoundary_LengthLessThan3() {
        int[] nums = { 1, 2 };
        List<List<Integer>> actual = s.threeSum(nums);
        assertResultEquals(Collections.emptyList(), actual);
    }

    @Test
    public void testRobustness_NullInput() {
        int[] nums = null;
        List<List<Integer>> actual = s.threeSum(nums);
        assertResultEquals(Collections.emptyList(), actual);
    }

    @Test
    public void testDeduplication() {
        int[] nums = { -2, 0, 0, 2, 2 };
        List<List<Integer>> actual = s.threeSum(nums);
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(-2, 0, 2));
        assertResultEquals(expected, actual);
    }
}