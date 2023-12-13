package sesac.mybatis.sesacmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.mybatis.sesacmybatis.domain.Table;
import sesac.mybatis.sesacmybatis.dto.TableDTO;
import sesac.mybatis.sesacmybatis.entity.BoardEntity;
import sesac.mybatis.sesacmybatis.mapper.TableMapper;
import sesac.mybatis.sesacmybatis.repository.TableRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    @Autowired
    TableMapper tableMapper;

    public List<TableDTO> getTableList() {
        List<Table> table = tableMapper.showAll();
        List<TableDTO> result = new ArrayList<>();

        for(Table one : table) {
            String id = Integer.toString(one.getId());

            TableDTO tabledto = TableDTO.builder()
                    .no(one.getWriter() + id)
                    .id(one.getId())
                    .title(one.getTitle())
                    .content(one.getContent())
                    .writer(one.getWriter())
                    .registered(one.getRegistered())
                    .build();

            result.add(tabledto);
        }
            return result;
    }

    public void insertOne(Table table) {
//        tableMapper.insertOne(table);

        // JPA
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(table.getTitle());
        boardEntity.setContent(table.getContent());
        boardEntity.setWriter(table.getWriter());

        tableRepository.save(boardEntity);
    }

    public void updateOne(Table table) { tableMapper.updateOne(table); }

    public void deleteOne(int id) { tableMapper.deleteOne(id); }

    // JPA
    @Autowired
    TableRepository tableRepository;

    public List<TableDTO> getTableList2() {
        List<BoardEntity> boards = tableRepository.findAll();
        List<TableDTO> result = new ArrayList<>();

        for(BoardEntity board : boards) {
            TableDTO tableDTO = TableDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(board.getRegistered())
                    .build();
            result.add(tableDTO);
        }

        return result;
    }
}
