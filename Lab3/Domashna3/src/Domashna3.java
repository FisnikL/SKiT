import java.util.List;

public class Domashna3 {
    public Integer findFirstLargerElementThan(List<Integer> list, Integer el){
        /**
         * Effects: if list or element is null throw NullPointerException
         *          else if there is larger element than el in the list return the first larger element,
         *          else if there is no larger element than el return null
         */
        if(list == null || el == null){
            throw new NullPointerException();
        }

        for(Integer element: list){
            if(element > el){
                return element;
            }
        }
        return null;
    }
}

