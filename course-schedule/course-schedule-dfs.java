class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        
        List[] graph = buildGraph(numCourses, prerequisites);
        
        boolean[] done = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
                if(!done[i] && hasCycle(i, graph, new boolean[numCourses], done)){ 
                    return false;
            }
         }

        return true;
    }

    public boolean hasCycle(int start, List[]  graph, boolean[] visited, boolean[] done){
        
        if(visited[start]){
            return true;
        }
        
        visited[start] = true;
        done[start] = true;
        
        List<Integer> edges = graph[start];
        if(edges != null){
            for(int edge : edges){
                if(hasCycle(edge, graph, visited, done)){
                    return true;
                }
            }
        }
        visited[start] = false;
        return false;
    }
    
    public List[] buildGraph(int n, int[][] prerequisites){
        List[] graph = new List[n];
        for(int[] pre: prerequisites){
             if(graph[pre[1]] == null){
                 graph[pre[1]] = new ArrayList<>();
                    
             }
                
             graph[pre[1]].add(pre[0]);
        }
        return graph;
     }
}
