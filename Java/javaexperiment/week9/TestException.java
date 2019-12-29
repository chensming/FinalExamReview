//µÚÒ»Ìâ
public class TestException{
    int a[] = new int [5];
    public void arraySize() throws NegativeArraySizeException{
        // try{
        //     a[-5] = 0;
        // } catch (NegativeArraySizeException e) {
        //     System.out.println(e.toString());
        // } 
        a[-5] = 0;
    }
    public void outofBound(){
        // try{
        //     a[8] = 5;
        // } catch (IndexOutOfBoundsException e){
        //     System.out.println(e.toString());
        // }
        a[8] = 5;
    }
    public void nullPointer(){
        try{
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e){
            System.out.println(e.toString());
        }
    }
    public static void main(String args[]){
        TestException t = new TestException();
        // t.arraySize();
        // t.outofBound();
        t.nullPointer();
    }
}