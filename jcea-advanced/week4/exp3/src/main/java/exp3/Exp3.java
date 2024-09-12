package exp3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
public class Exp3 {
    private static void mergeCol(XWPFTable table, int row, int beginCol, int endCol) {
        for (int i = beginCol; i <= endCol; i++) {
            XWPFTableCell tableCell = table.getRow(row).getCell(i);
            if (i == beginCol) {
                tableCell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            }
            else {
                tableCell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }
    private static void mergeRow(XWPFTable table, int col, int beginRow, int endRow) {
        for (int i = beginRow; i <= endRow; i++) {
            XWPFTableCell tableCell = table.getRow(i).getCell(col);
            if (i == beginRow) {
                tableCell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            }
            else {
                tableCell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }
    private static void setXWPFRun(XWPFTableCell tableCell, String text) {
        XWPFRun run = tableCell.getParagraphs().get(0).createRun();
        run.setText(text);
        run.setFontFamily("微软雅黑");
        run.setFontSize(12);
    }
    private static void setTitle(XWPFTable table) {
        mergeCol(table, 0, 0, 5);
        XWPFTableCell tableCell = table.getRow(0).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "20XX年全国硕士研究生招生考试准考证");
    }
    private static void setExaminee(XWPFTable table) {
        for (int i = 1; i <= 4; i++) {
            mergeCol(table, i, 0, 1);
            mergeCol(table, i, 2, 4);
        }
        XWPFTableCell tableCell = null;
        tableCell = table.getRow(1).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "考生编号");
        tableCell = table.getRow(1).getCell(2);
        setXWPFRun(tableCell, "114514");
        tableCell = table.getRow(2).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "考生姓名/性别");
        tableCell = table.getRow(2).getCell(2);
        setXWPFRun(tableCell, "李田所/男");
        tableCell = table.getRow(3).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "证件类型/号码");
        tableCell = table.getRow(3).getCell(2);
        setXWPFRun(tableCell, "居民身份证/******************");
        tableCell = table.getRow(4).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "学习工作单位");
        tableCell = table.getRow(4).getCell(2);
        setXWPFRun(tableCell, "下北泽");
    }
    private static void setExamineePhoto(XWPFTable table, String path) {
        mergeRow(table, 5, 1, 4);
        XWPFTableCell tableCell = table.getRow(1).getCell(5);
        tableCell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        try {
            File file = new File(path);
            tableCell.getParagraphs().get(0).createRun().addPicture(new FileInputStream(file), XWPFDocument.PICTURE_TYPE_JPEG, file.getName(), Units.toEMU(100), Units.toEMU(100));
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    private static void setApplication(XWPFTable table) {
        for (int i = 5; i <= 6; i++) {
            mergeCol(table, i, 0, 1);
            mergeCol(table, i, 2, 5);
        }
        XWPFTableCell tableCell = null;
        tableCell = table.getRow(5).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "报考单位（代码）");
        tableCell = table.getRow(5).getCell(2);
        setXWPFRun(tableCell, "下北泽大学（114）");
        tableCell = table.getRow(6).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "报考专业（代码）");
        tableCell = table.getRow(6).getCell(2);
        setXWPFRun(tableCell, "池沼（514）");
    }
    private static void setExamTime(XWPFTable table) {
        for (int i = 7; i <= 9; i++) {
            mergeCol(table, i, 0, 1);
            mergeCol(table, i, 2, 3);
            mergeCol(table, i, 4, 5);
        }
        mergeCol(table, 10, 0, 1);
        mergeCol(table, 10, 2, 5);
        XWPFTableCell tableCell = null;
        tableCell = table.getRow(7).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "考试时间");
        tableCell = table.getRow(7).getCell(2);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "上午08:30-11:30");
        tableCell = table.getRow(7).getCell(4);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "下午14:00-17:00");
        tableCell = table.getRow(8).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "12月24日");
        tableCell = table.getRow(8).getCell(2);
        setXWPFRun(tableCell, "考试1");
        tableCell = table.getRow(8).getCell(4);
        setXWPFRun(tableCell, "考试2");
        tableCell = table.getRow(9).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "12月25日");
        tableCell = table.getRow(9).getCell(2);
        setXWPFRun(tableCell, "考试3");
        tableCell = table.getRow(9).getCell(4);
        setXWPFRun(tableCell, "考试4");
        tableCell = table.getRow(10).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "12月26日");
        tableCell = table.getRow(10).getCell(2);
        setXWPFRun(tableCell, "无");
    }
    private static void setExamVenue(XWPFTable table) {
        mergeCol(table, 11, 0, 1);
        mergeCol(table, 11, 4, 5);
        XWPFTableCell tableCell = null;
        tableCell = table.getRow(11).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "报考点名称（代码）");
        tableCell = table.getRow(11).getCell(2);
        setXWPFRun(tableCell, "下北泽大学（114）");
        tableCell = table.getRow(11).getCell(3);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "考生报名号");
        tableCell = table.getRow(11).getCell(4);
        setXWPFRun(tableCell, "114514");
    }
    private static void setInstruction(XWPFTable table) {
        for (int i = 12; i <= 14; i++) {
            mergeCol(table, i, 0, 1);
            mergeCol(table, i, 2, 5);
        }
        XWPFTableCell tableCell = null;
        tableCell = table.getRow(12).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "省级教育招生考试机构说明");
        tableCell = table.getRow(12).getCell(2);
        setXWPFRun(tableCell, "......");
        tableCell = table.getRow(13).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "报考点说明");
        tableCell = table.getRow(13).getCell(2);
        setXWPFRun(tableCell, "......");
        tableCell = table.getRow(14).getCell(0);
        tableCell.getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        setXWPFRun(tableCell, "招生单位说明");
        tableCell = table.getRow(14).getCell(2);
        setXWPFRun(tableCell, "......");
    }
    public static void generateAdmissionTicket(String path) {
        XWPFDocument doc = new XWPFDocument();
        try {
            XWPFTable table = doc.createTable(15, 6);
            table.setTableAlignment(TableRowAlign.CENTER);
            setTitle(table);
            setExaminee(table);
            setExamineePhoto(table, new File(path).getParentFile().getPath() + "/img.jpg");
            setApplication(table);
            setExamTime(table);
            setExamVenue(table);
            setInstruction(table);
            doc.write(new FileOutputStream(path));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                doc.close();
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String path = "./src/main/resources/admission-ticket.docx";
        try {
            generateAdmissionTicket(path);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}