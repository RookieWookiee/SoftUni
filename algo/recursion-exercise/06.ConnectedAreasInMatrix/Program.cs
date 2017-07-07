using System;
using System.Collections;

namespace ConnectedAreasInMatrix
{
	class MainClass
	{
		private static char WALL = '*';
		private static char EMPTY = '-';
		private static char VISITED = 'v';

		public static void Main (string[] args)
		{
			int row_size = int.Parse (Console.ReadLine ());
			int col_size = int.Parse (Console.ReadLine ());
			int[,] matrix = new int[row_size,col_size];

			for (int i = 0; i < row_size; i++) {
				for (int j = 0; j < col_size; j++) {
					matrix [i, j] = Console.Read ();
				}
			}
		}

		private static int FindFirstNonVisitedCell(int[,] matrix)
		{
			throw new NotImplementedException ();
		}
	}

	class Area : IComparable
	{
		public int size;
		public int start_row;
		public int start_col;

		public Area (int row, int col)
		{
			this.size = 1;	
			this.start_row = row;
			this.start_col = col;
		}

		public int CompareTo(Object obj) {
			if (obj == null)
				throw new NullReferenceException ();
			Area other = obj as Area;
			if (other.size != this.size)
				return this.size > other.size;
			else {
				if (other.start_row == this.start_row) {
					if (other.start_col == this.start_col) {
						return 0;
					} else
						return this.start_col > other.start_col;
				} else
					return this.start_row > this.start_col;
			}
		}
	}
}
