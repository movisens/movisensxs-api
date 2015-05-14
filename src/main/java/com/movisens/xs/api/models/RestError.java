package com.movisens.xs.api.models;

import com.google.gson.annotations.SerializedName;

public class RestError
{
  @SerializedName("code")
  private Integer code;

  @SerializedName("error_message")
  private String strMessage;

  public RestError(String strMessage)
  {
      this.strMessage = strMessage;
  }

  //Getters and setters
}