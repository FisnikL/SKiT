public class Lab1_2 {
    public Boolean IsPowerOfTwo(Integer num)
    {
        if(num == null){
            throw new NullPointerException();
        }

        if( num == 0) {
            return false;
        }
        while(num != 1) {
            if(num%2 != 0){
                return false;
            }
            num = num / 2;
        }
        return true;
    }
}


