using System;
using System.Linq;

namespace ReverseArray
{
	class MainClass
	{

		public static void Main (string[] args)
		{
			int[] arr = Console.ReadLine ().Split (' ').Select (int.Parse).ToArray ();
			int[] reversed = new int[arr.Length];
			ReverseArr (arr, reversed, 0);
		}
		public static void ReverseArr(int[] arr, int[] rev, int index)
		{
			if (index > arr.Length - 1) {
				Print (rev);
				return;
			}
			rev [index] = arr [arr.Length - index - 1];
			ReverseArr (arr, rev, index+1);
		}

		public static void Print(int[] arr)
		{
			Console.WriteLine (string.Join (" ", arr));
		}
	}
}
