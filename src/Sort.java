public class Sort {

    void Bubblesort(int[] array){
        int n = array.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array [j + 1] = tmp;
                }
            }
        }

    }
    void Selectionsort(int[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(array[min] > array[j]){
                    min = j;

                }

            }
            int tmp = array[i];
            array[i] = array[min];
            array [min] = tmp;


        }



    }
    void display(int[] arr)
    {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }


}



