package cn.itsource.test;

import cn.itsource.model.Position;
import cn.itsource.service.PositionService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PositionTest {

    @Autowired
    private PositionService positionService;

    @Test
    public void testName() throws Exception{
        PageInfo<Position> pages = positionService.queryPageListByParams(1, 10, new Position());
        pages.getList().forEach(e-> System.out.println(e));
    }
}
