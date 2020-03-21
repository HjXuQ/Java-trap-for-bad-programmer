package com.xuhj.javaApi;


public class CalPre {
    public double getFm(Integer[] arr1,Double average,Integer[] arr2,Double average2){
        double num1 = 0;
        double num2 = 0;
        for(int i = 0;i<arr1.length;i++){
            num1+=Math.pow((arr1[i] - average),2);
        }
        num1 = Math.sqrt(num1);
        for(int i = 0;i<arr2.length;i++){
            num2+=Math.pow((arr2[i] - average2),2);
        }
        num2 = Math.sqrt(num2);
        return  num1*num2;
    }
    public double getAvem(Integer[] arr){
        double averAge = 0;
        double num = 0;
        for(Integer single : arr){
            num+=single;
        }
        return (double)(num/arr.length);
    }
    public double getFz(Integer[] arr1,double average1,double average2,Integer[] arr2){
        double fz = 0;
        for(int i = 0;i<arr1.length;i++){
            fz+=(arr1[i]-average1)*(arr2[i]-average2);
        }
        return fz;
    }
    public static void main(String[] args) {
        CalPre calPre = new CalPre();
        Integer[] Alice = new Integer[]{5, 3, 4, 4};
        Integer[] user1 = new Integer[]{3, 1, 2, 3};
        Integer[] user2 = new Integer[]{4, 3, 4, 3};
        Integer[] user3 = new Integer[]{3, 3, 1, 5};
        Integer[] user4 = new Integer[]{1, 5, 5, 2};
        System.out.println("Alice" + calPre.getAvem(Alice));
        System.out.println("user1" + calPre.getAvem(user1));
        System.out.println("user2" + calPre.getAvem(user2));
        System.out.println("user3" + calPre.getAvem(user3));
        System.out.println("user4" + calPre.getAvem(user4));
        double user1Fz = calPre.getFz(Alice,calPre.getAvem(Alice),calPre.getAvem(user4),user4);
        System.out.println(user1Fz);
        double user1Fm = calPre.getFm(Alice,calPre.getAvem(Alice),user4,calPre.getAvem(user4));
        System.out.println(user1Fm);
        System.out.println(user1Fz/user1Fm);

    }
}
