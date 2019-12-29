import java.util.HashSet;
import java.util.Scanner;

public class J_Calculator
{
    private static boolean dividedByZero=false;
    private static HashSet digit,numberExcludedSign,numberExcludedPercent,partOfNumber,operator;

    private static StringBuffer expression;

    private static void initialize()
    {
        digit=new HashSet();
        partOfNumber=new HashSet();
        numberExcludedSign=new HashSet();
        numberExcludedPercent=new HashSet();
        for (int i='0';i<='9';i++)
        {
            digit.add((char)i);
            numberExcludedSign.add((char)i);
            numberExcludedPercent.add((char)i);
            partOfNumber.add((char)i);
        }
        numberExcludedSign.add('.');
        numberExcludedSign.add('%');
        numberExcludedPercent.add('~');
        numberExcludedPercent.add('.');
        partOfNumber.add('~');
        partOfNumber.add('.');
        partOfNumber.add('%');
        
        operator=new HashSet();
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
    }

    private static boolean check(StringBuffer expression)
    {
        for (int i=0;i<expression.length();i++)
            if (expression.charAt(i)=='~') return false;
            else if (expression.charAt(i)=='-')
                if (i==0 || expression.charAt(i-1)=='(')
                    expression.setCharAt(i,'~');

        int bracketSum=0;
        boolean isReadingNumber=false,hasDecimalPoint=true;

        for (int i=0;i<expression.length();i++)
        {
            char ch=expression.charAt(i);
            if (ch=='(')
            {
                bracketSum++;
                isReadingNumber=false;
            }
            else if (ch==')')
            {
                bracketSum--;
                if (bracketSum<0) return false;
                if (i==0 || expression.charAt(i-1)=='(') return false;
                
                isReadingNumber=false;
            }
            else if (operator.contains(ch))
            {
                boolean flag=false;
                int pos=i-1;
                while (pos>=0)
                {
                    if (expression.charAt(pos)==')') pos--;
                    else if (partOfNumber.contains(expression.charAt(pos)))
                    {
                        flag=true;
                        break;
                    }
                    else return false;
                }
                if (!flag) return false;

                flag=false;
                pos=i+1;
                while (pos<expression.length())
                {
                    if (expression.charAt(pos)=='(') pos++;
                    else if (partOfNumber.contains(expression.charAt(pos)))
                    {
                        flag=true;
                        break;
                    }
                    else return false;
                }
                if (!flag) return false;

                isReadingNumber=false;
            }
            else if (ch=='=')
            {
                if (i!=expression.length()-1)
                    return false;
                
                isReadingNumber=false;
            }
            else if (digit.contains(ch))
            {
                if (!isReadingNumber)
                {
                    isReadingNumber=true;
                    hasDecimalPoint=false;
                }
            }
            else if (ch=='~')
            {
                if (!isReadingNumber)
                {
                    isReadingNumber=true;
                    hasDecimalPoint=false;
                }

                boolean flag=false;
                int pos=i+1;
                while (pos<expression.length())
                {
                    if (expression.charAt(pos)=='(') pos++;
                    else if (partOfNumber.contains(expression.charAt(pos)))
                    {
                        flag=true;
                        break;
                    }
                    else return false;
                }
                if (!flag) return false;
            }
            else if (ch=='.')
            {
                if (!isReadingNumber)
                {
                    isReadingNumber=true;
                    hasDecimalPoint=false;
                }
                else if (hasDecimalPoint) return false;
                hasDecimalPoint=true;

                boolean flag=false;
                if (i!=0 && digit.contains(expression.charAt(i-1)))
                    flag=true;
                if (i!=expression.length()-1 && digit.contains(expression.charAt(i+1)))
                    flag=true;
                if (!flag) return false;
            }
            else if (ch=='%')
            {
                if (!isReadingNumber)
                {
                    isReadingNumber=true;
                    hasDecimalPoint=false;
                }

                if (i==0 || !numberExcludedSign.contains(expression.charAt(i-1)))
                    return false;
                if (i!=expression.length()-1 && numberExcludedPercent.contains(expression.charAt(i+1)))
                    return false;
            }
            else return false;
        }
        if (bracketSum!=0) return false;
        return true;
    }

    private static double calculate(StringBuffer expression,int l,int r)
    {
        //System.err.println(l+" "+r);
        if (expression.charAt(expression.length()-1)=='=')
            return calculate(expression,l,r-1);

        if (expression.charAt(l)=='(')
        {
            boolean flag=true;
            int bracketSum=0;
            for (int i=l+1;i<r;i++)
            {
                if (expression.charAt(i)=='(') bracketSum++;
                if (expression.charAt(i)==')') bracketSum--;

                if (bracketSum<0)
                {
                    flag=false;
                    break;
                }
            }
                
            if (flag && bracketSum==0) return calculate(expression,l+1,r-1);
        }

        int bracketSum=0;
        int posAddOrMinus=-1,posMultiplyOrDivide=-1;
        for (int i=l;i<=r;i++)
        {
            char ch=expression.charAt(i);
            if (ch=='(') bracketSum++;
            else if (ch==')') bracketSum--;
            else if (bracketSum==0)
            {
                if (ch=='+' || ch=='-')
                    posAddOrMinus=i;
                else if (ch=='*' || ch=='/')
                    posMultiplyOrDivide=i;
            }
        }
        
        //System.err.println(posAddOrMinus+"<<<"+posMultiplyOrDivide);

        if (posAddOrMinus!=-1)
        {
            double a=calculate(expression,l,posAddOrMinus-1);
            double b=calculate(expression,posAddOrMinus+1,r);
            if (expression.charAt(posAddOrMinus)=='+') return a+b;
            else return a-b;
        }
        else if (posMultiplyOrDivide!=-1)
        {
            double a=calculate(expression,l,posMultiplyOrDivide-1);
            double b=calculate(expression,posMultiplyOrDivide+1,r);
            //System.err.println(a+" "+b+"$$$");
            if (expression.charAt(posMultiplyOrDivide)=='/' && Math.abs(b)<1e-10)
            {
                dividedByZero=true;
                return 0;
            }
            if (expression.charAt(posMultiplyOrDivide)=='*') return a*b;
            else return a/b;
        }
        else
        {
            if (expression.charAt(l)=='~') return -calculate(expression,l+1,r);

            int posPercent=r+1;
            for (int i=l;i<=r;i++)
                if (expression.charAt(i)=='%')
                {
                    posPercent=i;
                    break;
                }

            double a=Double.valueOf(expression.substring(l,posPercent));
            for (int i=posPercent;i<=r;i++)
                a/=10.0;

            return a;
        }
    }

    public static void main(String args[])
    {
        initialize();

        System.out.println("************************************************************************");
        System.out.println("* This is a program which can calculate the expression you input.      *");
        System.out.println("* Note that your expression should only contains elements as follows:  *");
        System.out.println("* 0,1,2,3,4,5,6,7,8,9,.,%,+,-,*,/,(,),=                                *");
        System.out.println("* And you can choose to end your expression with = or not.             *");
        System.out.println("*                                                                      *");
        System.out.println("************************************************************************\n");
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Please in put your expression:");
            String str=sc.nextLine();
            expression=new StringBuffer(str);
            if (!check(expression)) System.out.println("Invalid expression!\n");
            else
            {
                dividedByZero=false;
                double answer=calculate(expression,0,expression.length()-1);
                if (dividedByZero) System.out.println("The divisor cannot be zero!\n");
                else
                {
                    if (str.charAt(str.length()-1)=='=')
                        System.out.println(str+answer+"\n");
                    else
                        System.out.println(str+"="+answer+"\n");
                }
            }
        }
    }
}