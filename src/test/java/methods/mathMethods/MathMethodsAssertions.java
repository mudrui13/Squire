package methods.mathMethods;

import org.junit.jupiter.api.Assertions;

public class MathMethodsAssertions {

    public void checkTimeDurationsAreTheSame(int timeFromSip, int timeFromSoftSwitch){
        System.out.println("Time duration from sip: " + timeFromSip
                + "\nTime duration from softSwitch: " + timeFromSoftSwitch);
        Assertions.assertEquals(timeFromSip, timeFromSoftSwitch);
    }
}
