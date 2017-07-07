using System;

namespace GenerateVectors
{
	class MainClass
	{

		public static void Main (string[] args)
		{
			int n = int.Parse (Console.ReadLine ());
			int[] arr = new int[n];
			GenVectors (arr, 0, n);
		}
		public static void GenVectors(int[] arr, int index, int n)
		{
			if (index == n) 
				Print (arr);
			else {
				for (int i = 0; i < 2; i++) {
					arr [index] = i;
					GenVectors (arr, index + 1, arr.Length);
				}
			}
		}
		public static void Print(int[] arr) 
		{
			Console.WriteLine (String.Join("", arr));
		}
	}
}
