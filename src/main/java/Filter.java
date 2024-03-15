import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer i : source) {
            if (i >= threshold) {
                result.add(i);
            }
            logger.log(format("Элемент '%d'%s проходит", i, i >= threshold ? "" : " не"));
        }
        logger.log(format("Фильтрацию прошло '%d' из '%d' элементов", result.size(), source.size()));
        return result;
    }
}