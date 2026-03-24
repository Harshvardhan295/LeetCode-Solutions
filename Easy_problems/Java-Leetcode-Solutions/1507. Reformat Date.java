class Solution {
    public String reformatDate(String date) {
        String ans = "";
        String[] words = date.split(" ");
        ans += words[2];
        ans += "-";
        System.out.println(words[1]);

        switch (words[1]) {
            case "Jan":
                ans += "01-";
                break;
            case "Feb":
                ans += "02-";
                break;
            case "Mar":
                ans += "03-";
                break;
            case "Apr":
                ans += "04-";
                break;
            case "May":
                ans += "05-";
                break;
            case "Jun":
                ans += "06-";
                break;
            case "Jul":
                ans += "07-";
                break;
            case "Aug":
                ans += "08-";
                break;
            case "Sep":
                ans += "09-";
                break;
            case "Oct":
                ans += "10-";
                break;
            case "Nov":
                ans += "11-";
                break;
            case "Dec":
                ans += "12-";
                break;
            default:
                /* handle error if needed */ break;
        }
        String a= words[0];
        a=a.substring(0,a.length()-2);
        if(a.length()==1){
            ans+="0";
            ans+=a;
            return ans;
        }
        ans+=a;
        return ans;
    }
}
