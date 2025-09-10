class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        // step 1 : her user ki langauge ko set me dal de
        List<Set<Integer>>langSet = new ArrayList<>();

        for(int i = 0; i<m; i++){

            Set<Integer>set = new HashSet<>();
            for(int lang : languages[i]){
                set.add(lang);
            }
            langSet.add(set);
        }

        // step 2 : aise user jinke friendship me koi common lang nhi hai
        
        Set<Integer>badUser = new HashSet<>();
         for(int [] f : friendships){
            int u = f[0]-1; // 1 bases idx to 0th based idx
            int v = f[1]-1;

            Set<Integer>s1 = langSet.get(u);
            Set<Integer>s2 = langSet.get(v);

            // check intersection
            boolean canCommunicate = false;
            for(int l : s1){
                if(s2.contains(l)){
                  canCommunicate = true;
                  break;
                }
            
            }

            if(!canCommunicate){
                badUser.add(u);
                badUser.add(v);
            }

         }
         // sbi user communicate kar sakte hai
         if(badUser.isEmpty()) return 0;

         int minTeach = Integer.MAX_VALUE;

         for(int lang = 1; lang <= n; lang++){
             int alreadyknow = 0;
            for(int u : badUser){
                if(langSet.get(u).contains(lang)){ // badUser ki lang lang ke equal hai 
                    alreadyknow++;
                }
               
            }
             int needToTeach = badUser.size() - alreadyknow; // 2 bad user tha  1 alreadyknow to 1 ko learn
             minTeach = Math.min(minTeach, needToTeach);
         }
         return minTeach;
        
    }
}