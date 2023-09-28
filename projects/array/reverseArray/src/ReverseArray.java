public class ReverseArray{
    public int[] reverse(int[] myArr){
        int j = myArr.length - 1;

        for(int i = 0; i < myArr.length / 2; i++){
            int temp = myArr[i];
            
            myArr[i] = myArr[j];
            myArr[j--] = temp;
        }
        
        return myArr;
    }
}