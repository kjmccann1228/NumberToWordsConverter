/**
 * Created by kurtmccann on 11/3/16.
 */

public class NumberToWord
{
    public static String checkThreeDigitNumber(String input)
    {
        String firstPart="";
        String secondPart="";
        String thirdPart="";

        if(input.length()==1)
        {
            firstPart=checkOnes(input.charAt(0));
        }

        if(input.length()==2)
        {
            if(input.charAt(0)=='1')
            {
                secondPart=checkTeen(input.charAt(1));
            }
            else
            {
                secondPart=checkTens(input.charAt(0));
                firstPart=checkOnes(input.charAt(1));
            }
        }
        if(input.length()==3)
        {
            if(input.charAt(1)=='1')
            {
                secondPart=checkTeen(input.charAt(2));
            }
            else
            {
                secondPart=checkTens(input.charAt(1));
                firstPart=checkOnes(input.charAt(2));
            }
            thirdPart=checkHundreds(input.charAt(0));
        }
        return thirdPart+secondPart+firstPart;
    }

    public static String checkOnes(char input)
    {
        switch (input)
        {

            case '1':
                return "One";
            case '2' :
                return "Two";
            case '3' :
                return "Three";
            case '4' :
                return "Four";
            case '5' :
                return "Five";
            case '6' :
                return "Six";
            case '7' :
                return "Seven";
            case '8' :
                return "Eight";
            case '9' :
                return "Nine";
            default: return "";
        }
    }
    public static String checkTeen(char input)
    {
        switch (input)
        {
            case '0':
                return "Ten";
            case '1':
                return "Eleven";
            case '2' :
                return "Twelve";
            case '3' :
                return "Thirteen";
            case '4' :
                return "Fourteen";
            case '5' :
                return "Fifteen";
            case '6' :
                return "Sixteen";
            case '7' :
                return "Seventeen";
            case '8' :
                return "Eighteen";
            case '9' :
                return "Nineteen";
            default: return "";
        }
    }
    public static String checkTens(char input)
    {
        switch (input)
        {
            case '2' :
                return "Twenty";
            case '3' :
                return "Thirty";
            case '4' :
                return "Forty";
            case '5' :
                return "Fifty";
            case '6' :
                return "Sixty";
            case '7' :
                return "Seventy";
            case '8' :
                return "Eighty";
            case '9' :
                return "Ninety";
            default: return "";
        }
    }
    public static String checkHundreds(char input)
    {
        switch (input)
        {
            case '1' :
                return "OneHundred";
            case '2' :
                return "TwoHundred";
            case '3' :
                return "ThreeHundred";
            case '4' :
                return "FourHundred";
            case '5' :
                return "FiveHundred";
            case '6' :
                return "SixHundred";
            case '7' :
                return "SevenHundred";
            case '8' :
                return "EightHundred";
            case '9' :
                return "NineHundred";
            default: return "";
        }
    }

    public static String convertNumber(String number)
    {
        String toReturn = "";
        String millions = "";
        String thousands = "";
        String ones = "";

        if (number.length() > 6)  ///number is in millions
        {
            millions = number.substring(0, number.length() - 6);
            thousands = number.substring(number.length() - 6, number.length() - 3);
            ones = number.substring(number.length() - 3, number.length());
//            toReturn=checkThreeDigitNumber(millions)+"Million"+checkThreeDigitNumber(thousands)+"Thousand"+checkThreeDigitNumber(ones);
        } else if (number.length() > 3)  //number is in hundred thousands
        {
            thousands = number.substring(0, number.length() - 3);
            ones = number.substring(number.length() - 3, number.length());
//            toReturn=checkThreeDigitNumber(thousands)+"Thousand"+checkThreeDigitNumber(ones);
        } else  //number is in hundreds
        {
            if (number.equals("0"))
            {
                ones = "Zero";
            } else
            {
                ones = number;
            }
        }

        return (convertToString(millions, thousands, ones));
    }

    public static String convertToString(String millions, String thousands, String ones)
    {
        millions = checkThreeDigitNumber(millions);
        thousands = checkThreeDigitNumber(thousands);
        ones = checkThreeDigitNumber(ones);

        if(!millions.equals(""))
        {
            millions=millions+"Million";
        }
        if(!thousands.equals(""))
        {
            thousands=thousands+"Thousand";
        }

        return millions+thousands+ones+"Dollars";

    }



    public static void main(String[] args)
    {
        String number = "612194567";
        System.out.println(number);
        System.out.println(convertNumber(number));
    }

}
