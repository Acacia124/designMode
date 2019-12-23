package yin.zhang.entry;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    private String emId;
    private String name;
    private Integer days;
    private Map<String, Boolean> handleProcess = new HashMap<String, Boolean>(9);
    private boolean allowingOff;    // 最终处理结果

    public Employee(String emId, String name, int days) {
        this.emId = emId;
        this.name = name;
        this.days = days;
    }

    public Integer getDays() {
        return days;
    }

    public String getEmId() {
        return emId;
    }

    public String getName() {
        return name;
    }

    public Map<String, Boolean> getHandleProcess() {
        return Collections.unmodifiableMap(handleProcess);
    }

    public boolean isAllowingOff() {
        return allowingOff;
    }

    public void addHandleProcess(String className, boolean result) {
        if (className != null && !"".equals(className.trim())) {
            handleProcess.put(className, result);
            this.allowingOff = result;
        }
    }
}
