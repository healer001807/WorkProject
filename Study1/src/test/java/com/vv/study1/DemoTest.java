package com.vv.study1;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.vv.study1.pojo.dto.UserDto;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 12 - 27 21:56
 **/
@SpringBootTest
public class DemoTest {

    @Test
    public void test() throws IOException {
        File file = new File("D:\\study\\掘金图\\1.jpg");
        InputStream inputStream = new FileInputStream(file);

        FileUtils.copyToFile(inputStream, new File("D:\\study\\temp\\aa\\bb\\a.jpg"));
    }

    @Test
    public void test2() {
        UserDto userDto = new UserDto();
        userDto.setUserName("");
        UserDto build = UserDto.builder().build();
        if (StrUtil.isNotBlank(userDto.getUserName())) {
            build.setUserName(userDto.getUserName());
        }
        System.out.println(JSONUtil.toJsonStr(build));
    }

    @Test
    public void test1() throws NoSuchAlgorithmException {
        String uuid = StrUtil.uuid();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(uuid.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(String.format("%02x", b));
        }
        System.out.println(stringBuilder.toString());

        System.out.println("-----------------解密");

    }
}
