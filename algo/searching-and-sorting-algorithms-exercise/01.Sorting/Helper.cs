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
        
        public static bool IsLessOrEqual<T> (T first, T than)
            where T : IComparable
        {
            return first.CompareTo(than) != 1;
        }

        public static void Swap<T>(T[] arr, int firstDex, int secondDex)
            where T : IComparable
        {
            T temp = arr[firstDex];
            arr[firstDex] = arr[secondDex];
            arr[secondDex] = temp;
        }
        
        public static void FancySwap(int[] arr, int firstDex, int secondDex)
        {
            arr[firstDex] = arr[firstDex] + arr[secondDex];
            arr[secondDex] = arr[firstDex] - arr[secondDex];
            arr[firstDex] = arr[firstDex] - arr[secondDex];
        }

        public static void FanciestSwap(int[] arr, int firstDex, int secondDex)
        {
            arr[firstDex] = arr[firstDex] ^ arr[secondDex];
            arr[secondDex] = arr[firstDex] ^ arr[secondDex];
            arr[firstDex] = arr[firstDex] ^ arr[secondDex];
        }
	}
}