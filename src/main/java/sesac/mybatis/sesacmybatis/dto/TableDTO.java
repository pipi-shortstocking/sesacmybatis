package sesac.mybatis.sesacmybatis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TableDTO {
    private int id;
    private String title, content, writer;
    private Date registered;
    private String no;
}
