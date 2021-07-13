class Solution {
    
    public boolean canFinish(int num, int[][] pre) {
        
        //we can even have hraph a List<int[]>, as numbers are from 0-n-1
        // and have faster get operation then map
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        int[] indegree = new int[num];
        
        // make adjecency list from metrics
        for(int i = 0; i< pre.length; i++){
            
            int[] edge = pre[i];
            
            List<Integer> edges =adjList.getOrDefault(edge[1], new ArrayList<>());
            edges.add(edge[0]);
            adjList.put(edge[1], edges);
            
            //populate indegree
            indegree[edge[0]]++;
        }
        
        //add all zero indegrgee node to Q
        for(int i = 0; i< indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            
            int curVertex = queue.poll();
            count++;
            
            List<Integer> edges = adjList.get(curVertex);
            
            // it is possible that, a course is the last node in graph and has 
            // no edges leading from it.
            if (edges == null) {
                continue;
            }
            
            for(int course: edges){
                
                indegree[course]--;
                
                if(indegree[course] == 0){
                    queue.add(course);
                }
            
            }
        }
        
        return count == num;
    }

}