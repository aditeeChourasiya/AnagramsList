import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramFinder {public static Set<Set<String>> groupAnagrams(List<String> words)
{
    // a set to store anagrams
    Set<Set<String>> anagrams = new HashSet<>();

    // sort each word on the list
    List<String> list = words.stream()
            .map(s -> Stream.of(s.split("")).sorted()
                    .collect(Collectors.joining()))
            .collect(Collectors.toList());

    // construct a map where the key is each sorted word,
    // and value is a list of indices where it is present
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < list.size(); i++)
    {
        String n = list.get(i);
        map.putIfAbsent(n, new ArrayList<>());
        map.get(n).add(i);
    }

    // traverse the map and read indices for each sorted key.
    for (Map.Entry<String, List<Integer>> entry: map.entrySet())
    {
        //Collect words for the indices for each sorted key from input text file
        Set<String> collection = entry.getValue().stream()
                .map(index -> words.get(index))
                .collect(Collectors.toSet());
        if (collection.size() > 1) {
            anagrams.add(collection);
        }
    }

    return anagrams;
}
}
