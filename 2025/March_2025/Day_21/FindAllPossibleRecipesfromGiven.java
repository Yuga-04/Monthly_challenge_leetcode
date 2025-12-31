// Question : https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        HashSet<String>set=new HashSet<>();
        List<String>ans=new ArrayList<>();
        for(String s:supplies)
        {
            set.add(s);
        }
        boolean flag=true;
        while(flag)
        {
            flag=false;
                for(int i=0;i<recipes.length;i++)
                {
                    if(!set.contains(recipes[i]))
                    {
                        int x=0;
                        for(int j=0;j<ingredients.get(i).size();j++)
                        {
                            if(!set.contains(ingredients.get(i).get(j)))
                            {
                                x=1;
                                break;
                            }
                        } 
                        if(x==0)
                        {
                            flag=true;
                            set.add(recipes[i]);
                            ans.add(recipes[i]);
                        }
                           
                    }
                }

        }
        return ans;
    }
}
