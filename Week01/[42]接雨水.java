//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针
//第一种方法：暴力求解，
// 第二种   类似于矩形最大面积问题。用栈的技术




//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int trap(int[] height) {
//        int result = 0 ;
//        for ( int i = 1; i < height.length-1; i++){
//            int leftmax = 0 , rightmax = 0;
//            for (int j = i; j >= 1; j--){
//                leftmax = Math.max(height[j], leftmax);
//            }
//            for (int j = i; j <= height.length-1;j++){
//                rightmax = Math.max(height[j],rightmax);
//
//            }
//            result += Math.min(rightmax,leftmax)-height[i];
//
//        }
//        return result;
//
//    }
//}
class Solution {
    public int trap(int[] height) {
        int result = 0,current = 0;
        int i = 0 ;
        Stack<Integer> stack = new Stack<Integer>();
        while ( i < height.length){
            if (stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i++);
            }
            else {
                int top = stack.pop();
                current = stack.isEmpty()? 0 :(Math.min(height[stack.peek()],height[i])-height[top])*(i-stack.peek()-1);
                result += current ;
            }
        }
        return result;

    }
}

//leetcode submit region end(Prohibit modification and deletion)
