using System;

public static class Heap<T> where T : IComparable<T>
{
    public static void Sort(T[] arr)
    {
        for(int i = arr.Length / 2; i >= 0; i--) {
            HeapifyDown(arr, i, arr.Length);
        }
        
        Console.WriteLine(string.Join(" ", arr));

        for(int i = arr.Length - 1; i > 0; i--) {
            Swap(arr, 0, i);
            HeapifyDown(arr, 0, i);
        }
    }

    private static void HeapifyDown(T[] arr, int index, int length)
    {
        while(index < length / 2) {
            int child = index * 2 + 1;
            if(child + 1 < length && IsGreater(arr, child + 1, child))
                child++;
            if(IsGreater(arr, index, child))
                break;
            Swap(arr, index, child);
            index = child;
        }
    }

    private static bool IsGreater(T[] arr, int indexA, int indexB)
    {
        return arr[indexA].CompareTo(arr[indexB]) > 0;
    }

    private static void Swap(T[] arr, int indexA, int indexB)
    {
        T temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
