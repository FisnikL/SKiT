public class Domashna7 {
    public static int patternIndex (String subject, String pattern)
    {
        final int NOTFOUND = -1;
        int  iSub = 0, rtnIndex = NOTFOUND;
        boolean isPat  = false;
        int subjectLen = subject.length();
        int patternLen = pattern.length();

        while (isPat == false && iSub + patternLen - 1 < subjectLen)
        {
            if (subject.charAt(iSub) == pattern.charAt(0))
            {
                rtnIndex = iSub; // Starting at zero
                isPat = true;
                for (int iPat = 1; iPat < patternLen; iPat ++)
                {
                    if (subject.charAt(iSub + iPat) != pattern.charAt(iPat))
                    {
                        rtnIndex = NOTFOUND;
                        isPat = false;
                        /* MB: isPat = true; */
                        break;  // out of for loop
                    }
                }
            }
            iSub ++;
        }
        return (rtnIndex);
    }
}
