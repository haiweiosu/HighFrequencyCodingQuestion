public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int area = 0; 
        int right = height.length - 1;
        while (left <= right){
            area = Math.max(area, computeArea(left, right, height));
            if (height[left] <= height[right]) {
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
    private int computeArea(int left, int right, int[] height) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}