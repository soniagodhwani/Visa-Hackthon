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
 * ResponseHeader
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2018-12-19T10:49:06.818+05:30[Asia/Kolkata]")
public class ResponseHeader {

  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("responseMessageId")
  private String responseMessageId = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("messageDateTime")
  private String messageDateTime = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("endIndex")
  private Integer endIndex = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("numRecordsMatched")
  private Integer numRecordsMatched = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("startIndex")
  private Integer startIndex = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("requestMessageId")
  private String requestMessageId = null;
  
  
  @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonProperty("numRecordsReturned")
  private Integer numRecordsReturned = null;
  
  public ResponseHeader responseMessageId(String responseMessageId) {
    this.responseMessageId = responseMessageId;
    return this;
  }

  
  /**
  * A combination of Service Id, Application Id, an Integer and current Timestamp that uniquely identifies the current request-response processing
  * @return responseMessageId
  **/
  @ApiModelProperty(value = "A combination of Service Id, Application Id, an Integer and current Timestamp that uniquely identifies the current request-response processing")
  public String getResponseMessageId() {
    return responseMessageId;
  }
  public void setResponseMessageId(String responseMessageId) {
    this.responseMessageId = responseMessageId;
  }
  
  public ResponseHeader messageDateTime(String messageDateTime) {
    this.messageDateTime = messageDateTime;
    return this;
  }

  
  /**
  * Date and time at which Response is sent (up to milliseconds in UTC). Ex: 2008-09-19T00:00:00.000
  * @return messageDateTime
  **/
  @ApiModelProperty(value = "Date and time at which Response is sent (up to milliseconds in UTC). Ex: 2008-09-19T00:00:00.000")
  public String getMessageDateTime() {
    return messageDateTime;
  }
  public void setMessageDateTime(String messageDateTime) {
    this.messageDateTime = messageDateTime;
  }
  
  public ResponseHeader endIndex(Integer endIndex) {
    this.endIndex = endIndex;
    return this;
  }

  
  /**
  * Record End Index
  * @return endIndex
  **/
  @ApiModelProperty(value = "Record End Index")
  public Integer getEndIndex() {
    return endIndex;
  }
  public void setEndIndex(Integer endIndex) {
    this.endIndex = endIndex;
  }
  
  public ResponseHeader numRecordsMatched(Integer numRecordsMatched) {
    this.numRecordsMatched = numRecordsMatched;
    return this;
  }

  
  /**
  * Number of records matched
  * @return numRecordsMatched
  **/
  @ApiModelProperty(value = "Number of records matched")
  public Integer getNumRecordsMatched() {
    return numRecordsMatched;
  }
  public void setNumRecordsMatched(Integer numRecordsMatched) {
    this.numRecordsMatched = numRecordsMatched;
  }
  
  public ResponseHeader startIndex(Integer startIndex) {
    this.startIndex = startIndex;
    return this;
  }

  
  /**
  * Record Start Index
  * @return startIndex
  **/
  @ApiModelProperty(value = "Record Start Index")
  public Integer getStartIndex() {
    return startIndex;
  }
  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }
  
  public ResponseHeader requestMessageId(String requestMessageId) {
    this.requestMessageId = requestMessageId;
    return this;
  }

  
  /**
  * A string uniquely identifies the service request. Response will contain same Message Id as received from requesting application
  * @return requestMessageId
  **/
  @ApiModelProperty(value = "A string uniquely identifies the service request. Response will contain same Message Id as received from requesting application")
  public String getRequestMessageId() {
    return requestMessageId;
  }
  public void setRequestMessageId(String requestMessageId) {
    this.requestMessageId = requestMessageId;
  }
  
  public ResponseHeader numRecordsReturned(Integer numRecordsReturned) {
    this.numRecordsReturned = numRecordsReturned;
    return this;
  }

  
  /**
  * Number of records returned. Note: Matched records may differ from returned records if Max Records is defined or system limit is exceeded
  * @return numRecordsReturned
  **/
  @ApiModelProperty(value = "Number of records returned. Note: Matched records may differ from returned records if Max Records is defined or system limit is exceeded")
  public Integer getNumRecordsReturned() {
    return numRecordsReturned;
  }
  public void setNumRecordsReturned(Integer numRecordsReturned) {
    this.numRecordsReturned = numRecordsReturned;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseHeader responseHeader = (ResponseHeader) o;
    return Objects.equals(this.responseMessageId, responseHeader.responseMessageId) &&
        Objects.equals(this.messageDateTime, responseHeader.messageDateTime) &&
        Objects.equals(this.endIndex, responseHeader.endIndex) &&
        Objects.equals(this.numRecordsMatched, responseHeader.numRecordsMatched) &&
        Objects.equals(this.startIndex, responseHeader.startIndex) &&
        Objects.equals(this.requestMessageId, responseHeader.requestMessageId) &&
        Objects.equals(this.numRecordsReturned, responseHeader.numRecordsReturned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseMessageId, messageDateTime, endIndex, numRecordsMatched, startIndex, requestMessageId, numRecordsReturned);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseHeader {\n");
    
    sb.append("    responseMessageId: ").append(toIndentedString(responseMessageId)).append("\n");
    sb.append("    messageDateTime: ").append(toIndentedString(messageDateTime)).append("\n");
    sb.append("    endIndex: ").append(toIndentedString(endIndex)).append("\n");
    sb.append("    numRecordsMatched: ").append(toIndentedString(numRecordsMatched)).append("\n");
    sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
    sb.append("    requestMessageId: ").append(toIndentedString(requestMessageId)).append("\n");
    sb.append("    numRecordsReturned: ").append(toIndentedString(numRecordsReturned)).append("\n");
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



