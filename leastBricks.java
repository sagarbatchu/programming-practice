public class leastBricks {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer,Integer> brickHash = new HashMap<>();

        for(List<Integer> row : wall){
            int rowCount = 0;
            for(Integer brick: row){
                rowCount += brick;
                int count = brickHash.containsKey(rowCount) ? brickHash.get(rowCount) : 0;
                brickHash.put(rowCount, count+=1);
            }
        }

       int numRows = wall.size();
       int crossedCount = wall.size();
       for(Integer key : brickHash.keySet()){
            crossedCount = Math.min(crossedCount, numRows - brickHash.get(key));
       }
       return crossedCount;
    }
}
