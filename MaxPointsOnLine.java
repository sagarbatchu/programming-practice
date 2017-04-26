/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {

        int maxCount = 0;
        if(points.length <=0) return 0;
        if(points.length <=2 ) return points.length;

        for(int i=0;i<points.length;i++){

            HashMap<Double,Integer> slopeMap = new HashMap<Double, Integer>();
            int duplicates = 0;
            int infiniteSlope =1;
            slopeMap.put(Double.MAX_VALUE,1);

            for(int j=i+1; j<points.length;j++) {

                //check if it is the same point
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicates++;
                }

                //check for infinite slope
                else if(points[i].x == points[j].x && points[i].y != points[j].y) {
                    slopeMap.put(Double.MAX_VALUE,slopeMap.get(Double.MAX_VALUE) +1);
                }

                //all other arbitrary slopes
                else {
                    double slope = (points[i].y-points[j].y)/ (points[i].x-points[j].x);
                    if(!slopeMap.containsKey(slope)){
                        slopeMap.put(slope,2);
                    }
                    else {
                        slopeMap.put(slope, slopeMap.get(slope) + 1);
                    }
                }
            }

            int pointMax = 0;
            for(Double slope: slopeMap.keySet()) {
                pointMax = Math.max(pointMax, slopeMap.get(slope));
            }
            pointMax+=duplicates;
            maxCount = Math.max(maxCount, pointMax);

        }
        return maxCount;
    }
}
