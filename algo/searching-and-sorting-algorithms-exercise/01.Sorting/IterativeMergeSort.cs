using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sorting
{
    class IterativeMergeSort
    {
        public static void Sort<T>(T[] arr) where T : IComparable
        {

            // For current size of subarrays to be merged
            // currSize varies from 1 to length/2
            for (int currSize = 1; currSize <= arr.Length - 1; currSize *= 2)
            {
                // For picking starting index of left subarray
                // to be merged
                for (int leftStart = 0; leftStart < arr.Length - 1; leftStart += 2 * currSize)
                {
                    int mid = Math.Min(leftStart + currSize - 1, arr.Length - 1);
                    int rightEnd = Math.Min(leftStart + 2 * currSize - 1, arr.Length - 1);
                    Merge(arr, leftStart, mid, rightEnd);
                }
            }
        }

        private static void Merge<T>(T[] arr, int leftStart, int mid, int rightEnd) where T : IComparable
        {
            int leftCount   = mid - leftStart + 1,
                rightCount  = rightEnd - mid,
                rightStart  = mid + 1,
                leftEnd     = mid;

            T[] leftSubArr = new T[leftCount];
            T[] rightSubArr = new T[rightCount];

            for (int m = 0; m < leftCount; m++)
                leftSubArr[m] = arr[leftStart + m];
            for (int n = 0; n < rightCount; n++)
                rightSubArr[n] = arr[rightStart + n];

            int i = 0,
                j = 0,
                k = leftStart;

            while(i < leftCount && j < rightCount)
            {
                if (Helper.IsLessOrEqual(leftSubArr[i], rightSubArr[j]))
                {
                    arr[k] = leftSubArr[i++];
                }
                else
                {
                    arr[k] = rightSubArr[j++];
                }
                k++;
            }

            // Copy the remaining elements if there are any
            while(i < leftCount)
            {
                arr[k++] = leftSubArr[i++];
            }
            // Same as above
            while(j < rightCount)
            {
                arr[k++] = rightSubArr[j++];
            }
        }
    }
}
