using System;

namespace MergeSort
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int[] input = { 5, 4, 3, 2, 1 };
		}
	}

	public class Mergesort<T> where T : IComparable
	{
		private static T[] aux;

		public static void Sort(T[] arr)
		{
			aux = new T[arr.Length];
		}

		private static void Merge(T[] arr, int left, int mid, int right)
		{
			if (Helper<T>.IsLess (arr [mid], arr [mid + 1])) {
				return;
			}
			for (int idx = left; idx < right + 1; idx++) {
				aux [idx] = arr [idx];
			}

			int i = left;
			int j = mid + 1;
			for (int k = 0; k <= right; k++) {
			}
		}
	}
}
