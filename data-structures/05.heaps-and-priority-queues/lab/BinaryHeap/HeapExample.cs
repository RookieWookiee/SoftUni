using System;

public class HeapExample
{
    static void Main()
    {
        var arr = new int[] { -5, -2, -1, -6, -8 };

        Heap<int>.Sort(arr);

        Console.WriteLine(string.Join(" ", arr));
    }
}
