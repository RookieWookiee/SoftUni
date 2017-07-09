using System;

namespace Sorting
{
	class MainClass
	{
		public static void Main (string[] args)
		{
            //int[] input = { 5, 4, 3, 2, 1, 0, -1, -2, -3, -4};
            int[] input = { 57, 60, -23, 3, 15, 0, 11 };

            RunAlgo("Bubble Sort", BubbleSort.Sort, input);
            RunAlgo("Recursive Insertion Sort", InsertionSort.Sort, input);
            RunAlgo("Recursive Merge Sort", MergeSort<int>.Sort, input);
            RunAlgo("Iterative Merge Sort", IterativeMergeSort.Sort, input);
            RunAlgo("Recursive Quick Sort", QuickSort.Sort, input);
		}

        private static void RunAlgo<T>(string algoName, Action<T[]> Sort, T[] input) where T : IComparable
        {
            T[] copy = new T[input.Length];
            input.CopyTo(copy, 0);
            Sort(copy);
            Console.WriteLine(string.Format("{0,-25} \t {1}", algoName + ":", Helper.IsSorted(copy)));
        }
    }
}
