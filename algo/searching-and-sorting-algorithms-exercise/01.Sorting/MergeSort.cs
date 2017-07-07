using System;

namespace Sorting
{
	public class MergeSort<T> where T : IComparable
	{
		private static T[] aux;

		public static void Sort(T[] arr)
		{
			aux = new T[arr.Length];
			Sort (arr, 0, arr.Length - 1);
		}

		public static void Sort(T[] arr, int left, int right)
		{
			if (left >= right)
				return;

			int mid = left + (right - left) / 2;

			Sort (arr, left, mid);
			Sort (arr, mid + 1, right);
			Merge (arr, left, mid, right);
		}

		private static void Merge(T[] arr, int left, int mid, int right)
		{
			if(Helper.IsLess(arr[mid], arr[mid+1]))
				return;

			arr.CopyTo (aux, 0);

			int i = left;
			int j = mid + 1;
			for (int k = left; k <= right; k++) {
				if (i > mid) {
					arr [k] = aux [j++];
				} else if (j > right) {
					arr [k] = aux [i++];
				} else if (Helper.IsLess (aux [i], aux [j])) {
					arr [k] = aux [i++];
				} else {
					arr [k] = aux [j++];
				}
			}
		}
	}
}

