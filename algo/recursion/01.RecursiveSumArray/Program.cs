using System;
using System.Linq;

namespace RecursiveSumArray
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int[] arr = Console.ReadLine ().Split (' ').Select (int.Parse).ToArray ();
			int res = Sum (arr, 0);
			Console.WriteLine (res);
		}
		public static int Sum(int[] arr, int index)
		{
			if (index == arr.Length - 1)
				return arr [index];
			else
				return arr [index] + Sum (arr, index + 1);
		}
	}
}
