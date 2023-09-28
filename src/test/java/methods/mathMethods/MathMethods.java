package methods.mathMethods;

import methods.helpers.Context;
import methods.helpers.GetTimestamps;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MathMethods extends MathMethodsAssertions {
    public GetTimestamps getTimestamps;
    public MathMethods(){
        getTimestamps = new GetTimestamps();
    }

    /**
     * Method saves time duration from Sip file in seconds
     */
    public MathMethods saveTimeDurationFromSip() throws IOException {
        double timeDurationFromSip = Math.floor((getTimestamps.getClearTimestampFromSip("sip.log") -
                        getTimestamps.getAnswerTimestampFromSip("sip.log")) * 100) / 100;
        int roundInt = (int) Math.round(timeDurationFromSip);
        Context.data.put("timeDurationFromSip", roundInt);
        return this;
    }

    /**
     * Method saves time duration from SoftSwitch file in seconds
     */
    public MathMethods saveTimeDurationFromSoftSwitch() throws IOException, ParseException {
        long softSwitchAnswerLong = getSecondsFromDate(getTimestamps.getAnswerTimestampFromSoftSwitch("softswitch.txt"));
        long softSwitchClearLong = getSecondsFromDate(getTimestamps.getClearTimestampFromSoftSwitch("softswitch.txt"));
        int timeDurationFromSoftSwitch = Math.toIntExact((softSwitchClearLong - softSwitchAnswerLong));
        Context.data.put("timeDurationFromSoftSwitch", timeDurationFromSoftSwitch);
        return this;
    }

    //private methods
    /**
     * Method returns seconds for parameter date
     * (ex: 1662468583)
     */
    private long getSecondsFromDate(String value) throws ParseException {
        var df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        return df.parse(value).getTime() / 1000;
    }
}
