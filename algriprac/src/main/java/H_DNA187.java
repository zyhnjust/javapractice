import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: algriprac
 * @description:
 * @author: hzhang
 * @create: 2019-07-06 20:29
 **/
public class H_DNA187 {

    public static void main(String[] args){
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new H_DNA187().findRepeatedDnaSequences(str));

    }
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String string = s.substring(i, i + 10);
            if (hashMap.containsKey(string)) {
                hashMap.put(string, hashMap.get(string) + 1);
            } else {
                hashMap.put(string, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (String string : hashMap.keySet()) {
            if (hashMap.get(string) > 1) {
                list.add(string);
            }
        }
        return list;
    }
}

