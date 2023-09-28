package methods.helpers;

import java.io.IOException;

public class GetTimestamps extends ReadFilesMethods{
    String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\filesToRead\\";

    /**
     * Method returns double value from Sip file -> answer timestamp in seconds and milliseconds
     * (ex: 1662468583.012852)
     */
    public double getAnswerTimestampFromSip(String fileName) throws IOException {
        var s = readTxtFile(filePath + fileName);
        s = s.substring(s.indexOf("answer"));
        s = s.substring(0, s.indexOf("\n"));
        s = s.substring(s.lastIndexOf("\t")).trim();
        System.out.println("Answer time from SIP is: " + s);
        return Double.parseDouble(s);
    }

    /**
     * Method returns double value from Sip file -> clear timestamp in seconds and milliseconds
     * (ex: 1662468584.760172)
     */
    public double getClearTimestampFromSip(String fileName) throws IOException {
        var s = readTxtFile(filePath + fileName);
        s = s.substring(s.lastIndexOf("\t")).trim();
        System.out.println("Clear time from SIP is: " + s);
        return Double.parseDouble(s);
    }

    /**
     * Method returns String value from SoftSwitch file -> answer timestamp date with time
     * (ex: 2022-9-6 13:49:43)
     */
    public String getAnswerTimestampFromSoftSwitch(String fileName) throws IOException {
        var s = readTxtFile(filePath + fileName);
        s = s.substring(s.indexOf("CDR FINAL"));
        s = s.substring(s.indexOf("Answer"));
        s = s.substring(0, s.indexOf("\n"));
        s = s.substring(s.indexOf(":") + 1).trim();
        s = s.substring(0, s.indexOf("."));
        System.out.println("Answer time from softSwitch is: " + s);
        return s;
    }

    /**
     * Method returns String value from SoftSwitch file -> clear timestamp date with time
     * (ex: 2022-9-6 13:49:43)
     */
    public String getClearTimestampFromSoftSwitch(String fileName) throws IOException {
        var s = readTxtFile(filePath + fileName);
        s = s.substring(s.indexOf("CDR FINAL"));
        s = s.substring(s.indexOf("Clear"));
        s = s.substring(0, s.indexOf("\n"));
        s = s.substring(s.indexOf(":") + 1).trim();
        s = s.substring(0, s.indexOf("."));
        System.out.println("Clear time from softSwitch is: " + s);
        return s;
    }
}

