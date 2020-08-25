package JavaBasics;

public class MaxMinAvgOfRandomArray {

    public static void main(String[] args) {

        double[] array = new double[100];
        for( int i= 0; i < array.length; i++){
            array[i] = Math.random();
        }

        //double max1 = (double) Arrays.asList(array).stream().reduce(0.0, (Double a, Double b) -> Math.max(a, b));


        double max = array[0];
        double min = array[0];
        double avg = 0;
        for(int i = 1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            } else min = array[i];
            avg += array[i]/array.length;
        }

        System.out.printf("Max = %.4f \nMin = %.4f \nAvg = %.2f", max, min, avg);

        int[] arrayInt = new int[100];
        for( int i= 0; i < arrayInt.length; i++){
            arrayInt[i] = (int) (Math.random()*100);
        }

        for (int i = 0; i < arrayInt.length; i++){
            System.out.println(arrayInt[i]);
        }
    }
}
