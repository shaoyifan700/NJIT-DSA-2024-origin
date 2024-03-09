package oy.tol.tra;

/**
 * A simple array of student grades to be used in testing
 * misbehaving algorithm for reversing the array.
 */
public class Grades {
   
   private Integer [] grades = null;

   /**
    * A constructor for building IntArrays.
    * @param grades the plain Java integer array with numbers to add.
    */
    public Grades(Integer [] grades) {
      this.grades = new Integer [grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   /**
    * The method to reverse the internal Java int array.
    */

    public static void swap(Integer[] array, int index1, int index2){
      int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

   public void reverse() {
      /* TODO:
       1. Edit the test data files to see if the reverse() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java, as instructed in the readme file.
      */
      if(grades==null){
         return;
      }
      int i = 0;
      int j =  grades.length % 2 ;  //奇数,j = 1,偶数 j = 0
      if( j == 1 ) {
         while (i <= grades.length/2) {
            /* int temp = grades[i];
            grades[i] = grades[grades.length-i-1];
            grades[grades.length-i-1] = temp;*/
            swap( grades,  i,  grades.length-i-1);
            i++;

         }
     }
     if( j == 0 ) {
         while (i <= grades.length/2 - 1) {
            swap(grades,i,grades.length-i-1);
            i++;
         }
     }
   }

   /**
    * Sorts the array to ascending order.
    */
   public void sort() {
      /* TODO:
       1. Edit the test data files to see if the sort() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java as instructed in the readme file.
      */
      
      /*
         while (i > 0) {
            if (gardes[i] < grades[i-1]) {
               int tmp = grades[i];
               grades[i] = grades[i-1];
               grades[i-1] = tmp;
            }
            i--;
         }
         */
        /*int i = grades.length-1;
        for (int a = 0; a < i; a++) {
         // 找到未排序部分的最小元素的索引
         int minIndex = a;
         for (int j = a + 1; j <= i; j++) {
             if (grades[j] < grades[minIndex]) {
                 minIndex = j;
             }
         }

         // 把最小元素与当前位置交换
         swap(grades,minIndex,a);选择排序 ,以下是冒泡排序*/
         int n = grades.length;
         for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                  if (grades[j] > grades[j + 1]) {
                     // 交换 grades[j] 和 grades[j + 1]
                     
                     swap(grades,j,j+1);
                  }
               }
         }
        
        
     }
   

   /**
    * Returns the plain Java int [] array for investigation.
    * @return The int array.
    */
   public Integer [] getArray() {
      return grades;
   }
}
