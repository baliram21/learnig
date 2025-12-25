package other.baliram.java8;

import java.util.Arrays;
import java.util.List;

public class ReverseSentence {

    public static void main(String[] args) {
        String sentence = "Java is very powerful";

        String reversed = Arrays.stream(sentence.trim().split(" "))
                .reduce((a, b) -> b + " " + a).get();

        System.out.println(reversed);
        System.out.println("------------------------------------");

        List<Integer> list = List.of(2,4,5,6,7,8);

    }
}
