public class Note6{
    public static void main(String args[]){
        String s = "Hello";
        System.out.println("1. " + s.equals("hello"));
        System.out.println("2. " + s.equalsIgnoreCase("hello"));
        System.out.println("3. " + s.contains("ll"));
        System.out.println("4. " + s.indexOf("ll"));
        System.out.println("5. " + s.startsWith("he"));
        System.out.println("6. " + s.startsWith("He"));
        System.out.println("7. " + s.endsWith("lo"));

        String s1 = "\t Hello   \r \n";
        String s2 = s1.trim();
        System.out.println("8. " + s2);

        String s3 = "hello,world";
        System.out.println("9. " + s3.toUpperCase());
        System.out.println(s3);
        System.out.println("10. " + s3.toLowerCase());
        //11.hello,worLd
        System.out.println("11. " + s3.replace('l','L'));
        System.out.println("12. " + s3);
        //13.hello,java
        System.out.println("13. " + s3.replace("world","java"));
        //14.hello,world
        System.out.println("14. " + s3);
    }
}