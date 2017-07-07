using System;

namespace Sorting
{
	public class InsertionSort
	{
		public static void Sort<T> (T[] arr, int end) 
			where T : IComparable
		{
			if (end >= 1) {
				Sort (arr, end - 1);
				T x = arr [end];
				int j = end - 1;
				while (j >= 0 && IsLess(x, arr[j])) {
					arr [j + 1] = arr[j];
					j = j - 1;
				}
				arr [j+1] = x;
			}
		}
		public static bool IsLess<T>(T first, T than)
			where T : IComparable
		{
			return first.CompareTo (than) < 0;
		}
	}
}

