//第四题

import java.util.Scanner;

public class MaxMinClass{
    static int maxInt(int data[],int n){
        int max = data[0];
        for(int i = 1; i < n; i++){
            if(max < data[i])
                max = data[i];
        }
        return max;
    }
    static int minInt(int data[],int n){
        int min = data[0];
        for(int i = 1; i < n; i++){
            if(min > data[i])
                min = data[i];
        }
        return min;
    }
    
    public static void main(String args[]){
        MaxMinClass m = new MaxMinClass();
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        for(int i = 0; i < 10; i++){
            num[i] = in.nextInt();
        }
        System.out.println("最大值: " + m.maxInt(num, 10));
        System.out.println("最小值: " + m.minInt(num, 10));
    }
}