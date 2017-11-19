using System;
using System.Collections.Generic;

public class AStar
{
    private char[,] map;
    private Dictionary<Node, Node> parents;
    private Dictionary<Node, int> costs;

    public AStar(char[,] map)
    {
        this.map = map;
        parents = new Dictionary<Node, Node>();
        costs = new Dictionary<Node, int>();
    }

    public static int GetH(Node current, Node goal)
    {
        int deltaX = Math.Abs(current.Col - goal.Col);
        int deltaY = Math.Abs(current.Row - goal.Row);

        return deltaX + deltaY;
    }

    public IEnumerable<Node> GetPath(Node start, Node goal)
    {
        var pq = new PriorityQueue<Node>();

        pq.Enqueue(start);
        parents[start] = null;
        costs[start] = 0;

        while(pq.Count > 0) {
            Node current = pq.Dequeue();
            if(current == goal) break;
            var neighbours = GetNeighbours(current);
            foreach(var neighbour in neighbours) {
                int newCost = costs[current] + 1;
                if(!costs.ContainsKey(neighbour) || newCost < costs[neighbour]) {
                    costs[neighbour] = newCost;
                    neighbour.F = newCost + GetH(neighbour, goal);
                    pq.Enqueue(neighbour);
                    parents[neighbour] = current;
                }
            }
        }

        var currentNode = goal;
        var path = new List<Node>();

        if(!parents.ContainsKey(goal)) {
            path.Add(start);
            return path;
        }

        while(currentNode != null) {
            path.Add(currentNode);
            currentNode = parents[currentNode];
        }

        path.Reverse();
        return path;
    }

    private IEnumerable<Node> GetNeighbours(Node node)
    {
        List<Node> neighbours = new List<Node>();

        int row = node.Row,
            col = node.Col;

        if(InBounds(row + 1, col) && IsNotWall(row + 1, col))
            neighbours.Add(new Node(row + 1, col));
        if(InBounds(row - 1, col) && IsNotWall(row - 1, col))
            neighbours.Add(new Node(row - 1, col));
        if(InBounds(row, col + 1) && IsNotWall(row, col + 1))
            neighbours.Add(new Node(row, col + 1));
        if(InBounds(row, col - 1) && IsNotWall(row, col - 1))
            neighbours.Add(new Node(row, col - 1));
        
        return neighbours;
    }

    private bool IsNotWall(int row, int col)
    {
        return map[row, col] != 'W';
    }

    private bool InBounds(int row, int col) 
    {
        return row >= 0 && row < map.GetLength(0) && col >= 0 && col < map.GetLength(1);
    }
}

