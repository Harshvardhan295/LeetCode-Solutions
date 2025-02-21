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
