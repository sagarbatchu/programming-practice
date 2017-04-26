public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        Set<String> stringBank = new HashSet<>();
        for(String string: bank){
            stringBank.add(string);
        }

        char[] chars = new char[]{'A','C','G','T'};
        int edits = 0;

        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int queueLength = queue.size();
            while(queueLength-1 > 0) {
                String current = queue.poll();
                if(current.equals(end)) return edits;

                char[] currentChars = current.toCharArray();
                for(int i = 0; i < currentChars.length; i++) {
                    char originalChar = currentChars[i];
                    for(char c: chars) {
                        currentChars[i] = c;
                        String editString = currentChars.toString();
                        if(!visited.contains(editString) && stringBank.contains(editString)) {
                            queue.offer(editString);
                            visited.add(editString);
                        }
                     }
                     currentChars[i] = originalChar;
                }
            }
            edits++;
        }
        return -1;
    }
}
