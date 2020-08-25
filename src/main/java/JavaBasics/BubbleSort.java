package JavaBasics;

public class BubbleSort {

    public static void main(String[] args) {

        double[] array = new double[100];
        for( int i= 0; i < array.length; i++){
            array[i] = Math.random();
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1 -i; j++){
                if(array[j] > array[j+1]){
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for(int i =0; i < array.length; i++){
            System.out.printf("%.3f, ", array[i]);
        }
    }
}
