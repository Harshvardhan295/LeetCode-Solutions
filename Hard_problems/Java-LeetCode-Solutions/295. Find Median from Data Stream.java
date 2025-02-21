//Brute Force Method
class MedianFinder {
List<Integer> arr=new ArrayList<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        arr.add(num);
    }

    public double findMedian() {
    Collections.sort(arr);
    int n=arr.size();
    if(n%2!=0) return arr.get(n/2); //odd length
    else return (arr.get(n/2)+ arr.get(n/2-1))/2.0;
    }
}

//With swapping
class MedianFinder {
List<Integer> arr=new ArrayList<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        arr.add(num);
        int i=arr.size()-1;
        while(i>0){
            if(arr.get(i)<arr.get(i-1)){
                swap(i,i-1);
                i--;
            }
            else break;
        }
    }
    public void swap(int i,int j){
        int temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,arr.get(temp));
    }
    public double findMedian() {
    int n=arr.size();
    if(n%2!=0) return arr.get(n/2); //odd length
    else return (arr.get(n/2)+ arr.get(n/2-1))/2.0;
    }
}
