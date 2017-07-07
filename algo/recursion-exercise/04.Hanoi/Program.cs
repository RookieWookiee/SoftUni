using System;
using System.Linq;
using System.Collections.Generic;

namespace Hanoi
{
	class MainClass
	{
		private static int stepsTaken = 0;
		private static Stack<int> source;
		private static readonly Stack<int> destination = new Stack<int> ();
		private static readonly Stack<int> spare = new Stack<int> ();

		public static void Main (string[] args)
		{
			int n = int.Parse(Console.ReadLine());
			source = new Stack<int> (Enumerable.Range (1, n).Reverse ());
			PrintRods ();
			MoveDisk (n, source, destination, spare);
		}

		private static void MoveDisk(int bottomDisk, Stack<int> source, Stack<int> dest, Stack<int> spare)
		{
			if (bottomDisk == 1) {
				stepsTaken++;
				dest.Push (source.Pop ());
				Console.WriteLine ($"Step #{stepsTaken}: Moved disk");
				PrintRods ();
			} else {
				MoveDisk (bottomDisk - 1, source, spare, dest);
				dest.Push (source.Pop ());
				stepsTaken++;
				Console.WriteLine ($"Step #{stepsTaken}: Moved disk");
				PrintRods ();
				MoveDisk (bottomDisk - 1, spare, dest, source);
			}
		}

		private static void PrintRods()
		{
			Console.WriteLine ("Source: {0}", String.Join(", ", source.Reverse()));
			Console.WriteLine ("Destination: {0}", String.Join(", ", destination.Reverse()));
			Console.WriteLine ("Spare: {0}", String.Join(", ", spare.Reverse()));
			Console.WriteLine ();
		}
	}
}
