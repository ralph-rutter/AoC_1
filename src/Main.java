import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ralph Rutter on 29/06/2017.
 */
public class Main {
    public static void main(String[] args) {

        String input = "L1, L3, L5, L3, R145, L4, L5, R1, R3";//"L1, L3, L5, L3, R1, L4, L5, R1, R3, L5, R1, L3, L2, L3, R2, R2, L3, L3, R1, L2, R1, L3, L2, R4, R2, L5, R4, L5, R4, L2, R3, L2, R4, R1, L5, L4, R1, L2, R3, R1, R2, L4, R1, L2, R3, L2, L3, R5, L192, R4, L5, R4, L1, R4, L4, R2, L5, R45, L2, L5, R4, R5, L3, R5, R77, R2, R5, L5, R1, R4, L4, L4, R2, L4, L1, R191, R1, L1, L2, L2, L4, L3, R1, L3, R1, R5, R3, L1, L4, L2, L3, L1, L1, R5, L4, R1, L3, R1, L2, R1, R4, R5, L4, L2, R4, R5, L1, L2, R3, L4, R2, R2, R3, L2, L3, L5, R3, R1, L4, L3, R4, R2, R2, R2, R1, L4, R4, R1, R2, R1, L2, L2, R4, L1, L2, R3, L3, L5, L4, R4, L3, L1, L5, L3, L5, R5, L5, L4, L2, R1, L2, L4, L2, L4, L1, R4, R4, R5, R1, L4, R2, L4, L2, L4, R2, L4, L1, L2, R1, R4, R3, R2, R2, R5, L1, L2";

        String[] inputArr = input.split(", ");
        ArrayList<String[]> directions = new ArrayList<>();

        for(String dir : inputArr) {
            directions.add(dir.split("", 2));
        }

        System.out.println(Arrays.toString(inputArr));

        for (String[] pair : directions) {
            System.out.println(Arrays.toString(pair));
        }

        int[] position = {0,0};
        Orientation ori = Orientation.NORTH;



        for (String[] dir : directions) {
            if (dir[0].equals("L")) {
                ori = Orientation.fromNumber((ori.value - 1 + 4) % 4); //extra 4 added to avoid -ve
            } else {
                ori = Orientation.fromNumber((ori.value + 1) % 4);            }
        }

        System.out.println(ori.value);
        System.out.println(ori);

    }

    private enum Orientation {
        NORTH(0), EAST(1), SOUTH(2), WEST(3);

        private int value;

        Orientation(int value) {
            this.value = value;
        }

        static Orientation fromNumber(int number) {
            for (Orientation o : Orientation.values()) {
                if (o.value == number) {
                    return o;
                }
            }
            return null;
        }


    }
}
