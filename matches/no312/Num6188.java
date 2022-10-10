package matches.no312;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Num6188 {

    public String[] sortPeople(String[] names, int[] heights) {
        List<int[]> peopleHeights = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            int[] people = {heights[i], i};
            peopleHeights.add(people);
        }
        peopleHeights.sort(Comparator.comparingInt(c -> -c[0]));
        String[] result = new String[names.length];
        result = peopleHeights.stream().map(v -> names[v[1]]).collect(Collectors.toList()).toArray(result);
        return result;
    }
}
