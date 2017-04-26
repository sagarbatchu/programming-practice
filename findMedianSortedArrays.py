class findMedianSortedArrays(object):
    def findMedianSortedArrays(self,nums1,nums2):
        m = len(nums1)
        n = len(nums2)

        if m > n:
            nums1, nums2, m, n = nums2, nums1, n, m

        if n == 0:
            raise ValueError
        
       #Once we have divided arrays into two parts (upper and lower)
       #we need the max(lower) + min(upper)

        i_min = 0
        i_max = m
        half_point = (m+n+1)/2

        while i_min <= i_max:

            #to satisfy the claim that i + j = m - i + n - j
            i = (i_min + i_max)/2
            j = half_point - i

            if i< m and nums2[j-1] > nums1[i]:
            #largest value in lower half of B is greater than smallest value in upper half of A
            #increase the value of imin to increase the value of i
                i_min = i + 1

            if i > 0 and nums2[j] < nums1[i-1] :
            #smallest value in upper half of b is greater than smallest value in lower half of A
            #decrease the value of imax to decrease the value of i
                i_max = i - 1

            else:
            # right values of imin and imax achieced

                #special cases
                # i == 0 or j == 0
                if i == 0:
                    max_left = nums2[j-1] # nums1[i-1] does not exist
                elif j == 0:
                    max_left = nums1[i-1]
                else:
                    max_left = max(nums1[i-1],nums2[j-1])

                if (m + n) % 2 == 1:
                    return max_left

                # i == m or j == n
                if i == m: min_right = nums2[j]
                elif j == n: min_right = nums1[i]
                else: min_right = min(nums1[i],nums2[j])


                return (max_left +  min_right) / 2.0
