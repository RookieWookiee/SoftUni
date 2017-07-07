using System;

namespace Sorting
{
	class MainClass
	{
		public static void Main (string[] args)
		{

			int[] input = { 5, 4, 3, 2, 1 };
			int[] copy = new int[input.Length];

			input.CopyTo (copy, 0);
			InsertionSort.Sort (copy, copy.Length-1);
			Console.WriteLine ("Insertion Sort: " + Helper.IsSorted(copy));

			input.CopyTo (copy, 0);
			MergeSort<int>.Sort (copy);
			Console.WriteLine ("Merge Sort: " + Helper.IsSorted (copy));
			Console.WriteLine (string.Join(", ", copy));
		}
	}
}
