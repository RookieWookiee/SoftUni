using System;
using System.Linq;

namespace NestedLoops
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int n = int.Parse (Console.ReadLine ());
			int[] arr = new int[n];
			Loop (arr, 0);

		}
		public static void Loop(int[] arr, int index)
		{
			if (index == arr.Length) {
				Print (arr);
				return;
			}
			for (int i = 1; i <= arr.Length; i++) {
				arr [index] = i;	
				Loop (arr, index +1);
			}
		}
		public static void Print(int[] arr)
		{
			Console.WriteLine (string.Join(" ", arr));
		}
	}
}
