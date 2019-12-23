package yin.zhang.handle;

import yin.zhang.entry.Employee;

import java.util.Random;

/**
 * 项目负责人审批
 */
public class DepartmentHandle implements OffHandle {
    public void handle(Employee employee, OffChain chain) {
        boolean flag = new Random().nextBoolean();
        if (employee.getDays() <= 7) {
            if (flag) {
                employee.addHandleProcess("第二步-" + DepartmentHandle.class.getName() + ": 已批准", true);
            } else {
                employee.addHandleProcess("第二步-" + DepartmentHandle.class.getName() + ": 不批准", false);
            }
        } else if (flag) {
            employee.addHandleProcess("第二步-" + DepartmentHandle.class.getName() + ": 审批通过，待上级审批", true);
            // 进入下一级
            chain.handle(employee, chain);
        } else {
            employee.addHandleProcess("第二步-" + DepartmentHandle.class.getName() + ": 不批准", false);
        }
    }
}
