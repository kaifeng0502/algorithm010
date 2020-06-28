//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        recursionHelper(nums, output, res);
        return res;

    }
    private void recursionHelper(int[] nums, List<Integer> output, List<List<Integer>> res) {
        if(output.size() == nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(output.contains(nums[i])) continue;
            output.add(nums[i]);
            recursionHelper(nums, output, res);
            output.remove(output.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
