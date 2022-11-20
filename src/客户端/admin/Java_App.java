package 客户端.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Mysql.Mysql;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @version 1.0
 * @author zhengyu 主要是用来创建excel工作薄
 */
public class Java_App {

    /**
     * 按照数据库中查询到的结果集创建一个新的工作薄，建议传入参数为Resultset结果集
     *
     * @param fileName
     *            包含文件的路径以及文件名
     * @param rs
     * @throws Exception
     */
    public void WriteExcel(File fileName, ResultSet rs) throws Exception {

        // 创建一个新的工作薄，fileName 包含了文件名以及路径。
        WritableWorkbook wwb = null;
        WritableSheet ws = null;
        try {
            wwb = Workbook.createWorkbook(fileName);
            ws = wwb.createSheet("sheettest", 0);// 给工作薄添加一个工作表，命名为 sheettest.
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int i = 0;
        int j = 0;

        // 下面for循环里面的rs.getMetaData().GetColumnCount() 获取数据库中某个表的列总数
        for (int k = 0; k < rs.getMetaData().getColumnCount(); k++) {
            // rs.getMetaData().getColumnName()获取表的列名。并添加到 excel表Label里
            ws.addCell(new Label(k, 0, rs.getMetaData().getColumnName(k + 1)));
        }
        while (rs.next()) {
            // 算法，依次添加数据库中所有符合的数据到excel中
            for (int k = 0; k < rs.getMetaData().getColumnCount(); k++) {
                ws.addCell(new Label(k, j + i + 1, rs.getString(k + 1)));
            }
            i++;
        }
        wwb.write();// 写入工作薄
        wwb.close();// 关闭工作薄
        rs.close();// 关闭结果集
    }
}