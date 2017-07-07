using System;

namespace RecursiveDrawing
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int n = int.Parse (Console.ReadLine ());
			Print (n);
		}
		public static void Print(int n)
		{
			if (n <= 0)
				return;
			else {
				Console.WriteLine (new String ('*', n));
				Print (n - 1);
				Console.WriteLine (new String ('#', n));
			}
		}
	}
}
