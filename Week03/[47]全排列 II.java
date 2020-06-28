//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums, res , track);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> track) {
        // terminator condition
        if(track.size() == nums.length) {
            if (res.contains(track)) return;
            res.add(new ArrayList<>(track));
            return;
        }
        // choice in choices range
        for (int i = 0; i < nums.length; i++) {
            // do choice
            track.add(nums[i]);
            backtrack(nums, res, track);
            track.remove(track.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
