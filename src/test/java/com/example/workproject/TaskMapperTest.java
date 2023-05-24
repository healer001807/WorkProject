package com.example.workproject;

import com.example.workproject.mapper.TaskMapper;
import com.example.workproject.pojo.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 05 - 23 22:34
 **/

@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void insertTask() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskSeq(UUID.randomUUID().toString().replace("-", ""));
        taskDTO.setTaskType("0");
        System.out.println(taskMapper.insertTask(taskDTO));
    }
}
