using System;

namespace Sorting
{
	public class Helper
	{
		public static bool IsSorted<T>(T[] arr)
			where T : IComparable
		{
			for (int i = 0; i < arr.Length - 1; i++) {
				if (!IsLess(arr [i], arr [i + 1]))
					return false;
			}
			return true;
		}

		public static bool IsLess<T>(T first, T than) 
			where T : IComparable 
		{	
			return first.CompareTo (than) < 0;
		}
	}
}

