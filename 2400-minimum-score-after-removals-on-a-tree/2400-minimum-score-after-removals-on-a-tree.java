class Solution {
    private void dfs(int node, int parent, int[] nums, List<List<Integer>> graph,int[] subtreeXOR, List<HashSet<Integer>> desc){
        subtreeXOR[node] = nums[node];
        desc.get(node).add(node);

        for(int neigh: graph.get(node)){
            if(neigh != parent){
                dfs(neigh, node, nums, graph, subtreeXOR, desc);
                subtreeXOR[node] ^= subtreeXOR[neigh];
                desc.get(node).addAll(desc.get(neigh));
            }
        }
    }
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] subtreeXOR = new int[n];
        List<HashSet<Integer>> descendants = new ArrayList<>();
        for(int i = 0; i<n; i++)
            descendants.add(new HashSet<>());

        dfs(0, -1, nums, graph, subtreeXOR, descendants);

        int totalXOR = subtreeXOR[0];
        int minScore = Integer.MAX_VALUE;

        for(int i = 1; i<n; i++){
            for(int j = i+1; j<n; j++){
                int xorI = subtreeXOR[i];
                int xorJ = subtreeXOR[j];
                int val1, val2, val3;

                if(descendants.get(i).contains(j)){
                    val1 = xorJ;
                    val2 = xorI ^ xorJ;
                    val3 = totalXOR ^ xorI;
                }
                else if(descendants.get(j).contains(i)){
                    val1 = xorI;
                    val2 = xorJ ^ xorI;
                    val3 = totalXOR ^ xorJ;
                }
                else{
                    val1 = xorI;
                    val2 = xorJ;
                    val3 = totalXOR ^ xorI ^ xorJ;
                }

                int minVal = Math.min(val1, Math.min(val2, val3));
                int maxVal = Math.max(val1, Math.max(val2, val3));
                minScore = Math.min(minScore, maxVal - minVal);
            }
        }
        return minScore;
    }
}