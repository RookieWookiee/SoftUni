using System;

namespace Factorial
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int n = int.Parse (Console.ReadLine ());
			Console.WriteLine (Factorial (n));
		}
		public static long Factorial(int n)
		{
			if (n <= 1)
				return 1;
			else
				return n * Factorial (n - 1);
		}
	}
}
