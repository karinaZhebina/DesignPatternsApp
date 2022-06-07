package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TableIterator implements Iterable<String>, Iterator<String> {
  private final String[] columns;
  private final int[] rows;

  private final int rowsLength;
  private int currentRow = 0;
  private int currentIndex = 0;

  public TableIterator(String[] columns, int[] rows) {
    this.columns = columns;
    this.rows = rows;
    this.rowsLength = rows.length;
  }

  @Override
  public String next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    if (currentRow + 1 >= rowsLength) {
      String lastInRow = columns[currentIndex++] + rows[currentRow];
      currentRow = 0;
      return lastInRow;
    }
    return columns[currentIndex] + rows[currentRow++];
  }

  @Override
  public Iterator<String> iterator() {
    return new TableIterator(columns, rows);
  }

  @Override
  public boolean hasNext() {
    return currentIndex < columns.length && currentRow < rowsLength;
  }

}