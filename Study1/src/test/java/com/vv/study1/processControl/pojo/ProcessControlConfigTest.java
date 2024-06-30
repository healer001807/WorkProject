package com.vv.study1.processControl.pojo;

import cn.hutool.core.util.ObjUtil;
import com.vv.study1.processControl.service.ProcessControlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class ProcessControlConfigTest {

    private ProcessControlConfig processControlConfigUnderTest;

//    @BeforeEach
    void setUp() {
        ProcessControlConfig processControlConfig = new ProcessControlConfig().setId("111").setOperatorScene("1");
        List<ProcessControlConfig> first = new LinkedList<>();
        first.add(processControlConfig);
        processControlConfig = new ProcessControlConfig().setId("2222").setOperatorScene("1");
        first.add(processControlConfig);

        processControlConfig = new ProcessControlConfig().setId("111").setOperatorScene("1");
        List<ProcessControlConfig> second = new LinkedList<>();
        second.add(processControlConfig);
        processControlConfig = new ProcessControlConfig().setId("333").setOperatorScene("1");
        second.add(processControlConfig);

        System.out.println(first);
        System.out.println(second);


    }

    @Test
    public void test() {
        List<ProcessControlConfig> first = new LinkedList<>();
        ProcessControlConfig processControlConfig = new ProcessControlConfig().setId("111").setOperatorScene("1");
        first.add(processControlConfig);
        ProcessControlConfig processControlConfig1 = new ProcessControlConfig().setId("2222").setOperatorScene("1");
        first.add(processControlConfig1);

        List<ProcessControlConfig> second = new LinkedList<>();
        ProcessControlConfig processControlConfig2 = new ProcessControlConfig().setId("111").setOperatorScene("2");
        second.add(processControlConfig2);
        ProcessControlConfig processControlConfig3 = new ProcessControlConfig().setId("333").setOperatorScene("2");
        second.add(processControlConfig3);

        System.out.println(first);
        System.out.println(second);

        List<ProcessControlConfig> collect = first.stream().filter(item -> second.stream().noneMatch(item1 -> ObjUtil.equal(item.getId(), item1.getId()))).
                collect(Collectors.toList());
        System.out.println(collect);

        List<ProcessControlConfig> intersection = first.stream().filter(second::contains).collect(Collectors.toList());
        System.out.println(intersection);

    }
}
