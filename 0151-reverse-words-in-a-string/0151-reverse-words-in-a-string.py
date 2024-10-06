class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        st = ""
        x = list(s.split())
        print(x[0])
        
        for i in range(len(x)):
            st = x[i]+" " + st 
          
        return st[:-1];    
        