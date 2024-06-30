package com.vv.study1.service;

import com.vv.study1.pojo.vo.LocationVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RestTemplateServiceImplTest {

    @Mock
    private RestTemplate mockRestTemplate;

    @InjectMocks
    private RestTemplateServiceImpl restTemplateServiceImplUnderTest;

    @Test
    void testPostForEntity() {
        LocationVo locationVo = LocationVo.builder().lat("1854.0").lng("452.0").build();
        assertThat(restTemplateServiceImplUnderTest.postForEntity("http://localhost:8881/upload/downLoad", locationVo)).isEqualTo("result");
    }
}
