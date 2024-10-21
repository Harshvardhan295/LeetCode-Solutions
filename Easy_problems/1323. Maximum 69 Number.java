//--------------------------- Method 1----------------------------
class Solution {
	public int maximum69Number (int num) {
		String str = Integer.toString(num);
		String ans="";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='6')
			{
				ans+='9';
				break;
			}
			ans+=str.charAt(i);
		}
		if(str.length()!=ans.length())
		{
			ans+=str.substring(ans.length());
		}
		return Integer.parseInt(ans);
	}
}
//_________________________Method 2______________________________
class Solution {
    public int maximum69Number (int num) {
        String str = Integer.toString(num);
        StringBuilder s = new StringBuilder(str);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '6'){
                s.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(s.toString());
    }
}
