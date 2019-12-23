package yin.zhang.handle;

import yin.zhang.entry.Employee;

import java.util.Random;

/**
 * 政委审批
 */
public class CommissarHandle implements OffHandle {
    public void handle(Employee employee, OffChain chain) {
        boolean flag = new Random().nextBoolean();
        if (flag) {
            employee.addHandleProcess("第三步-" + CommissarHandle.class.getName() + ": 已批准", true);
        } else {
            employee.addHandleProcess("第三步-" + CommissarHandle.class.getName() + ": 不批准", false);
        }
    }
}
