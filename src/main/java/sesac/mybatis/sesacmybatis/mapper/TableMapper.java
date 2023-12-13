package sesac.mybatis.sesacmybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sesac.mybatis.sesacmybatis.domain.Table;

import java.util.List;


@Mapper
public interface TableMapper {
    List<Table> showAll();

    // insert, update, delete는 return 되는 객체가 없음
    void insertOne(Table table);

    void updateOne(Table table);

    void deleteOne(int id);
}
