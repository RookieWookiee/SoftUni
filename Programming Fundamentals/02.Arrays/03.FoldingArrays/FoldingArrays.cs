using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Linq;

namespace _03.FoldingArrays
{
    class FoldingArrays
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int foldLen = nums.Length / 4;
            int[][] folds = new int[2][];
            folds[0] = new int[2 * foldLen];
            folds[1] = new int[2 * foldLen];
            Fold(folds, nums, foldLen);
            int[] result = CalcSumArray(folds[0], folds[1]);
            string print = result.ToString();
            Console.WriteLine(result.ToString());
        }

        private static int[][] Fold(int[][] arr, int[] mainArr, int foldSize)
        {
            int[] half = new int[foldSize];
            for (int i = 0; i < foldSize; i++)
            {
                arr[0][i] = mainArr[i];
            }
            arr[0] = arr[0].Reverse().ToArray();
            for(int start = 3 * foldSize - 1, i = foldSize - 1; start < 4 * foldSize && i < half.Length; start++, i++)
            {
                half[i] = mainArr[start];
            }
            half = half.Reverse().ToArray();
            Array.FindIndex(arr[0], x => x > 0);//bug
            arr[0] = arr[0].Concat(half).ToArray();

            for (int i = 2 * foldSize - 1; i < 3 * foldSize; i++)
            {
                arr[1][i] = mainArr[i];
            }
            return arr;
        }

        private static int[] CalcSumArray(int[] arr1, int[] arr2)
        {
            int[] sum =  new int[arr1.Length];
            for(int i = 0; i < arr1.Length; i++)
            {
                sum[i] = arr1[i] + arr2[i]; 
            }
            return sum;
        }
    }
}
