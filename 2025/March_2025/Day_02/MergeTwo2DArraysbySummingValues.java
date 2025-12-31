//Question : https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/

class Solution 
{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) 
    {
        // Step 1: Initialize variables
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        // Step 2: Merge the arrays
        while (i < nums1.length && j < nums2.length) 
        {
            int[] temp = new int[2];
            
            if (nums1[i][0] == nums2[j][0]) 
            {
                temp[0] = nums1[i][0];
                temp[1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } 
            else if (nums1[i][0] < nums2[j][0]) 
            {
                temp[0] = nums1[i][0];
                temp[1] = nums1[i][1];
                i++;
            } 
            else 
            {
                temp[0] = nums2[j][0];
                temp[1] = nums2[j][1];
                j++;
            }

            result.add(temp);
        }

        // Step 3: Add remaining elements from nums1
        while (i < nums1.length) 
        {
            int[] temp = nums1[i++];
            result.add(temp);
        }

        // Step 4: Add remaining elements from nums2
        while (j < nums2.length) 
        {
            int[] temp = nums2[j++];
            result.add(temp);
        }

        // Step 5: Convert result to 2D array and return
        int[][] tuples = new int[result.size()][2];
        for (i = 0; i < tuples.length; i++) 
        {
            tuples[i] = result.get(i);
        }

        return tuples;
    }
}
