import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.future.shardingdemo.ShardingJDBCApplication;
import com.future.shardingdemo.entity.Course;
import com.future.shardingdemo.entity.Dict;
import com.future.shardingdemo.entity.User;
import com.future.shardingdemo.mapper.CourseMapper;
import com.future.shardingdemo.mapper.DictMapper;
import com.future.shardingdemo.mapper.UserMapper;

import net.minidev.json.JSONArray;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJDBCApplication.class)
public class ShardingJDBCApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    //添加课程
    // @Test
    @RepeatedTest(100)
    public void addCourse() {
        Course course = new Course();
        //cid由我们设置的策略，雪花算法进行生成
        course.setCname("Java");
        course.setUserId(100L);
        course.setStatus("Normal");
        courseMapper.insert(course);
    }

    @Test
    public void testShuipingFenkuPaging() {
        Page<Course> page = new Page<>(1, 10);

        IPage<Course> courseIPage =   courseMapper.selectPage(page, null);
        System.out.println(JSON.toJSONString(courseIPage));
    }



    @Test
    @RepeatedTest(50)
    public void addCourseWithShuipingFenkuFenbiao() {
        Course course = new Course();
        //cid由我们设置的策略，雪花算法进行生成
        course.setCname("python");
        //分库根据user_id
        course.setUserId(100L);
        course.setStatus("Normal");
        courseMapper.insert(course);

        course.setCname("c++");
        course.setUserId(111L);
        courseMapper.insert(course);
    }

    @Test
    public void testShuipingFenkuFenbiaoPaging() {
        Page<Course> page = new Page<>(1, 10);

        IPage<Course> courseIPage =   courseMapper.selectPage(page, null);
        System.out.println(JSON.toJSONString(courseIPage));
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("Jack");
        user.setStatus("Normal");
        userMapper.insert(user);
    }

    @Test
    public void findUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 1083437238420766721L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Autowired
    private DictMapper dictMapper;

    @Test
    public void addDict() {
        Dict dict = new Dict();
        dict.setStatus("Normal");
        dict.setValue("启用");
        dictMapper.insert(dict);
    }

    @Test
    public void deleteDict() {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("dict_id", 1083874902877929473L);
        dictMapper.delete(wrapper);
    }


    @RepeatedTest(10)
    public void masterSlaveAddUser(){
        User user = new User();
        user.setUsername("Jack");
        user.setStatus("Normal");
        userMapper.insert(user);
    }

    // @Test
    @RepeatedTest(10)
    public void masterSlaveFindUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 1084142407445905408L);
        userMapper.selectOne(wrapper);
    }

}