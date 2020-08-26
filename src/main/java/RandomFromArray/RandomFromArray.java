package RandomFromArray;

/*Можно создать массив, размер которого равен сумме всех весов. Тогда выбор случайного
        элемента сводится к генерации случайного индекса. То есть, если дан массив
        значений [1, 2, 3], и массив весов [1, 2, 10], то можно сразу создать массив
        [1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3] и извлекать из него случайный элемент:*/

public class RandomFromArray {

    private int[] extended_values; // значения

    public RandomFromArray(int[] values, int[] weights) {
        // Сумма длин всех отрезков
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }

        extended_values = new int[sum];
        int cursor = 0;

        for(int i = 0; i < weights.length; i++){
            for(int j = 0; j < weights[i]; j++){
                extended_values[cursor++] = values[i];
            }
        }
    }

    /*
        Массив extended_values уже заполнен,
        так что остаётся сгенерировать значение в промежутке
        [0; extended_values.length)
     */
    public int getRandom() {
        int random = (int) (Math.random() * ( extended_values.length - 1));
        return extended_values[random];
    }
}
