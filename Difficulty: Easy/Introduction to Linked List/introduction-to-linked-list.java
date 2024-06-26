//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            Node ans = obj.constructLL(a);
            while (ans != null) {
                System.out.print(ans.data + " ");
                ans = ans.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 
*/
class Solution {
    static Node constructLL(int arr[]) {
        // code here
        Node head = new Node();
        head.data = arr[0];
        int len = arr.length;
        Node mvr = head;
        for(int i=1;i<len;i++){
            Node temp = new Node();
            temp.data = arr[i];
            mvr.next = temp;
            mvr = temp;
        }
        return head;
    }
}
