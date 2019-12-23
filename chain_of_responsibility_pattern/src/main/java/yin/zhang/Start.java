package yin.zhang;

import com.alibaba.fastjson.JSON;
import yin.zhang.entry.Employee;
import yin.zhang.handle.CommissarHandle;
import yin.zhang.handle.DepartmentHandle;
import yin.zhang.handle.LeaderHandle;
import yin.zhang.handle.OffChain;

public class Start {
    public static void main(String[] args) {
        OffChain offChain = new OffChain(5);
        offChain.addHandle(new LeaderHandle())
                .addHandle(new DepartmentHandle())
                .addHandle(new CommissarHandle());
        Employee employee = new Employee("11111111", "张大帅", 10);
        offChain.handle(employee, offChain);
        System.out.println(employee.getName());
        System.out.println(JSON.toJSONString(employee.getHandleProcess()));
        System.out.println(employee.isAllowingOff());
    }
}
