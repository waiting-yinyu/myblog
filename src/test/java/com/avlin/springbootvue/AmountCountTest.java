package com.avlin.springbootvue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import java.util.List;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年3月4日
*/

@RunWith(SpringJUnit4ClassRunner.class)
public class AmountCountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void amountCount() {
		List<String> list = mock(List.class);
		
        //设置方法的预期返回值  
        when(list.get(0)).thenReturn("helloworld");  

        String result = list.get(0);  

        //验证方法调用(是否调用了get(0))  
        verify(list).get(0);  

        //junit测试  
        Assert.assertEquals("helloworld", result);  
	}

}
