import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistance {
    public static int[] shortestToChar(String s, char c) {
        int[] out = new int[s.length()];

        List<Integer> occurences = new ArrayList<>();

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == c){
                occurences.add(i);
            }
        }
        int i = 0;
        int first_pointer = 0;
        int j = occurences.get(first_pointer);
        int second_pointer = 1;
        if (occurences.size()<2){
            second_pointer = 0;

            for (int p=0; p<out.length; p++){
                out[p] = Math.abs(p - occurences.get(0));
            }
            return out;

        }
        int k = occurences.get(second_pointer);

        while (i < out.length){
            if (i==j || i==k){
                i++;
                if (i>k){
                    first_pointer = second_pointer;
                    second_pointer++;
                    if (second_pointer == occurences.size()){
                        second_pointer--;
                    }
                    j = occurences.get(first_pointer);
                    k = occurences.get(second_pointer);
                }
            }else if (i<j){
                out[i] = Math.abs(j-i);
                i++;
            }else{
                out[i] = Math.min(Math.abs(j-i), Math.abs(k-i));
                i++;
            }
        }

        return out;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("abba", 'b')));
    }
}
