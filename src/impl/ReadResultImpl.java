package impl;

import contracts.ReadResult;

import java.util.ArrayList;

public class ReadResultImpl<T> implements ReadResult<T>{
    private ArrayList<T> items;
    private int errorCount;

    public ReadResultImpl(ArrayList<T> items, int errorCount) {
        this.items = items;
        this.errorCount = errorCount;
    }

    @Override
    public ArrayList<T> getItems() {
        return items;
    }

    @Override
    public int getErrorCount() {
        return errorCount;
    }
}
