<h2><a href="https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1">Subarrays with sum K</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number <strong>k</strong>.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>k = -10,<strong> </strong>arr = [10, 2, -2, -20, 10]
<strong>Output:</strong> 3
<strong>Explaination:</strong>  Subarrays: arr[0...3], arr[1...4], arr[3..4] have sum exactly equal to -10.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>k = 33, arr = [9, 4, 20, 3, 10, 5]
<strong>Output:</strong> 2
<strong>Explaination:</strong>  Subarrays : arr[0...2], arr[2...4] have sum exactly equal to 33.<br></span></pre>
<pre><strong>Input: </strong>k = 1, arr = [1]
<strong>Output:</strong> 1
<strong>Explaination: </strong>Since the required sum is 1 and the array also has a single element equal to 1, hence there is only one subarray.</pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤ arr.size() ≤ 2*10<sup>4</sup><br>-10<sup>3</sup> ≤ arr[i] ≤ 10<sup>3</sup><br>-10<sup>7</sup>&nbsp;≤ k&nbsp;≤ 10<sup>7</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Hash</code>&nbsp;<code>Data Structures</code>&nbsp;