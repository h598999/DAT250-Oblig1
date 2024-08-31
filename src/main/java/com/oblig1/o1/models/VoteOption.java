package com.oblig1.o1.models;

/**
 * VoteOption
 */
public class VoteOption {

  private int presentationOrder;
  private String caption;

  public VoteOption(String caption, int presentationOrder){
    this.caption = caption;
    this.presentationOrder = presentationOrder;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public int getPresentationOrder() {
    return presentationOrder;
  }

  public void setPresentationOrder(int presentationOrder) {
    this.presentationOrder = presentationOrder;
  }
}
