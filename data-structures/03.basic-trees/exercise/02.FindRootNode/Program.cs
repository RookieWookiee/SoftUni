using System;
using System.Collections.Generic;
using System.Linq;


namespace FindRootNode
{
	class MainClass
	{
        private static Dictionary<int, Tree<int>> nodesByValue = new Dictionary<int, Tree<int>>();

		public static void Main ()
		{
            ReadTree();
            var root = FindRoot();
            Console.WriteLine($"Root node: {root.Value}");
		}

        private static Tree<int> GetTreeNodeByValue(int value)
        {
            if(!nodesByValue.ContainsKey(value)) {
                nodesByValue[value] = new Tree<int>(value);
            }

            return nodesByValue[value];
        }

        public static void AddEdge(int parent, int child)
        {
            Tree<int> parentNode = GetTreeNodeByValue(parent);
            Tree<int> childNode = GetTreeNodeByValue(child);

            parentNode.Children.Add(childNode);
            childNode.Parent = parentNode;
        }

        static void ReadTree() 
        {
            int nodeCount = int.Parse(Console.ReadLine());

            for (int i = 1; i < nodeCount; i++) {
                string[] edge = Console.ReadLine().Split(' ');
                AddEdge(int.Parse(edge[0]), int.Parse(edge[1]));
            }
        }

        static Tree<int> FindRoot()
        {
            return nodesByValue.Values.FirstOrDefault(x => x.Parent == null);
        }
	}

    public class Tree<T>
    {
        public T Value { get; set; }

        public Tree<T> Parent { get; set; }

        public List<Tree<T>> Children { get; private set; }

        public Tree(T value, params Tree<T>[] children)
        {
            this.Value = value;
            this.Children = new List<Tree<T>>();

            foreach (var child in children) {
                Children.Add(child);
                child.Parent = this;
            }
        }
    }
}
