using System;

namespace DecreaseKey
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var queue = new PriorityQueue<TestNode<int>>();

			var testNode1 = new TestNode<int>() { Value = 6 };
			var testNode2 = new TestNode<int>() { Value = 3 };
			var testNode3 = new TestNode<int>() { Value = 4 };
			var testNode4 = new TestNode<int>() { Value = 2 };
			var testNode5 = new TestNode<int>() { Value = 8 };

			queue.Enqueue(testNode1);
			queue.Enqueue(testNode2);
			queue.Enqueue(testNode3);
			queue.Enqueue(testNode4);
			queue.Enqueue(testNode5);

			testNode5.Value = 1;
			queue.DecreaseKey(testNode5);

			Console.WriteLine("1 ? " + queue.Dequeue().Value);
			Console.WriteLine("2 ? " + queue.Dequeue().Value);

			testNode1.Value = 1;
			queue.DecreaseKey(testNode1);
			Console.WriteLine("1 ? " + queue.Dequeue().Value); 
		}
	}
	class TestNode<T> : IComparable<TestNode<T>> where T : IComparable<T>
	{
		public T Value { get; set; }

		public int CompareTo(TestNode<T> other)
		{
			return this.Value.CompareTo(other.Value);
		}
	}	
}
