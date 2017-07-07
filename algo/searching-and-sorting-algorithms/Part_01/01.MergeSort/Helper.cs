using System;

namespace MergeSort
{
	public static class Helper<T> where T : IComparable
	{
		public static bool IsLess(T first, T second)
		{
			return first.CompareTo (second) == -1;
/* this is a changr */
		}
	}
}

