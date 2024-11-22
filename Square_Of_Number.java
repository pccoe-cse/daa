import java.util.*;

public class Square_Of_Number {
    public static String Addition (String str1, String str2)
    {
        String str= new String();
        int sum,carry=0;
        if(str1.length() > str2.length())
        {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int n1=str1.length();
        int n2=str2.length();

        str1= new StringBuilder(str1).reverse().toString();
        str2= new StringBuilder(str2).reverse().toString();
        for(int i=0;i<n1;i++)
        {
            sum = (str1.charAt(i)-'0') + (str2.charAt(i)-'0') + carry;
            str = str + (char)(sum%10 + '0');
            carry = sum/10;
        }
        for(int i=n1;i<n2;i++)
        {
            sum = (str2.charAt(i)-'0') + carry;
            str = str + (char)(sum%10 + '0');
            carry = sum/10;
        }
        if(carry!=0)
        {
            str = str + (char)(carry%10 + '0');
        }

        str = new StringBuilder(str).reverse().toString();
        return str;
    }
    public static String Difference(String str1,String str2)
    {
        String str= new String();
        int diff,borrow=0;
        if(str1.length() < str2.length())
        {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int n1=str1.length();
        int n2=str2.length();

        str1= new StringBuilder(str1).reverse().toString();
        str2= new StringBuilder(str2).reverse().toString();

        for(int i=0;i<n2;i++)
        {
            diff = (str1.charAt(i)-'0') - (str2.charAt(i)-'0') - borrow;
            if(diff<0)
            {
                diff = diff + 10;
                borrow = 1;
            }
            else
            {
                borrow = 0;
            }
            str = str + (char)(diff + '0');
        }
        for(int i=n2;i<n1;i++)
        {
            diff = (str1.charAt(i)-'0') - borrow;
            if(diff<0)
            {
                diff = diff + 10;
                borrow = 1;
            }
            else
            {
                borrow = 0;
            }
            str = str + (char)(diff + '0');
        }

        str = new StringBuilder(str).reverse().toString();
        return str;
    }
    public static String Multiply(String str1,String str2)
    {
        int count=0;
        if(str1.length() > str2.length())
        {
            String temp=str1;
            str1=str2;
            str2=temp;
        }
        int n1=str1.length();
        int n2=str2.length();
        while(n1<n2)
        {
            str1= '0' + str1;
            count++;
            n1++;
        }
        if(n1==1)
        {
            int ans=Integer.parseInt(str1)*Integer.parseInt(str2);
            return Integer.toString(ans);
        }
        if(n1%2==1)
        {
            n1++;
            str1= '0' + str1;
            count++;
            str2= '0' + str2;
            count++;
        }
        String Al="",Ar="",Bl="",Br="";
        for(int i=0;i<n1/2;i++)
        {
            Al= Al + str1.charAt(i);
            Bl= Bl + str2.charAt(i);
            Ar= Ar + str1.charAt((n1/2)+i);
            Br= Br + str2.charAt((n1/2)+i);
        }
        String l=Multiply(Al,Bl);
        String m=Multiply(Ar,Br);
        String n=Difference(Multiply(Addition(Al,Ar),Addition(Bl,Br)),Addition(l,m));
        for(int i=0;i<n1;i++)
        {
            l = l + '0';
        }
        for(int i=0;i<n1/2;i++)
        {
            n = n + '0';
        }

        String str=Addition(l,Addition(m,n));
        return str.substring(count,str.length()-1);

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int ch;
        String str = new String();
        String str1 = new String();
        String str2 = new String();
        do
        {
            System.out.println("**********Menu***********");
            System.out.println("1. Square of a number\n2. Product of two large numbers\n3.Exit");
            System.out.print("Your choice: ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                {
                    System.out.print("Enter number: ");
                    str1 = sc.next();
                    str = Multiply(str1,str1);
                    System.out.println("Square of a number "+ str1 + " is: " + str);
                }
                break;
                case 2:
                {
                    System.out.print("Enter first number: ");
                    str1 = sc.next();
                    System.out.print("Enter second number: ");
                    str2 = sc.next();
                    str = Multiply(str1,str2);
                    System.out.println("Multiplication of " + str1 + " and " + str2 + " is: " + str);
                }
                break;
                case 3:
                {
                    System.out.println("Thank you!!!");
                }
                break;
                default:
                {
                    System.out.println("You entered wrong choice!!!\nTry again.");
                }
                break;
            }
        }while(ch!=3);
    }
}
