//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, res,1, new ArrayList<>());
        return res;
    }
    private void helper(int n, int k,List<List<Integer>> res,int start, List<Integer> path ) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start;i <= n- (k - path.size()) + 1; i++) {
            path.add(i);
            helper(n, k, res, i + 1, path);
            path.remove(path.size()-1);

        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
