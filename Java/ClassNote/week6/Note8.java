public class Note8{
    public static void main(String args[]){
        StringBuilder str = new StringBuilder(1024);
        String name = "Alice";
        String s = str.append("This is ")
        .append(name).append("!").insert(0,"Hello.").toString();
        System.out.println(s);
    }
}
