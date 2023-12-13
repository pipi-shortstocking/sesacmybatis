package sesac.mybatis.sesacmybatis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="board")
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String writer;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date registered;
}
