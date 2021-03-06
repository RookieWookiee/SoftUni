﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.LargestSequenceOfIncr
{
    class LargestSequenceOfIncr
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            PrintLongestSequel(nums);
        }

        private static void PrintLongestSequel(int[] nums)
        {
            int longest = 1;
            int current = 1;
            int startIndex = -1;
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if (nums[i] < nums[i + 1])
                {
                    current++;
                    if (current > longest)
                    {
                        longest = current;
                        startIndex = i + 1 - longest;
                        if (startIndex < 0)
                            startIndex = 0;
                    }
                }
                else
                {
                    current = 1;
                }
            }
            if (startIndex >= 0)
            {
                for (int i = startIndex; i <= startIndex + longest; i++)
                {
                    Console.Write("{0} ", nums[i]);
                }
            }
        }
    }
}
