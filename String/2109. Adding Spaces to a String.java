class Solution {
    public String addSpaces(String s, int[] spaces) {
//------------>Lalit's code<------------
       StringBuilder res = new StringBuilder(s);
       int spaceCount = 0;
       for(int space : spaces){
           res.insert(space  + spaceCount , " ");
           spaceCount++;
       }
       return res.toString();
    }
}

     // m-2
       StringBuilder res = new StringBuilder();
       int spaceIdx = 0;
       int n = s.length();
       int m = spaces.length;
       for(int i = 0; i < n; i++){
           if(spaceIdx < m && spaces[spaceIdx] == i){
            res.append(" ");
            spaceIdx++;
           }
           res.append(s.charAt(i));
       }
       return res.toString();
       
    }
}

//--------->Manmeet's code<------------
   
    int i = 0, j = 0, indx = 0;
    StringBuilder ans = new StringBuilder();
    while(j != spaces.length) {
        indx = spaces[j];
        ans.append(s,i, indx);
        ans.append(" ");
        i = indx; 
        j++;
    }
    ans.append(s, i, s.length());
    
    return ans.toString();
    }
}


