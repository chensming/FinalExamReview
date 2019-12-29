
public class note2{
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put("E", new Double(3444.44));
        tm.put("A", new Double(3596.15));
        tm.put("B", new Double(124.22));
        tm.put("C", new Double(133.95));
        Set<String> keys = tm.keySet();
        for(String str : keys)
        {
            System.out.println(str + " : " +  tm.get(str));
        }
        System.out.println();
    }
}
