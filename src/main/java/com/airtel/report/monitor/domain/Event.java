package com.airtel.report.monitor.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sunny on 04/03/18.
 */

@Document(collection = "event")
public class Event
{
    @Id
    private String id;

    private String osVersion;

    private String ts;

    private String scrResolution;

    private String eventType;

    private String appPlatform;

    private String evSource;

    private String cid;

    private String siteId;

    private String appVersion;

    private String deviceNetwork;

    private String userId;

    private String gender;

    private String ua;

    private String eventName;

    private String deviceId;

    private String ipAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOsVersion ()
    {
        return osVersion;
    }

    public void setOsVersion (String osVersion)
    {
        this.osVersion = osVersion;
    }

    public String getTs ()
    {
        return ts;
    }

    public void setTs (String ts)
    {
        this.ts = ts;
    }

    public String getScrResolution ()
    {
        return scrResolution;
    }

    public void setScrResolution (String scrResolution)
    {
        this.scrResolution = scrResolution;
    }

    public String getEventType ()
    {
        return eventType;
    }

    public void setEventType (String eventType)
    {
        this.eventType = eventType;
    }

    public String getAppPlatform ()
    {
        return appPlatform;
    }

    public void setAppPlatform (String appPlatform)
    {
        this.appPlatform = appPlatform;
    }

    public String getEvSource ()
    {
        return evSource;
    }

    public void setEvSource (String evSource)
    {
        this.evSource = evSource;
    }

    public String getCid ()
    {
        return cid;
    }

    public void setCid (String cid)
    {
        this.cid = cid;
    }

    public String getSiteId ()
    {
        return siteId;
    }

    public void setSiteId (String siteId)
    {
        this.siteId = siteId;
    }

    public String getAppVersion ()
    {
        return appVersion;
    }

    public void setAppVersion (String appVersion)
    {
        this.appVersion = appVersion;
    }

    public String getDeviceNetwork ()
    {
        return deviceNetwork;
    }

    public void setDeviceNetwork (String deviceNetwork)
    {
        this.deviceNetwork = deviceNetwork;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public String getUa ()
    {
        return ua;
    }

    public void setUa (String ua)
    {
        this.ua = ua;
    }

    public String getEventName ()
    {
        return eventName;
    }

    public void setEventName (String eventName)
    {
        this.eventName = eventName;
    }

    public String getDeviceId ()
    {
        return deviceId;
    }

    public void setDeviceId (String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getIpAddress ()
    {
        return ipAddress;
    }

    public void setIpAddress (String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
}