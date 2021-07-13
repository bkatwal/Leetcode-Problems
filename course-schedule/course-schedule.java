class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // array that contain indegree of each course
        int[] indegrees = new int[numCourses];
        
        //build graph
        List<Integer>[] graph = buildGraph(indegrees, numCourses, prerequisites);
        
        // add all course that has indegree 0 to queue, they will be starting point
        Queue<Integer> q = new LinkedList<>();
        
        for(int j = 0; j < numCourses; j++){
            //System.out.println("in: " + in + " val: " + in)
            if(indegrees[j] == 0){
                q.offer(j);
            }
        }
        
        // number of courses processed in queue
        int processed = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            processed++;
            
            //get next course in path
            List<Integer> neighbor = graph[course];
            if(neighbor != null){
                    
                // decrease their indegrree by one
                for(int n: neighbor){
                    indegrees[n]--;
                    if(indegrees[n] == 0){
                        q.offer(n);
                    }
                }  
            }
        }
        
        return processed == numCourses;
    }
    
    public  List<Integer>[] buildGraph(int[] indegrees, int n, int[][] prerequisites){
         List[] graph = new ArrayList[n];
        
        for(int[] pair : prerequisites){
            
            if(graph[pair[1]] == null){
                graph[pair[1]] = new ArrayList<>();
            }
            
            List<Integer> neighbors = graph[pair[1]];
            
            neighbors.add(pair[0]);
            
            indegrees[pair[0]]++;
        }
        return graph;
    }
}