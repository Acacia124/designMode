package yin.zhang.handle;

import yin.zhang.entry.Employee;

/**
 * 责任链处理
 */
public interface OffHandle {

    void handle(Employee employee, OffChain chain);

}
