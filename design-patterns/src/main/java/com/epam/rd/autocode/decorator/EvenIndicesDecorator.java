package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvenIndicesDecorator extends ArrayList<String> {
  private final List<String> sourceList;

  public EvenIndicesDecorator(List<String> sourceList) {
    this.sourceList = sourceList;
  }

  @Override
  public int size() {
    return sourceList.size() / 2;
  }

  @Override
  public Iterator<String> iterator() {
    return super.iterator();
  }

  @Override
  public String get(int index) {
    return sourceList.get(index * 2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size(); i++){
      if (i > 0){
        sb.append(", ");
      }
      sb.append(get(i));
    }
    return "[" + sb + "]";
  }
}
