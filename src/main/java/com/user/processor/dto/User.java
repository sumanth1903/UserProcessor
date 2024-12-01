package com.user.processor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User represents the data transfer object for user information.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("app_version")
    private String appVersion;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("device_type")
    private String deviceType;

    @JsonProperty("device_id")
    private String deviceId;
}