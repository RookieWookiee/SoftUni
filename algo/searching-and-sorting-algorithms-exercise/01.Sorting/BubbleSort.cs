using System;

namespace Sorting
{
    class BubbleSort
    {
        public static void Sort<T>(T[] arr) where T : IComparable
        {
            for(int i = 0; i < arr.Length; i++) {
                for(int j = 0; j < arr.Length-1-i; j++) {
                    if (!Helper.IsLess(arr[j], arr[j + 1]))
                        Helper.Swap(arr, j, j + 1);
                }
            }
        }
    }
}
