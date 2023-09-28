package tests;

import methods.helpers.Context;
import methods.mathMethods.MathMethods;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

public class TestDurationParameter {
    MathMethods methods = new MathMethods();

    @Test
    public void checkCallDuration() throws IOException, ParseException {
        methods
                .saveTimeDurationFromSip()
                .saveTimeDurationFromSoftSwitch()
                .checkTimeDurationsAreTheSame(
                        (Integer) Context.data.get("timeDurationFromSip"),
                        (Integer) Context.data.get("timeDurationFromSoftSwitch"));
    }
}
