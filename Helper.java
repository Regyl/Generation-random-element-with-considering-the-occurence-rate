/** Theme: Generation random element with considering the weight
 *
 * Write a class, which constructor will be get two arrays: array of values
 * and array of weights values above.
 * Class must contains method, which will be return an element of the first array
 * with considering its weight in the second array.
 *
 * Example:
 * We have first array [1,2,3] and second [1,2,10].
 * Averagely we shall return value *1* less frequently than *2* for 2 times and
 * less frequently than *3* for 10 times.
 */

import java.util.Scanner;
public class Helper{
    public static void main (String[] args){
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,20,2};
        Helper first = new Helper(arr1,arr2);
        for(int i=0; i<10; i++) {
            int temp = first.Randomizer();
            System.out.print(temp+" ");
        }
    }
    private int[] value;
    private int[] weight;
    Helper(int[] value, int[] weight){
        quickSort(weight,0,weight.length-1,value);
        this.value=value;
        this.weight=weight;
    }
    public int Randomizer(){
        int totalLength=0,temp;
        for(int i=0; i<weight.length; i++)
            totalLength+=weight[i];
        temp=(int)(Math.random()*(totalLength+1)); //random digit within [1,totalLength]
        totalLength=0; //redefinition for use in another algorithm
        for(int i=0; i<weight.length; i++) {
            totalLength+=weight[i];
            if (temp<=totalLength) {return value[i];}
            else {continue;}
        }
        return value[value.length-1];
    }

    public static void quickSort(int[] arr,int low, int high, int[] values){ //for case when we have arr2 like this [1,10,2]
        if (arr.length==0 || arr.length==1) {return;}
        if (low>=high) {return;}
        int basicElement = arr[low-(low-high)/2];
        int i=low, j=high;
        while (i<=j){
            while(arr[i]<basicElement) {i++;}
            while (arr[j]>basicElement) {j--;}
            if (i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                //exchange elements of the first array(value)
                temp = values[i];
                values[i]=values[j];
                values[j] = temp;
                i++; j--;
            }
        }
        if(low<j) {quickSort(arr,low,j,values);}
        if (high>i) {quickSort(arr,j+1,high,values);}
    }

}