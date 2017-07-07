using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.LargestCommonEnd
{
    class LargestCommonEnd
    {
        static void Main(string[] args)
        {
            string[] arr1 = Console.ReadLine().Split(' ');
            string[] arr2 = Console.ReadLine().Split(' ');
            int longest = 0;
            int current = 0;

            for (int i = 0; i < arr1.Length - 1 && i < arr2.Length - 1; i++)
            {
                if (arr1[i] == arr2[i])
                    current++;
                if (current > longest)
                    longest = current;
            }
            int k = Math.Max(arr1.Length, arr2.Length) - 1;
            int l = Math.Min(arr1.Length, arr2.Length) - 1;
            current = 0;
            for (; l >= 0; l--, k--)
            {
                if (arr1.Length > arr2.Length)
                {
                    if (arr1[k] == arr2[l])
                        current++;
                }
                else
                {
                    if (arr1[l] == arr2[k])
                        current++;
                }
                if (current > longest)
                    longest = current;
            }
            Console.WriteLine(longest);
        }
    }
}
