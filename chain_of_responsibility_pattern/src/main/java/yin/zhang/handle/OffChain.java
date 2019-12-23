package yin.zhang.handle;

import yin.zhang.entry.Employee;

import java.util.ArrayList;
import java.util.List;

public class OffChain implements OffHandle {
    private List<OffHandle> handlers;
    private int size = 0;

    public OffChain() {
        handlers = new ArrayList<OffHandle>();
    }

    public OffChain(int size) {
        handlers = new ArrayList<OffHandle>(size);
    }

    public OffChain addHandle(OffHandle handle) {
        handlers.add(handle);
        return this;
    }

    public void handle(Employee employee, OffChain chain) {
        if(size >= handlers.size()) {
            return;
        }
        OffHandle handle = handlers.get(size);
        size ++;
        handle.handle(employee, chain);
    }
}
