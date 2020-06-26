/* ----------------------------------------------------------------------------------------------------------------------
* © Copyright 2018 Visa. All Rights Reserved.
*
* NOTICE: The software and accompanying information and documentation (together, the “Software”) remain the property of
* and are proprietary to Visa and its suppliers and affiliates. The Software remains protected by intellectual property
* rights and may be covered by U.S. and foreign patents or patent applications. The Software is licensed and not sold.
*
* By accessing the Software you are agreeing to Visa's terms of use (developer.visa.com/terms) and privacy policy
* (developer.visa.com/privacy). In addition, all permissible uses of the Software must be in support of Visa products,
* programs and services provided through the Visa Developer Program (VDP) platform only (developer.visa.com).
* THE SOFTWARE AND ANY ASSOCIATED INFORMATION OR DOCUMENTATION IS PROVIDED ON AN “AS IS,” “AS AVAILABLE,” “WITH ALL
* FAULTS” BASIS WITHOUT WARRANTY OR CONDITION OF ANY KIND. YOUR USE IS AT YOUR OWN RISK.
---------------------------------------------------------------------------------------------------------------------- */

/*
 * Merchant Search API
 * Search for merchant identification data using the acquirer provide name and card acceptor identifiers
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.visa.developer.sample.merchant_search_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Header
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2018-12-19T10:49:06.818+05:30[Asia/Kolkata]")
public class Header {

  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("messageDateTime")
  private String messageDateTime = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("startIndex")
  private Integer startIndex = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("requestMessageId")
  private String requestMessageId = null;
  
  public Header messageDateTime(String messageDateTime) {
    this.messageDateTime = messageDateTime;
    return this;
  }

  
  /**
  * Date and time at which Request is sent (up to milliseconds in UTC). Ex: 2008-09-19T00:00:00.000
  * @return messageDateTime
  **/
  @ApiModelProperty(value = "Date and time at which Request is sent (up to milliseconds in UTC). Ex: 2008-09-19T00:00:00.000")
  public String getMessageDateTime() {
    return messageDateTime;
  }
  public void setMessageDateTime(String messageDateTime) {
    this.messageDateTime = messageDateTime;
  }
  
  public Header startIndex(Integer startIndex) {
    this.startIndex = startIndex;
    return this;
  }

  
  /**
  * Records displayed start at the defined number (Defaulted to 0 if not provided in request)
  * @return startIndex
  **/
  @ApiModelProperty(value = "Records displayed start at the defined number (Defaulted to 0 if not provided in request)")
  public Integer getStartIndex() {
    return startIndex;
  }
  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }
  
  public Header requestMessageId(String requestMessageId) {
    this.requestMessageId = requestMessageId;
    return this;
  }

  
  /**
  * A string which uniquely identifies the service request. Requesting application need to create this unique message Id
  * @return requestMessageId
  **/
  @ApiModelProperty(value = "A string which uniquely identifies the service request. Requesting application need to create this unique message Id")
  public String getRequestMessageId() {
    return requestMessageId;
  }
  public void setRequestMessageId(String requestMessageId) {
    this.requestMessageId = requestMessageId;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Header header = (Header) o;
    return Objects.equals(this.messageDateTime, header.messageDateTime) &&
        Objects.equals(this.startIndex, header.startIndex) &&
        Objects.equals(this.requestMessageId, header.requestMessageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageDateTime, startIndex, requestMessageId);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Header {\n");
    
    sb.append("    messageDateTime: ").append(toIndentedString(messageDateTime)).append("\n");
    sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
    sb.append("    requestMessageId: ").append(toIndentedString(requestMessageId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  
}



