package schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//实体类书写要求
/*
1.实体类的类名和表格名应该对应(对应不是一致)
2.实体类的属性名和表格的列名应该对应
3.每个属性都必须是私有的
4.每个属性都必须有getter,setter
5.必须具备无参构造器
6.应该实现序列化接口(缓存，分布式项目数据传递可能会将数据序列化)
7.应该重写类的Hashcode和equals方法
 */
//可以通过Lombok帮助我们实现这些需求
@AllArgsConstructor//添加了全参构造
@NoArgsConstructor//添加了无参构造
@Data//添加了 getter setter equals hashcode toString
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
