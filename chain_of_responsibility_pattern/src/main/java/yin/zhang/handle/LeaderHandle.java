package yin.zhang.handle;

import yin.zhang.entry.Employee;

import java.util.Random;

/**
 * 小组leader审批
 */
public class LeaderHandle implements OffHandle {
    public void handle(Employee employee, OffChain chain) {
        boolean flag = new Random().nextBoolean();
        if (employee.getDays() <= 3) {
            if (flag) {
                employee.addHandleProcess("第一步-" + LeaderHandle.class.getName() + ": 已批准", true);
            } else {
                employee.addHandleProcess("第一步-" + LeaderHandle.class.getName() + ": 不批准", false);
            }
        } else if (flag) {
            employee.addHandleProcess("第一步-" + LeaderHandle.class.getName() + ": 审批通过，待上级审批", true);
            // 进入下一级
            chain.handle(employee, chain);
        } else {
            employee.addHandleProcess("第一步-" + LeaderHandle.class.getName() + ": 不批准", false);
        }
    }
}
