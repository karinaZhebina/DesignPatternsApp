package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayIterator implements Iterator<Integer> {
  private final int[] array;

  private final int maxRepeats;
  private int currentRepeat = 0;
  private int currentIndex = 0;

  public IntArrayIterator(int[] array, int maxRepeats) {
    this.maxRepeats = maxRepeats;
    this.array = array;
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    if (++currentRepeat >= maxRepeats) {
      currentRepeat = 0;
      return array[currentIndex++];
    }
    return array[currentIndex];
  }

  @Override
  public boolean hasNext() {
    return currentIndex < array.length && currentRepeat < maxRepeats;
  }

}
