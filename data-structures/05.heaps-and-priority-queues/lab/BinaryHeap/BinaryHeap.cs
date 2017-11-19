using System;
using System.Collections.Generic;

public class BinaryHeap<T> where T : IComparable<T>
{
    private List<T> heap;

    public BinaryHeap()
    {
        heap = new List<T>();
    }

    public int Count
    {
        get { return this.heap.Count; }
    }

    public void Insert(T item)
    {
        heap.Add(item);
        HeapifyUp(Count - 1);
    }

    public T Peek()
    {
        if(Count == 0)
            throw new InvalidOperationException();
        return heap[0];
    }

    public T Pull()
    {
        if(Count == 0)
            throw new InvalidOperationException();
        T max = heap[0];
        Swap(0, Count - 1);
		heap.RemoveAt(Count - 1);
        HeapifyDown(0);

        return max;
    }

    private void HeapifyDown(int index)
    {
        while(index < Count / 2) {
            int child = index * 2 + 1;
            if(child + 1 < Count && IsGreater(child + 1, child))
                child++;
            if(IsGreater(index, child))
                break;
            Swap(index, child);
            index = child;
        }
    }

    private void HeapifyUp(int index)
    {
        while(index > 0) {
            int parent = (index - 1) / 2;
			if(IsGreater(parent, index))
                break;
            Swap(index, parent);
            index = parent;
        }
    }

    private bool IsGreater(int indexA, int indexB)
    {
        return heap[indexA].CompareTo(heap[indexB]) > 0;
    }

    private void Swap(int indexA, int indexB)
    {
        T temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }
}
