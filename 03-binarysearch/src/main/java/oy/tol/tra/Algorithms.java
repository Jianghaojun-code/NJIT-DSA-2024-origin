package oy.tol.tra;

public class Algorithms {
    public static void main(String[] args) {
       
        
    }
   
    public static <T extends Comparable<T>> void sort(T [] array) {
       
        for(int i=1; i<array.length;i++){
           for(int j=0;j<array.length-1;j++){
              if(array[j].compareTo(array[j+1])>0){
                 T temp =array[j];
                 array[j]=array[j+1];
                 array[j+1]=temp;
  
              }
           }
        }
     }
     public static <T extends Comparable<T>> void reverse(T[] array) {
        int length = array.length;
        for(int i = 0; i < length/2; i++){
            T temp = array[i];
            array[i] = array[length-1-i];
            array[length-1-i] = temp;
        }
    }
   
   public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
      int middle;
      while(fromIndex<=toIndex){
          middle=fromIndex+(toIndex-fromIndex)/2;
          if(aValue.compareTo(fromArray[middle])>0){
              fromIndex=middle+1;
          }else if(aValue.compareTo(fromArray[middle])<0){
              toIndex=middle-1;
          }else{
              return middle;
          }
      }
      return -1;
  }
  private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
   E pivot = array[end];
   int i = begin - 1;

   for (int j = begin; j < end; j++) {
       if (array[j].compareTo(pivot) <= 0) {
           i++;
           E temp = array[i];
           array[i] = array[j];
           array[j] = temp;
       }
   }
   E temp = array[i + 1];
   array[i + 1] = array[end];
   array[end] = temp;

   return i + 1;
}

         public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(array, begin, end);
                quickSort(array, begin, partitionIndex - 1);
                quickSort(array, partitionIndex + 1, end);
            }
        }
    
        public static <E extends Comparable<E>> void fastSort(E[] array) {
         quickSort(array, 0, array.length - 1);
     }
        

        
}
    

