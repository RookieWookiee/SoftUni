using System;
using System.Linq;

namespace _05.CompareChars
{
    class CompareChars
    {
        static void Main(string[] args)
        {
            char[] arr1 = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
            char[] arr2 = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
            
            switch(Compare(arr1,arr2))
            {
                case 1:
                    Print(arr2);
                    Print(arr1);
                    break;
                case 2:
                    Print(arr1);
                    Print(arr2);
                    break;
                default:
                    Print(arr1);
                    Print(arr2);
                    break;
            }
        }

        private static void Print(char[] arr1)
        {
            for (int i = 0; i < arr1.Length; i++)
            {
                Console.Write("{0}", arr1[i]);
            }
            Console.WriteLine();
        }

        static int Compare(char[] arr1, char[] arr2)
        {
            bool bigger1st = false, bigger2nd = false;
            for (int i = 0; i < Math.Min(arr1.Length,arr2.Length); i++)
            {
                if (arr1[i] > arr2[i])
                    bigger1st = true;
                else if (arr1[i] < arr2[i])
                    bigger2nd = true;
            }
            if (!bigger1st && !bigger2nd && arr1.Length == arr2.Length)
                return 0;
            else if (bigger1st)
                return 1;
            else if (bigger2nd)
                return 2;
            else if (!bigger1st && !bigger2nd && arr1.Length > arr2.Length)
                return 1;
            else if (!bigger1st && !bigger2nd && arr1.Length < arr2.Length)
                return 2;
            return -1;
        }
    }
}
