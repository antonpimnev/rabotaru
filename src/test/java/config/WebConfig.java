package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {

    @Key("base_url")
    @DefaultValue("https://www.rabota.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browser_version")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browser_size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remote_url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemote();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean IsRemote();
}