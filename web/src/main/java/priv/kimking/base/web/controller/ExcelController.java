package priv.kimking.base.web.controller;

import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.kimking.base.web.aop.annotation.ExcelResp;
import priv.kimking.base.web.entity.Excel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/18
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Excel> modelList = new ArrayList<>();
        Excel excel = new Excel();
        excel.setP1("p11");
        excel.setP2("p22");
        modelList.add(excel);

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String fileName = URLEncoder.encode("请假列表", StandardCharsets.UTF_8.name());
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Excel.class).sheet("请假列表").doWrite(modelList);
    }

    @ExcelResp
    @GetMapping("/download")
    public List<Excel> download() {
        List<Excel> modelList = new ArrayList<>();
        Excel excel = new Excel();
        excel.setP1("p11");
        excel.setP2("p22");
        modelList.add(excel);
        return modelList;
    }

}
