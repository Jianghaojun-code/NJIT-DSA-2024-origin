package oy.tol.tra;

public class Algorithms {
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
   }


   
