using System;

namespace Sorting
{
    class QuickSort
    {
        public static void Sort<T>(T[] arr)
            where T : IComparable
        {
            if (Helper.IsSorted(arr))
                return;
            Sort(arr, 0, arr.Length - 1);
        }

        private static void Sort<T>(T[] arr, int left, int right)
            where T : IComparable
        {
            if (left >= right)
                return;

            int p = Partition(arr, left, right);
            Sort(arr, left, p - 1);
            Sort(arr, p + 1, right);
        }

        private static int Partition<T>(T[] arr, int left, int right)
            where T : IComparable
        {
            if (left >= right)
                return left;

            int i = left;
            int j = right + 1;
            while(true)
            {
                while (Helper.IsLess(arr[++i], arr[left]))
                    if (i == right) break;
                while (Helper.IsLess(arr[left], arr[--j]))
                    if (j == left) break;

                if (i >= j) break;
                Helper.Swap(arr, i, j);
            }

            Helper.Swap(arr, left, j);
            return j;
        }
    }
}
