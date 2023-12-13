package sesac.mybatis.sesacmybatis.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Table {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date registered;
}
