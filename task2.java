
import java.util.logging.Logger;
import java.util.Arrays;

public class task2 {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        int[] mas = { 11, 3, 14, 16, 7 };

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                    logger.info("moved value:" + buf);
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}
