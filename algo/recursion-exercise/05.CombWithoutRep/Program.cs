using System; using System.Collections.Generic;
using System.Linq;

namespace CombWithRepetition
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int n = int.Parse (Console.ReadLine ());
			int k = int.Parse (Console.ReadLine ());
			int[] arr = new int[k];
			GenCombinations (arr, 0, 1, n);
		}

		public static void GenCombinations (int[] arr, int index, int start, int n)
		{
			if (index == arr.Length) {
				Console.WriteLine (String.Join (" ", arr));
				return;
			}	

			for (int i = start; i <= n; i++) {	
				arr [index] = i;
				GenCombinations (arr, index + 1, start + 1, n);
				start++;
			}
		}
	}
}
