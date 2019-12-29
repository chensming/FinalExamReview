class Work{
    private String Str;

    Work(String Str){
        Alter(Str);
    }

    public void Alter(String Str){
        this.Str = Str;
    }

    public void Display(){
        char c;
        int[] time = new int[123];
        int maxTime = 0, subScript = 65;
        for(int i = 0; i < Str.length(); i++)
        {
            time[(int)Str.charAt(i)]++;
        }
        for(int i = 65; i < time.length; i++)
        {
            if( maxTime < time[i])
            {
                maxTime = time[i];
                subScript = i;
            }
        }
        System.out.println((char)subScript + "->" + maxTime);
    }
}

public class Ex5{
    public static void main(String args[]){
        Work w = new Work("abbcccddddeeeee");
        w.Display();
        w.Alter("accdddfffggggiiiiiiiiiiio");
        w.Display();
    }
}