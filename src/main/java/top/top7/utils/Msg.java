package top.top7.utils;

import lombok.Data;
import top.top7.pojo.Classes;

import java.util.List;

@Data
public class Msg {

    private List<Classes> list;
    private Integer page;
    private Long total;
}
