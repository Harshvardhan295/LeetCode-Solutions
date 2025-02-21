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
//Heaps
class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxheap.size() == 0) maxheap.add(num);
        else {
            if (num < maxheap.peek()) maxheap.add(num);
            else minheap.add(num);
        }
        if(maxheap.size()-minheap.size()>1) { //balance heaps
            minheap.add(maxheap.remove());
        } else if (minheap.size()-maxheap.size()>1) {
            maxheap.add(minheap.remove());
        }
    }
    public double findMedian() {
        if(minheap.size()==maxheap.size()) {
            return (maxheap.peek()+minheap.peek())/2.0;
        } else if (maxheap.size()>minheap.size()) {
            return maxheap.peek();
        }
        else return minheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
