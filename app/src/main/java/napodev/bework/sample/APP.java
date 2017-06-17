package napodev.bework.sample;

import napodev.framework.bework.BaseApp;

/**
 * Created by opannapo on 6/16/17.
 */
public class APP extends BaseApp {
    public static boolean isDevelopment = true;

    public APP() {
        super("APP");
    }

    @Override
    protected String configPreferenceName() {
        return "Bework-Sample";
    }

    @Override
    protected String configPreferenceEncryptKey() {
        return "z1x2c3v4Q1W2E3R4";
    }

    @Override
    protected boolean configLogEnable() {
        return true;
    }

    @Override
    protected boolean configLogDetailLine() {
        return true;
    }

    @Override
    protected boolean configLogCaller() {
        return true;
    }

    @Override
    protected String configLogTag() {
        return "BeworkSample-LOG";
    }
}