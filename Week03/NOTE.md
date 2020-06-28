##第三周 算法和数据结构 学习总结

####主要包含两部分：泛型递归和树的递归

递归模板，树的有关问题，可以用递归求解，同时也可以利用遍历的方式求解： 


	// Java
	public void recur(int level, int param) { 
  	// terminator 
	  if (level > MAX_LEVEL) { 
    // process result 
    	return; 
	  }
	// process current logic 
		process(level, param); 
    // drill down 
    	recur( level: level + 1, newParam); 
    // restore current status 
      }
      
  
      
###回溯问题解法框架
#####根据 子集、排列I、排列II、和组合的题解，在国际站中找到了大体上的解法框架。其

仔细观察，回溯问题框架和是在泛型递归解法基础上针对边界条件和剪枝做了更细微的调整

子集：


	public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
    	Arrays.sort(nums);
    	backtrack(list, new ArrayList<>(), nums, 0);
    	return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, 		int [] nums, int start){
    	list.add(new ArrayList<>(tempList));
    	for(int i = start; i < nums.length; i++){
        	tempList.add(nums[i]);
        	backtrack(list, tempList, nums, i + 1);
        	tempList.remove(tempList.size() - 1);
    	}
	}	
排列：
	
	public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums); // not necessary
    backtrack(list, new ArrayList<>(), nums);
    return list;
		}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, 	int [] nums){
   		if(tempList.size() == nums.length){
      		list.add(new ArrayList<>(tempList));
    	} else{
      		for(int i = 0; i < nums.length; i++){ 
           if(tempList.contains(nums[i])) continue; // element already exists,skip
         		tempList.add(nums[i]);
         		backtrack(list, tempList, nums);
         		tempList.remove(tempList.size() - 1);
      		}
   	  	  }
		}
		
排列II的减枝条件要注意：

	public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}

组合:
		
	class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<>();
       helper(n, k, res,1, new ArrayList<>());
       return res;
    	}
    private void helper(int n, int k,List<List<Integer>> res,int start, 	List<Integer> path ) {
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



