### 第四周学习总结


第四周内容主要涵盖 广度优先和深度优先遍历、贪心算法、和二分查找


主要的学习心得是广度优先和深度优先的模板要记住。 深度优先使用递归的形式、而广度优先搜索使用队列的数据结构。

BFS主要用于层序遍历和最短路径的场景下。

二叉树层序代码模板：

	void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
       }
	  }
	  
深度优先遍历 的例子可以参考岛屿问题，形式上上市递归。https://leetcode-cn.com/problems/number-of-islands/

贪心算法，原则是是局部最优解， 适用场景比如跳跃问题。 找零钱、跳跃游戏

二分查找，前提是数组要有序，或者有序的变形，比如旋转数组问题。时间复杂度Log(n)

