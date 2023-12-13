package sesac.mybatis.sesacmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import sesac.mybatis.sesacmybatis.domain.Table;
import sesac.mybatis.sesacmybatis.dto.TableDTO;
import sesac.mybatis.sesacmybatis.service.TableService;

import java.util.List;

@Controller
public class TableController {
    @Autowired
    TableService tableService;

    @GetMapping("board")
    public String getTable(Model model) {
        List<TableDTO> table = tableService.getTableList2();
//        List<TableDTO> table = tableService.getTableList();
        model.addAttribute("list", table);

        return "table";
    }

    @PostMapping("board")
    public String writeTable(@RequestBody TableDTO tableDTO, Model model ){
        Table table = new Table();
        table.setTitle(tableDTO.getTitle());
        table.setContent(tableDTO.getContent());
        table.setWriter(tableDTO.getWriter());

        tableService.insertOne(table);

        return "redirect:/";
    }

    @PatchMapping("board")
    @ResponseBody
    public void updateOne(@RequestBody Table table) {
//        tableService.updateOne(table);

        // JPA

    }

    @DeleteMapping("board")
    @ResponseBody
    public void deleteOne(@RequestParam int id) {
        tableService.deleteOne(id);
    }
}
