package sesac.mybatis.sesacmybatis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesac.mybatis.sesacmybatis.entity.BoardEntity;

import java.util.List;

public interface TableRepository extends JpaRepository<BoardEntity, Integer> {

}
