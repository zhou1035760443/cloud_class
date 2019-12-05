package top.top7.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/12/4.
 */
@Data
public class Class_sort1 {
    private Integer class_sort1_id;
    private String class_sort1_name;
    private List<Class_sort2> class_sort2;
}
